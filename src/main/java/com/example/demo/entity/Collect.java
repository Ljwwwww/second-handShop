package com.example.demo.entity;

/**
 * 收藏实体类
 *
 * @author 平民
 */
public class Collect {
    /**
     * 编号
     */
    private int collectId;
    /**
     * 商品编号
     */
    private int comId;
    /**
     * 商品名称
     */
    private String comName;
    /**
     * 用户编号
     */
    private int userId;
    /**
     * 商品价格
     */
    private double comPrice;
    /**
     * 商品图片
     */
    private String comImg;

    public int getCollectId() {
        return collectId;
    }

    public void setCollectId(int collectId) {
        this.collectId = collectId;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getComPrice() {
        return comPrice;
    }

    public void setComPrice(double comPrice) {
        this.comPrice = comPrice;
    }

    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg;
    }

    public Collect() {
        super();
    }

    public Collect(int comId, String comName, int userId, double comPrice, String comImg) {
        super();
        this.comId = comId;
        this.comName = comName;
        this.userId = userId;
        this.comPrice = comPrice;
        this.comImg = comImg;
    }


}
