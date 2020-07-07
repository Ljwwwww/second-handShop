package com.example.demo.entity;

/**
 * 商品信息实体类
 *
 * @author 平民
 */
public class Commodity {
    /**
     * 商品编号
     */
    private int commodityId;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 商品价格
     */
    private double commodityPrice;
    /**
     * 商品浏览次数
     */
    private int commodityViewcount;
    /**
     * 商品缩略图
     */
    private String commodityShowimg;
    /**
     * 商品原价
     */
    private double originalCos;
    /**
     * 商品成色
     */
    private String commodityCondition;
    /**
     * 所在地
     */
    private String commodityArea;
    /**
     * 主人编号
     */
    private int commodityMaster;
    /**
     * 商品介绍
     */
    private String commodityIntroduce;
    /**
     * 商品分类编号
     */
    private int commodityClid;
    /**
     * 商品状态编号
     */
    private int commodityState;
    /**
     * 商品发布时间
     */
    private String commodityDate;
    /**
     * 商品库存
     */
    private int commodityClassify;

    /**
     *
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCommodityClassify() {
        return commodityClassify;
    }

    public void setCommodityClassify(int commodityClassify) {
        this.commodityClassify = commodityClassify;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public int getCommodityViewcount() {
        return commodityViewcount;
    }

    public void setCommodityViewcount(int commodityViewcount) {
        this.commodityViewcount = commodityViewcount;
    }

    public String getCommodityShowimg() {
        return commodityShowimg;
    }

    public void setCommodityShowimg(String commodityShowimg) {
        this.commodityShowimg = commodityShowimg;
    }

    public double getOriginalCos() {
        return originalCos;
    }

    public void setOriginalCos(double originalCos) {
        this.originalCos = originalCos;
    }

    public String getCommodityCondition() {
        return commodityCondition;
    }

    public void setCommodityCondition(String commodityCondition) {
        this.commodityCondition = commodityCondition;
    }

    public String getCommodityArea() {
        return commodityArea;
    }

    public void setCommodityArea(String commodityArea) {
        this.commodityArea = commodityArea;
    }

    public int getCommodityMaster() {
        return commodityMaster;
    }

    public void setCommodityMaster(int commodityMaster) {
        this.commodityMaster = commodityMaster;
    }

    public String getCommodityIntroduce() {
        return commodityIntroduce;
    }

    public void setCommodityIntroduce(String commodityIntroduce) {
        this.commodityIntroduce = commodityIntroduce;
    }

    public int getCommodityClid() {
        return commodityClid;
    }

    public void setCommodityClid(int commodityClid) {
        this.commodityClid = commodityClid;
    }

    public int getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(int commodityState) {
        this.commodityState = commodityState;
    }

    public String getCommodityDate() {
        return commodityDate;
    }

    public void setCommodityDate(String commodityDate) {
        this.commodityDate = commodityDate;
    }

    public Commodity() {
        super();
    }

    //添加商品
    public Commodity(String commodityName, double commodityPrice, int commodityViewcount, String commodityShowimg,
                     double originalCos, String commodityCondition, String commodityArea, int commodityMaster,
                     String commodityIntroduce, int commodityClid, int commodityState, String commodityDate,
                     int commodityClassify) {
        super();
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
        this.commodityViewcount = commodityViewcount;
        this.commodityShowimg = commodityShowimg;
        this.originalCos = originalCos;
        this.commodityCondition = commodityCondition;
        this.commodityArea = commodityArea;
        this.commodityMaster = commodityMaster;
        this.commodityIntroduce = commodityIntroduce;
        this.commodityClid = commodityClid;
        this.commodityState = commodityState;
        this.commodityDate = commodityDate;
        this.commodityClassify = commodityClassify;
    }

    public Commodity(int commodityId, String commodityName, double commodityPrice, int commodityViewcount,
                     String commodityShowimg, double originalCos, String commodityCondition, String commodityArea,
                     int commodityMaster, String commodityIntroduce, int commodityClid, int commodityState, String commodityDate,
                     int commodityClassify) {
        super();
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
        this.commodityViewcount = commodityViewcount;
        this.commodityShowimg = commodityShowimg;
        this.originalCos = originalCos;
        this.commodityCondition = commodityCondition;
        this.commodityArea = commodityArea;
        this.commodityMaster = commodityMaster;
        this.commodityIntroduce = commodityIntroduce;
        this.commodityClid = commodityClid;
        this.commodityState = commodityState;
        this.commodityDate = commodityDate;
        this.commodityClassify = commodityClassify;
    }


}
