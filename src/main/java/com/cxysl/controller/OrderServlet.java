package com.cxysl.controller;

import com.cxysl.entity.Orders;
import com.cxysl.service.CustomerServie;
import com.cxysl.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class OrderServlet {
    @Autowired
    private OrdersService service;

    @Autowired
    private CustomerServie service2;
    /**
     *查
     * 根据顾客ID查询已有的订单
     * @return
     */
    @GetMapping("/queryAllOrder")
    public Map<String,Object> queryAllOrder(Integer customerId){
        System.out.println("正在查找您的所有订单……");

        List<Orders> list = service.queryAllOrder(customerId);

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",list);
        return map;
    }

    /**
     * 增（下订单）
     * customerName、customerId
     * @param orders
     * @return
     * {
     * 	"customerId":9,
     * 	"orderPrice":320
     * }
     */
    @PostMapping("/add_Order")
    public Map<String,Object> add_Order(@RequestBody Orders orders){
        System.out.println("正在为您添加订单……");
        System.out.println("顾客ID:"+orders.getCustomerId());//判断是否接收到前台传来的参数
        System.out.println("订单总价:"+orders.getOrderPrice());
        if (orders.getCustomerName()==null||orders.getCustomerName().length()==0){
            orders.setCustomerName(service2.getCustomerOne(orders.getCustomerId()).getCustomerName());//下单人名字
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd  HH:mm");       //格式化日期
        String OrderDate =   dateFormat.format( new Date() );        //下单时间
        orders.setOrderDate(OrderDate);
        orders.setOrderState("待付款");    //订单状态初始值
        orders.setOrderPrice(orders.getOrderPrice());//订单总金额
        int flag = service.add_Order(orders);
        System.out.println("id:"+service.getrderLastOne().getOrderId());
        orders.setOrderId(service.getrderLastOne().getOrderId());
        if(flag==1){
            System.out.println("添加成功");
        }
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","订单添加成功!!!");
        map.put("data",orders);
        return map;
    }


    /**
     * 改
     * 支付成功后修改订单状态
     * @param a
     * @return
     */
    @PutMapping("/Update_OrderState")
    public Map<String,Object> Update_OrderState(Integer a){

        String OrderState = service.getOrderOne(a).getOrderState();
        String newState = null;
        if(OrderState.equals("待付款")){newState = "已支付";}
        else if(OrderState.equals("已支付")){newState = "已支付";}
        else newState = "待付款";
        int flag = service.Update_OrderState(newState,a);
        Orders orders = service.getOrderOne(a);
        if(flag==1){ System.out.println("修改成功"); }
/** 这里要同时要增加物流信息 */
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","修改成功!!!");
        map.put("data",orders);
        return map;
    }

}
