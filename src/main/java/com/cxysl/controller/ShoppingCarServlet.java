package com.cxysl.controller;

import com.cxysl.entity.ShoppingCar;
import com.cxysl.service.GoodsServie;
import com.cxysl.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class ShoppingCarServlet {
    @Autowired
    private ShoppingCarService service;

    @Autowired
    private GoodsServie service2;

    /**
     *查
     *查找该顾客的购物车商品
     * @return
     */
    @GetMapping("/queryShoppingCarOneAll")
    public Map<String,Object> queryOneAll(Integer customerId){
        System.out.println("正在查找您的所有购物车商品……");

        List<ShoppingCar> list = service.queryOneAll(customerId);

        Map<String,Object> map = new ConcurrentHashMap<>();

        map.put("code",new Integer(100000));
        map.put("msg","查询成功!!!");
        map.put("data",list);
        return map;
    }

    /**
     * 增
     * @param shoppingCar
     * {
     *     	"goodsId":1,
     * 	"goodsName":"T恤衫",
     * 	"goodsPicture":"http://101.200.144.60:9000/images/WX_img/f/n01.jpg",
     * 	"goodsPrice":88.88,
     * 	"buyCount":2,
     * 	"goodsDescribe":"新版终结者键盘上架"
     * }
     *
     */
    @PostMapping("/add_ShoppingCar")
    public Map<String,Object> add_ShoppingCar(@RequestBody ShoppingCar shoppingCar,Integer customerId,Integer buyCount){
        System.out.println("正在添加到购物车……");
        shoppingCar.setCustomerId(customerId);      //存一下顾客ID
        ShoppingCar s = service.getShoppingCarOne(shoppingCar.getGoodsId(),shoppingCar.getCustomerId());
        Map<String,Object> map = new ConcurrentHashMap<>();
        if (shoppingCar.getGoodsName()==null||shoppingCar.getGoodsName().length()==0){        //保存商品名称
            shoppingCar.setGoodsName(service2.getGoodsOne(shoppingCar.getGoodsId()).getGoodsName());
        }
        if (shoppingCar.getGoodsPicture()==null||shoppingCar.getGoodsPicture().length()==0){        //保存商品名称
            shoppingCar.setGoodsPicture(service2.getGoodsOne(shoppingCar.getGoodsId()).getGoodsPicture());
        }

        if (s==null){       //为空说明没有添加过该商品，执行添加操作
            shoppingCar.setBuyCount(buyCount);
            int flag = service.add_ShoppingCar(shoppingCar);
            if(flag==1){
                System.out.println("添加成功");
            }
            map.put("code",new Integer(100000));
            map.put("msg","添加成功!!!");
            map.put("data",shoppingCar);
        }
        else{           //说明已有该商品，执行修改，只要改一下购买数量就可以了
            System.out.print("old:"+service.getShoppingCarOne(shoppingCar.getGoodsId(),shoppingCar.getCustomerId()).getBuyCount());
            System.out.print("\tbuy:"+buyCount);
            buyCount = buyCount+service.getShoppingCarOne(shoppingCar.getGoodsId(),shoppingCar.getCustomerId()).getBuyCount();
            System.out.println("\tnow:"+buyCount);
            int flag = service.Update_ShoppingCarCount(shoppingCar,buyCount);
            shoppingCar.setBuyCount(buyCount);
            if(flag==1){
                System.out.println("修改成功");
            }
            map.put("code",new Integer(100000));
            map.put("msg","修改成功!!!");
            map.put("data",shoppingCar);
        }

        return map;
    }

    @DeleteMapping("/del_ShoppingCar")
    public Map<String,Object> del_ShoppingCar(Integer goodsId,Integer customerId){
        System.out.println("正在执行删除操作……");
        System.out.println(goodsId+""+customerId);
        ShoppingCar s = service.getShoppingCarOne(goodsId, customerId);
        int flag = service.del_ShoppingCar(goodsId,customerId);
        if(flag==1){
            System.out.println("删除成功");
        }
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("code",new Integer(100000));
        map.put("msg","删除成功!!!");
        map.put("data",s);
        return map;
    }
}
