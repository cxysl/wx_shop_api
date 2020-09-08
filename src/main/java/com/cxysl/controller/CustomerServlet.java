package com.cxysl.controller;

import com.cxysl.entity.Customer;
import com.cxysl.service.CustomerServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class CustomerServlet {

    @Autowired
    private CustomerServie service;

    /**
     * 查
     * 顾客查自己信息
     * @param customerId
     * @return
     */
    @GetMapping("/queryOneCustomer")
    public Map<String,Object> queryOneCustomer(Integer customerId){
        System.out.println("正在查找您的信息……");
        System.out.println(customerId);

        Customer customer = service.getCustomerOne(customerId);

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",customer);
        return map;
    }

    /**
     * 增（注册）
     * @param customer
     * @return
     * json
     * {
     *     "customerName":"李连杰",
     *     "customerSex":"男",
     *     "customerPhone":"7.88414",
     *     "customerAddress":"香港",
     *     "customerPicture":"http://101.200.144.60:9000/images/WX_img/none.jpg"
     * }
     */
    @PostMapping("/add_Customer")
    public Map<String,Object> add_Customer(@RequestBody Customer customer){
        System.out.println("正在注册您的信息……");
        if(customer.getCustomerPicture()==null||customer.getCustomerPicture().length()==0){
            customer.setCustomerPicture("http://101.200.144.60:9000/images/WX_img/none.jpg");
        }if(customer.getCustomerSex()==null||customer.getCustomerSex().length()==0){
            customer.setCustomerSex("私密");
        }

        int flag = service.add_Customer(customer);
        System.out.println("id:"+service.getCustomerLastOne().getCustomerId());
        customer.setCustomerId(service.getCustomerLastOne().getCustomerId());

        if(flag==1){
            System.out.println("注册成功");
        }

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","注册成功!!!");
        map.put("data",customer);
        return map;
    }

    /**
     * 改
     * 整体修改个人信息
     * @param customer
     * @return
     *
     * 姓名，手机号，地址不允许为空。
     */
    @PutMapping("/Update_Customer")
    public Map<String,Object> Update_Customer(@RequestBody Customer customer,Integer id){

        Customer user = service.getCustomerOne(id);
        if(customer.getCustomerSex()==null||customer.getCustomerSex().length()==0){
            customer.setCustomerSex(user.getCustomerSex());
        }
        customer.setCustomerPicture(user.getCustomerPicture());
        customer.setCustomerId(id);

        int flag = service.Update_Customer(customer,id);
        customer.setCustomerId(service.getCustomerOne(id).getCustomerId());
        if(flag==1){
            System.out.println("修改成功");
        }

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","修改成功!!!");
        map.put("data",customer);
        return map;
    }

    /**
     * 改
     * 修改收货地址
     * @param
     * @param customerAddress
     * @return
     */
    @PutMapping("/Update_CustomerAddress")
    public Map<String,Object> Update_CustomerAddress(Integer id,String customerAddress){

        int flag = service.Update_CustomerAddress(id,customerAddress);
        Customer customer = service.getCustomerOne(id);
        if(flag==1){ System.out.println("修改成功"); }

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","修改成功!!!");
        map.put("data",customer);
        return map;
    }
}
