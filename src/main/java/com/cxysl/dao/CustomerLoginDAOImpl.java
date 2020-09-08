package com.cxysl.dao;

import com.cxysl.entity.CustomerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerLoginDAOImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 登录验证
     * @return
     */
    public CustomerLogin CustomerLogin(String username, String pwd) {
        String sql = "select * from customerLogin where username=? and pwd=?";
        RowMapper<CustomerLogin> rowMapper = new BeanPropertyRowMapper<>(CustomerLogin.class);
        CustomerLogin u =null;
        try {
            u = jdbcTemplate.queryForObject(sql,rowMapper,username,pwd);
        }catch (EmptyResultDataAccessException e){
            System.out.println("111");
            return  null;
        }
        if (null==u){
            System.out.println("1111");
        }
        return u;
    }

    /**
     * 查
     * 根据ID查找顾客账号信息
     * @param customerId
     * @return
     */
    public CustomerLogin getCustomerLoginOne(Integer customerId)
    {
        String sql = "select * from customerLogin where customerId=?";
        RowMapper<CustomerLogin> rowMapper = new BeanPropertyRowMapper<>(CustomerLogin.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,customerId);
    }

    /**
     * 增（注册）
     * 添加顾客信息
     * @param p
     * @return
     */
    public int add_CustomerLogin(CustomerLogin p)
    {
        String sql = "insert into customerLogin values(?,?,?)";
        return jdbcTemplate.update(sql,p.getUsername(),p.getPwd(),p.getCustomerId());
    }
}
