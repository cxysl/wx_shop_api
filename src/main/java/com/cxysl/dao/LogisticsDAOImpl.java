package com.cxysl.dao;

import com.cxysl.entity.Logistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LogisticsDAOImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查
     * 根据订单ID查找对应的物流
     * @param orderId
     * @return
     */
    public Logistics getLogisticsOneByOrderId(Integer orderId)
    {
        String sql = "select * from logistics where orderId=?";
        RowMapper<Logistics> rowMapper = new BeanPropertyRowMapper<>(Logistics.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,orderId);
    }

    /**
     * 查
     * 查找单个物流信息（根据物流单号找）
     * @param expressId
     * @return
     */
    public Logistics getLogisticsOne(String expressId)
    {
        String sql = "select * from logistics where expressId=?";
        RowMapper<Logistics> rowMapper = new BeanPropertyRowMapper<>(Logistics.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,expressId);
    }

    /**
     * 添加新物流信息
     * @param p
     * @return
     */
    public int add_Logistics(Logistics p)
    {
        String sql = "insert into logistics values(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,p.getExpressId(),p.getOrderId(),p.getCustomerId(),p.getCustomerName(),
                p.getCustomerAddress(),p.getCustomerPhone(),p.getLogisticsState(),p.getLogisticsAddress());
    }

    /**
     * 修改物流状态信息
     * @param state
     * @param id
     * @return
     */
    public int Update_LogisticsState(String state, String id)
    {
        String sql = "update logistics set logisticsState=? where expressId=?";
        return jdbcTemplate.update(sql,state,id);
    }
}
