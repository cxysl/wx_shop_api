package com.cxysl.service;

import com.cxysl.dao.GoodsPictureDAOImpl;
import com.cxysl.entity.GoodsPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsPictureService {
    @Autowired
    private GoodsPictureDAOImpl dao;

    /**
     * 查
     * 根据商品ID查找商品的五张轮播图
     * @param goodsId
     * @return
     */
    public GoodsPicture getGoodsPictureOne(Integer goodsId){
        return dao.getGoodsPictureOne(goodsId);
    }
}
