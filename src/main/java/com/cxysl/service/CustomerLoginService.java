package com.cxysl.service;

import com.cxysl.dao.CustomerLoginDAOImpl;
import com.cxysl.entity.CustomerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLoginService {
    @Autowired
    private CustomerLoginDAOImpl dao;

    /**
     * 登录验证
     * @return
     */
    public CustomerLogin CustomerLogin(String username, String pwd) {
        return dao.CustomerLogin(username,pwd);
    }

    /**
     * 查
     * 根据ID查找顾客账号信息
     * @param customerId
     * @return
     */
    public CustomerLogin getCustomerLoginOne(Integer customerId)
    {
        return dao.getCustomerLoginOne(customerId);
    }

    /**
     * 增（注册）
     * 添加顾客信息
     * @param p
     * @return
     */
    public int add_CustomerLogin(CustomerLogin p)
    {
       return dao.add_CustomerLogin(p);
    }
}
