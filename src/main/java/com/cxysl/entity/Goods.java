package com.cxysl.entity;

public class Goods {
    private Integer goodsId;        //商品ID（主键）
    private String goodsName;       //商品名称
    private String goodsPicture;        //商品主图片地址
    private double purchasePrice;       //采购价格
    private double goodsPrice;      //销售价格
    private Integer goodsCount;     //库存量
    private String goodsDescribe;       //商品描述信息
    private String goodLabel1;      //标签1
    private String goodLabel2;      //标签2

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPicture='" + goodsPicture + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", goodsPrice=" + goodsPrice +
                ", goodsCount=" + goodsCount +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", goodLabel1='" + goodLabel1 + '\'' +
                ", goodLabel2='" + goodLabel2 + '\'' +
                ", goodLabel3='" + goodLabel3 + '\'' +
                ", goodsUpdates='" + goodsUpdates + '\'' +
                ", typeId=" + typeId +
                '}';
    }

    private String goodLabel3;      //标签3
    private String goodsUpdates;        //商品是否上下架
    private int typeId;     //商品类别Id

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsUpdates() {
        return goodsUpdates;
    }

    public void setGoodsUpdates(String goodsUpdates) {
        this.goodsUpdates = goodsUpdates;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodLabel1() {
        return goodLabel1;
    }

    public void setGoodLabel1(String goodLabel1) {
        this.goodLabel1 = goodLabel1;
    }

    public String getGoodLabel2() {
        return goodLabel2;
    }

    public void setGoodLabel2(String goodLabel2) {
        this.goodLabel2 = goodLabel2;
    }

    public String getGoodLabel3() {
        return goodLabel3;
    }

    public void setGoodLabel3(String goodLabel3) {
        this.goodLabel3 = goodLabel3;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
