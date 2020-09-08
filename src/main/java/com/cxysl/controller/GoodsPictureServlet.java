package com.cxysl.controller;

import com.cxysl.entity.GoodsPicture;
import com.cxysl.service.GoodsPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class GoodsPictureServlet {
    @Autowired
    private GoodsPictureService service;

    /**
     * 查
     * 查该商品的轮播图图片
     * @param goodsId
     * @return
     */
    @GetMapping("/queryOneGoodsPicture")
    public Map<String,Object> queryOneCustomer(Integer goodsId){
        System.out.println("正在查找该条信息……");

        GoodsPicture goodsPicture = service.getGoodsPictureOne(goodsId);

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",goodsPicture);
        return map;
    }

}
