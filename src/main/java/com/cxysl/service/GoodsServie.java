package com.cxysl.service;

import com.cxysl.dao.GoodsDAOImpl;
import com.cxysl.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServie {
    @Autowired
    private GoodsDAOImpl dao;


    public List<Goods> queryUpAll(){
        return  dao.queryUpAll();
    }

    public List<Goods> queryUpTypeId(Integer x){
        return  dao.queryUpTypeId(x);
    }

    public List<Goods> queryUpTypeName(String typeName){
        return  dao.queryUpTypeName(typeName);
    }

    public Goods getGoodsOne(Integer id){
        return dao.getGoodsOne(id);
    }


    /**
     * 改指定商品的库存量
     * @param g
     * @param count
     * @return
     */
    public int Update_GoodsCount(Goods g, Integer count){
        return dao.Update_GoodsCount(g,count);
    }

}
