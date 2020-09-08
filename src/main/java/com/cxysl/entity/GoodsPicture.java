package com.cxysl.entity;

public class GoodsPicture {
    private Integer pictureId;        //记录ID（主键）
    private String pictureOne;        //商品图片1
    private String pictureTwo;        //商品图片2
    private String pictureThree;        //商品图片3
    private String pictureFour;        //商品图片4
    private String pictureFive;        //商品图片5
    private String goodsId;        //商品ID

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }


    public String getPictureOne() {
        return pictureOne;
    }

    public void setPictureOne(String pictureOne) {
        this.pictureOne = pictureOne;
    }

    public String getPictureTwo() {
        return pictureTwo;
    }

    public void setPictureTwo(String pictureTwo) {
        this.pictureTwo = pictureTwo;
    }

    public String getPictureThree() {
        return pictureThree;
    }

    public void setPictureThree(String pictureThree) {
        this.pictureThree = pictureThree;
    }

    public String getPictureFour() {
        return pictureFour;
    }

    public void setPictureFour(String pictureFour) {
        this.pictureFour = pictureFour;
    }

    public String getPictureFive() {
        return pictureFive;
    }

    public void setPictureFive(String pictureFive) {
        this.pictureFive = pictureFive;
    }
}
