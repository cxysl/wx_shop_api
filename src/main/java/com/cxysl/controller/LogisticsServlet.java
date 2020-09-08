package com.cxysl.controller;

import com.cxysl.comm.Numer;
import com.cxysl.entity.Customer;
import com.cxysl.entity.Logistics;
import com.cxysl.service.CustomerServie;
import com.cxysl.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class LogisticsServlet {
    @Autowired
    private LogisticsService service;
    @Autowired
    private CustomerServie service0;

    /**
     * 查
     * 根据订单ID查找对应的物流信息
     * @param orderId
     * @return
     */
    @GetMapping("/getLogisticsOneByOrderId")
    public Map<String,Object> getLogisticsOneByOrderId(Integer orderId){
        System.out.println("正在查找该条信息……");

        Logistics logistics = service.getLogisticsOneByOrderId(orderId);

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",logistics);
        return map;
    }

    /**
     * 添加新物流信息
     * @param logistics
     * @return
     * 参数:
     * orderId
     * customerId
     */
    @PostMapping("/add_Logistics")
    public Map<String,Object> add_Logistics(@RequestBody Logistics logistics){

        System.out.println("正在添加物流信息……");

        String expressId = Numer.getRandomReqNo();      //流水号
        Customer customer = service0.getCustomerOne(logistics.getCustomerId()); //根据顾客ID找到该顾客对象 v
        System.out.println(logistics.getOrderId());     //订单号v

        logistics.setExpressId(expressId);  //流水号
        logistics.setCustomerName(customer.getCustomerName());  //收货人姓名、顾客名字
        logistics.setCustomerAddress(customer.getCustomerAddress());   //顾客地址
        logistics.setCustomerPhone(customer.getCustomerPhone());    //顾客电话号码
        logistics.setLogisticsState("待发货");     //物流状态
        logistics.setLogisticsAddress("武汉");    //商品发货地点

        int flag = service.add_Logistics(logistics);

        if(flag==1){
            System.out.println("添加成功");
        }

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","注册成功!!!");
        map.put("data",logistics);
        return map;
    }

    /**
     * 修改物流状态信息
     * @return
     */
    @PutMapping("/Update_LogisticsState")
    public Map<String,Object> Update_LogisticsState(String expressId){

        String logisticsState = service.getLogisticsOne(expressId).getLogisticsState();     //当前物流状态
        String newState = null;
        if(logisticsState.equals("待发货")){newState = "待收货";}
        else if(logisticsState.equals("待收货")){newState = "已收货";}
        else if(logisticsState.equals("已收货")){newState = "已收货";}
        else newState = "待发货";
        int flag = service.Update_LogisticsState(newState,expressId);

        Logistics logistics = service.getLogisticsOne(expressId);
        if(flag==1){ System.out.println("修改成功"); }

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","修改成功!!!");
        map.put("data",logistics);
        return map;
    }
}
