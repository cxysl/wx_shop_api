package com.cxysl.dao;

import com.cxysl.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDAOImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查
     * 根据顾客ID查询已有的订单
     * customerId
     * @return
     */
    public List<Orders> queryAllOrder(Integer id){

        String sql = "select * from orders where customerId=?";
        RowMapper<Orders> rowMapper = new BeanPropertyRowMapper<>(Orders.class);
        List<Orders> list = jdbcTemplate.query(sql,rowMapper,id);
        return list;
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
        String sql = "select * from orders where orderId=?";
        RowMapper<Orders> rowMapper = new BeanPropertyRowMapper<>(Orders.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    /**
     * 查
     * 查找最后一个对象
     * @return
     */
    public Orders getrderLastOne(){
        String sql = "select * from orders order by orderId Desc limit 1;";
        RowMapper<Orders> rowMapper = new BeanPropertyRowMapper<>(Orders.class);
        return jdbcTemplate.queryForObject(sql,rowMapper);
    }

    /**
     * 增（下订单）
     * 添加新订单信息
     * @param p
     * @return
     */
    public int add_Order(Orders p)
    {
        String sql = "insert into orders values(null,?,?,?,?,?)";
        return jdbcTemplate.update(sql,p.getCustomerName(),p.getCustomerId(),p.getOrderPrice(),p.getOrderDate(),p.getOrderState());
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
        String sql = "update orders set orderState=? where orderId=?";
        return jdbcTemplate.update(sql,OrderState,a);
    }

    /**
     * 改
     * 计算id为的订单消费总金额
     * @param id
     * orderId
     * @return
     */
    public int Update_OrderSumPrice(Integer id)
    {
        String sql = "update orders o set orderPrice=(select sum(od.goodsPrice*od.buyCount) from orderDetails od where od.orderId=?) where o.orderId=?;";
        return jdbcTemplate.update(sql,id,id);
    }
}
