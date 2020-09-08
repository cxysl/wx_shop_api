package com.cxysl.dao;

import com.cxysl.entity.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingCarDAOImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查
     * 根据顾客Id查该顾客的所有购物车商品
     * @return
     */
    public List<ShoppingCar> queryOneAll(Integer customerId){

        String sql = "select * from shoppingcar where customerId=?";
        RowMapper<ShoppingCar> rowMapper = new BeanPropertyRowMapper<>(ShoppingCar.class);
        List<ShoppingCar> list = jdbcTemplate.query(sql,rowMapper,customerId);
        return list;
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
        String sql = "select * from shoppingcar where goodsId=? and customerId=?";
        RowMapper<ShoppingCar> rowMapper = new BeanPropertyRowMapper<>(ShoppingCar.class);
        ShoppingCar s;
        try {
             s = jdbcTemplate.queryForObject(sql, rowMapper, goodsId, customerId);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return s;
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
        String sql = "update shoppingcar set buyCount=? where goodsId=? and customerId=?";
        return jdbcTemplate.update(sql,a,s.getGoodsId(),s.getCustomerId());
    }

    /**
     * 增
     * 增加购物车信息
     * @param s
     * @return
     */
    public int add_ShoppingCar(ShoppingCar s)
    {
        String sql = "insert into shoppingcar values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,s.getGoodsId(),s.getGoodsName(),s.getGoodsPicture(),s.getGoodsPrice(),s.getBuyCount(),
                        s.getGoodsDescribe(),s.getCustomerId());
    }

    /**
     * 删除
     * @param goodsId
     * @param customerId
     * @return
     */
    public int del_ShoppingCar(Integer goodsId,Integer customerId)
    {
        String sql = "delete from shoppingcar where goodsId=? and customerId=?";
        return jdbcTemplate.update(sql,goodsId,customerId);
    }

}
