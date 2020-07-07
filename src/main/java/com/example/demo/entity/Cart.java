package com.example.demo.entity;

/**
 * 购物车实体类
 *
 * @author 平民
 */
public class Cart {
    /**
     * 编号
     */
    private int cartId;
    /**
     * 商品编号
     */
    private int comId;
    /**
     * 商品名称
     */
    private String comName;
    /**
     * 商品原价
     */
    private double originalPrice;
    /**
     * 商品现价
     */
    private double comprice;
    /**
     * 商品数量
     */
    private int comNum;
    /**
     * 商品图片
     */
    private String comImg;
    /**
     * 用户编号
     */
    private int userId;

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getComprice() {
        return comprice;
    }

    public void setComprice(double comprice) {
        this.comprice = comprice;
    }

    public int getComNum() {
        return comNum;
    }

    public void setComNum(int comNum) {
        this.comNum = comNum;
    }

    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Cart() {
        super();
    }

    public Cart(int comId, String comName, double originalPrice, double comprice, int comNum, String comImg, int userId) {
        super();
        this.comId = comId;
        this.comName = comName;
        this.originalPrice = originalPrice;
        this.comprice = comprice;
        this.comNum = comNum;
        this.comImg = comImg;
        this.userId = userId;
    }
}
