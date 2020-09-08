package com.cxysl.controller;

import com.cxysl.entity.CustomerLogin;
import com.cxysl.service.CustomerLoginService;
import com.cxysl.service.CustomerServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class CustomerLoginServlet {
    @Autowired
    private CustomerLoginService service;

    @Autowired
    private CustomerServie service2;

    /**
     * 查
     * 登录验证
     * @param username
     * @param pwd
     * @return
     */
    @GetMapping("/CustomerLogin")
    public Map<String,Object> CustomerLogin(String username, String pwd){
        System.out.println("正在登录验证……");

        Map<String,Object> map = new ConcurrentHashMap<>();

        CustomerLogin user = service.CustomerLogin(username,pwd);
        if (user==null){        //没找到，登录失败
            System.out.println("登录失败!");
            String str = "验证失败";
            map.put("code",new Integer(404));
            map.put("msg","没找到");
            map.put("data",str);
        }else{
            System.out.println("登录成功!");
            map.put("code",new Integer(100000));
            map.put("msg","查询成功!!!");
            map.put("data",user);
        }
        return map;
    }

    /**
     * 增（注册）
     * @param user
     *json
     * {
     *    "username":"李连杰",
     *    "pwd":"9527"
     * }
     * @return
     */
    @PostMapping("/add_CustomerLogin")
    public Map<String,Object> add_CustomerLogin(@RequestBody CustomerLogin user){
        System.out.println("正在注册您的信息……");


        System.out.println("id:"+service2.getCustomerLastOne().getCustomerId());
        user.setCustomerId(service2.getCustomerLastOne().getCustomerId());
        int flag = service.add_CustomerLogin(user);

        if(flag==1){
            System.out.println("注册成功");
        }

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","注册成功!!!");
        map.put("data",user);
        return map;
    }

}
