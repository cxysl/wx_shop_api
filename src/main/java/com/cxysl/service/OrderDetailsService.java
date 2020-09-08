package com.cxysl.service;

import com.cxysl.dao.OrderDetailsDAOImpl;
import com.cxysl.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsDAOImpl dao;

    /**
     * 查
     * 根据订单Id查订单详情
     * orderId
     * @return
     */
    public List<OrderDetails> queryAllOrderDetails(Integer id){

        return dao.queryAllOrderDetails(id);
    }

    /**
     * 增
     * 添加一条订单明细信息
     * @param p
     * @return
     */
    public int add_OrderDetails(OrderDetails p,Integer orderId)
    {
        return dao.add_OrderDetails(p,orderId);
    }
}
