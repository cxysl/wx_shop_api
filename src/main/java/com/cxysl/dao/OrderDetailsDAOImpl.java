package com.cxysl.dao;


import com.cxysl.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailsDAOImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查
     * 根据订单Id查订单详情
     * orderId
     * @return
     */
    public List<OrderDetails> queryAllOrderDetails(Integer id){

        String sql = "select * from orderDetails where orderId=?";
        RowMapper<OrderDetails> rowMapper = new BeanPropertyRowMapper<>(OrderDetails.class);
        List<OrderDetails> list = jdbcTemplate.query(sql,rowMapper,id);
        return list;
    }

    /**
     * 增
     * 添加一条订单明细信息
     * @param p
     * @return
     */
    public int add_OrderDetails(OrderDetails p,Integer orderId)
    {
        String sql = "insert into orderDetails values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,p.getGoodsId(),p.getGoodsName(),p.getBuyCount(),p.getGoodsPrice(),orderId);
    }
}
