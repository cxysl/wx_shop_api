package com.cxysl.service;

import com.cxysl.dao.ShoppingCarDAOImpl;
import com.cxysl.entity.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarService {
    @Autowired
    private ShoppingCarDAOImpl dao;

    /**
     * 查
     * 根据顾客Id查该顾客的所有购物车商品
     * @return
     */
    public List<ShoppingCar> queryOneAll(Integer customerId){
        return dao.queryOneAll(customerId);
    }

    /**
     * 查
     * 查找单条记录
     * 根据商品ID和顾客ID
     * @param goodsId
     * @param customerId
     * @return
     */
    public ShoppingCar getShoppingCarOne(Integer goodsId,Integer customerId)
    {
        return dao.getShoppingCarOne(goodsId,customerId);
    }

    /**
     * 改
     * 改购物车商品购买数量
     * @param s
     * @param a
     * @return
     */
    public int Update_ShoppingCarCount(ShoppingCar s,Integer a)
    {
        return dao.Update_ShoppingCarCount(s,a);
    }

    /**
     * 增
     * 增加购物车信息
     * @param s
     * @return
     */
    public int add_ShoppingCar(ShoppingCar s)
    {
        return dao.add_ShoppingCar(s);
    }

    /**
     * 删除
     * @param goodsId
     * @param customerId
     * @return
     */
    public int del_ShoppingCar(Integer goodsId,Integer customerId)
    {
        return dao.del_ShoppingCar(goodsId,customerId);
    }
}
