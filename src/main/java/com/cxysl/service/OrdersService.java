package com.cxysl.service;

import com.cxysl.dao.OrdersDAOImpl;
import com.cxysl.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersDAOImpl dao;

    /**
     * 查
     * 根据顾客ID查询已有的订单
     * customerId
     * @return
     */
    public List<Orders> queryAllOrder(Integer id){
        return dao.queryAllOrder(id);
    }

    /**
     * 查
     * 根据订单ID查找单个订单
     * @param id
     * orderId
     * @return
     */
    public Orders getOrderOne(Integer id)
    {
        return dao.getOrderOne(id);
    }

    /**
     * 查
     * 查找最后一个对象
     * @return
     */
    public Orders getrderLastOne(){
        return dao.getrderLastOne();
    }

    /**
     * 增（下订单）
     * 添加新订单信息
     * @param p
     * @return
     */
    public int add_Order(Orders p){
        return dao.add_Order(p);
    }

    /**
     * 改
     * 支付成功后修改订单状态
     * @param OrderState
     * @param a
     * orderId
     * @return
     */
    public int Update_OrderState(String OrderState,Integer a)
    {
        return dao.Update_OrderState(OrderState,a);
    }

    /**
     * 计算id为的订单消费总金额
     * @param id
     * orderId
     * @return
     */
    public int Update_OrderSumPrice(Integer id)
    {
       return dao.Update_OrderSumPrice(id);
    }

}
