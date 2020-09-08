package com.cxysl.controller;

import com.cxysl.entity.OrderDetails;
import com.cxysl.service.GoodsServie;
import com.cxysl.service.OrderDetailsService;
import com.cxysl.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class OrderDetailsServlet {
    @Autowired
    private OrderDetailsService service;
    @Autowired
    private OrdersService service0;
    @Autowired
    private GoodsServie service2;

    /**
     * 查
     * 根据订单Id查订单详情
     * orderId
     * @return
     */
    @GetMapping("/queryAllOrderDetails")
    public Map<String,Object> queryAllOrderDetails(Integer orderId){
        System.out.println("正在加载订单详情……");

        List list3 = new ArrayList<>();
        List<OrderDetails> list = service.queryAllOrderDetails(orderId);
        List list2 = new ArrayList<>();
        for (OrderDetails g :list
                ) {
            list2.add(service2.getGoodsOne(g.getGoodsId()).getGoodsPicture());
        }

        list3.add(list);list3.add(list2);
        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",list3);
        return map;
    }

    /**
     * 增
     * 添加一条订单明细信息
     * @param list
     * @return
     * json写法如下:
     * [
     * {"goodsId":31,"goodsName":"水杯","buyCount":1,"goodsPrice":60},
     * {"goodsId":32,"goodsName":"衬衣","buyCount":1,"goodsPrice":120}
     * ]
     */
    @PostMapping("/add_OrderDetails")
    public Map<String,Object> add_OrderDetails(@RequestBody List<OrderDetails> list){
        System.out.println("正在为您添加订单详情……");

        /** 用户下单时同时添加订单和订单详情，但实际有时间差，先添加订单，
         * 因此订单详情中的订单号即为订单表中最后一条记录的订单号（即刚添加的订单）*/

        Integer orderId = service0.getrderLastOne().getOrderId();   //获取订单号

        List<OrderDetails> list2 = new ArrayList<OrderDetails>();
        for (OrderDetails od:list
             ) {
            int flag = service.add_OrderDetails(od,orderId);
            od.setOrderId(orderId);
            list2.add(od);
            if(flag==1){
                System.out.println("添加成功");
            }
        }

        //service0.Update_OrderSumPrice(orderId);//算订单总价

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","订单详情添加成功!!!");
        map.put("data",list2);
        return map;
    }
}
