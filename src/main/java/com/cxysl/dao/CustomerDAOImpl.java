package com.cxysl.dao;

import com.cxysl.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查
     * 根据ID查找顾客信息
     * @param customerId
     * @return
     */
    public Customer getCustomerOne(Integer customerId)
    {
        String sql = "select * from customer where customerId=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,customerId);
    }

    /**
     * 查找最后一个对象
     * @return
     */
    public Customer getCustomerLastOne(){
        String sql = "select * from customer order by customerId Desc limit 1;";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.queryForObject(sql,rowMapper);
    }


    /**
     * 改
     * 顾客自己改自己的个人信息
     * @param p
     * @return
     */
    public int Update_Customer(Customer p,Integer id)
    {
        String sql = "update customer set customerName=?,customerSex=?,customerPhone=?," +
                "customerAddress=?,customerPicture=? where customerId=?";
        return jdbcTemplate.update(sql,p.getCustomerName(),p.getCustomerSex(),
                p.getCustomerPhone(),p.getCustomerAddress(),
                p.getCustomerPicture(),id);
    }


    /**
     * 改
     * 顾客自己改自己的收货地址信息
     * @param id
     * @return
     */
    public int Update_CustomerAddress(Integer id,String customerAddress)
    {
        String sql = "update customer set customerAddress=? where customerId=?";
        return jdbcTemplate.update(sql,customerAddress,id);
    }

    /**
     * 增（注册）
     * 添加顾客信息
     * @param p
     * @return
     */
    public int add_Customer(Customer p)
    {
        String sql = "insert into customer values(null,?,?,?,?,?)";
        return jdbcTemplate.update(sql,p.getCustomerName(),p.getCustomerSex(),
                p.getCustomerPhone(),p.getCustomerAddress(),p.getCustomerPicture());
    }
}
