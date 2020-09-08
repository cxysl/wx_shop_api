package com.cxysl.dao;

import com.cxysl.entity.GoodsPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsPictureDAOImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查
     * 根据商品ID查找商品的五张轮播图
     * @param goodsId
     * @return
     */
    public GoodsPicture getGoodsPictureOne(Integer goodsId)
    {
        String sql = "select * from goodsPicture where goodsId=?";
        RowMapper<GoodsPicture> rowMapper = new BeanPropertyRowMapper<>(GoodsPicture.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,goodsId);
    }
}
