package com.cxysl.service;

import com.cxysl.dao.CustomerDAOImpl;
import com.cxysl.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServie {
    @Autowired
    private CustomerDAOImpl dao;

    /**
     * 查
     * 根据ID查找顾客信息
     * @param customerId
     * @return
     */
    public Customer getCustomerOne(Integer customerId){
        return dao.getCustomerOne(customerId);
    }

    /**
     * 查找最后一个对象
     * @return
     */
    public Customer getCustomerLastOne(){
        return dao.getCustomerLastOne();
    }

    /**
     * 改
     * 顾客自己改自己的个人信息
     * @param p
     * @return
     */
    public int Update_Customer(Customer p,Integer id){
        return dao.Update_Customer(p,id);
    }

    /**
     * 改
     * 顾客自己改自己的收货地址信息
     * @param id
     * @return
     */
    public int Update_CustomerAddress(Integer id,String customerAddress){
        return dao.Update_CustomerAddress(id,customerAddress);
    }

    /**
     * 增（注册）
     * 添加顾客信息
     * @param p
     * @return
     */
    public int add_Customer(Customer p){
        return dao.add_Customer(p);
    }
}
