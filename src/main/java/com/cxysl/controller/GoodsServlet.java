package com.cxysl.controller;

import com.cxysl.entity.Goods;
import com.cxysl.service.GoodsServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class GoodsServlet {
    @Autowired
    private GoodsServie service;

    /**
     * 根据
     * @param goodsId
     * @return
     */
    @GetMapping("/getGoodsOne")
    public Map<String,Object> getGoodsOne(Integer goodsId){
        System.out.println("正在查找指定ID商品……");

        Goods goods = service.getGoodsOne(goodsId);

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",goods);
        return map;
    }

    /**
     *获取所有上架商品查询
     * @return
     */
    @GetMapping("/queryUpGoodsAll")
    public Map<String,Object> queryUpAll(){
        System.out.println("正在查找所有上架商品……");

        List<Goods> list = service.queryUpAll();

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",list);
        return map;
    }



    /**
     *根据输入的字符串模糊查询已上架商品
     * @return
     */
    @GetMapping("/queryUpGoodsStrAll")
    public Map<String,Object> queryUpOneAll(String goodsStr){
        System.out.println("根据输入的字符串模糊查询已上架商品……");

        List<Goods> list = service.queryUpAll();
        List<Goods> list2 = new ArrayList<Goods>();
        String str = null;
        for (Goods g :list
             ) {
            str = g.getGoodsName()+g.getGoodsDescribe()+g.getGoodLabel1()+g.getGoodLabel2()+g.getGoodLabel3();
            if(goodsStr.length()!=0) {
                if (str.contains(goodsStr) || goodsStr.contains(str)) {
                    list2.add(g);
                }
            }
        }
        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",list2);
        return map;
    }

    /**
     *根据类别Id查该类别已上架的商品
     * @return
     */
    @GetMapping("/queryUpGoodsTypeId")
    public Map<String,Object> queryUpTypeId(Integer x){
        System.out.println("正在根据类别Id查找该类别已上架的商品……");

        List<Goods> list = service.queryUpTypeId(x);

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",list);
        return map;
    }

    /**
     *根据类别名查该类别已上架的商品
     * @return
     */
    @GetMapping("/queryUpGoodsTypeName")
    public Map<String,Object> queryUpTypeName(String typeName){
        System.out.println("正在根据类别名查找该类别已上架的商品……");

        List<Goods> list = service.queryUpTypeName(typeName);

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",list);
        return map;
    }

    /**
     *卖出商品后改库存量
     * id     商品ID
     * buyCount     购买数量
     * @return
     */
    @PutMapping("/Update_GoodsCount")
    public Map<String,Object> Update_GoodsCount(Integer id,Integer buyCount){
        System.out.println("卖出商品后改库存量……");

        System.out.println(id+"\t"+buyCount);

        Goods goods = service.getGoodsOne(id);

        Integer newCount =  goods.getGoodsCount()-buyCount;

        System.out.print("原库存量:"+goods.getGoodsCount());
        String str1 = "原库存量:"+goods.getGoodsCount();

        int flag = service.Update_GoodsCount(goods,newCount);

        System.out.print("\t购买数量:"+buyCount);
        String str2 = "购买数量:"+buyCount;

        System.out.print("\t现库存量:"+service.getGoodsOne(id).getGoodsCount());
        String str3 = "现库存量:"+service.getGoodsOne(id).getGoodsCount();

        List list =Arrays.asList(str1,str2,str3);


        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","修改成功成功!!!");
        map.put("data",list);
        return map;
    }


}
