package com.cxysl.dao;

import com.cxysl.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDAOImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查
     * 获取上架商品查询
     * @return
     */
    public List<Goods> queryUpAll(){

        String sql = "select * from goods where goodsUpdates='y'";
        RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<>(Goods.class);
        List<Goods> list = jdbcTemplate.query(sql,rowMapper);
        return list;
    }

    /**
     * 查
     * 根据类别Id查该类别已上架的商品
     * @return
     */
    public List<Goods> queryUpTypeId(Integer x){

        String sql = "select * from goods where goodsUpdates='y' and typeId = ?";
        RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<>(Goods.class);
        List<Goods> list = jdbcTemplate.query(sql,rowMapper,x);
        return list;
    }

    /**
     * 查
     * 根据类别名查该类别已上架的商品
     * @return
     */
    public List<Goods> queryUpTypeName(String typeName){

        String sql = "select * from goods  where goodsUpdates='y' and typeId = (select typeId from goodsType WHERE typeName = ?)";
        RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<>(Goods.class);
        List<Goods> list = jdbcTemplate.query(sql,rowMapper,typeName);
        return list;
    }



    /**
     * 查
     * 根据ID查找单个商品
     * @param goodsId
     * @return
     */
    public Goods getGoodsOne(Integer goodsId)
    {
        String sql = "select * from goods where goodsId=?";
        RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<>(Goods.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,goodsId);
    }



    /**
     * 改
     * 改指定商品的库存量
     * @param g
     * @param a
     * @return
     */
    public int Update_GoodsCount(Goods g,Integer a)
    {
        String sql = "update goods set goodsCount=? where goodsId=?";
        return jdbcTemplate.update(sql,a,g.getGoodsId());
    }


}
