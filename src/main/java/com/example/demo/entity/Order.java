package com.example.demo.entity;

/**
 * 订单实体类
 *
 * @author 平民
 */
public class Order {

    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 买家编号
     */
    private int buyerId;
    /**
     * 卖家编号
     */
    private int ellerId;
    /**
     * 订单金额
     */
    private double amounts;
    /**
     * 收货地址编号
     */
    private int shippingAddress;
    /**
     * 订单时间
     */
    private String orderTime;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 订单件数
     */
    private int orderNumber;

    /**
     * 商品图片
     */
    private String orderImg;

    /**
     * 买家名称
     */
    private String buyName;
    /**
     * 卖家名称
     */
    private String elName;

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getElName() {
        return elName;
    }

    public void setElName(String elName) {
        this.elName = elName;
    }

    public String getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(String orderImg) {
        this.orderImg = orderImg;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getEllerId() {
        return ellerId;
    }

    public void setEllerId(int ellerId) {
        this.ellerId = ellerId;
    }

    public double getAmounts() {
        return amounts;
    }

    public void setAmounts(double amounts) {
        this.amounts = amounts;
    }

    public int getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(int shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Order() {
        super();
    }


    public Order(String orderId, int buyerId, int ellerId, double amounts, int shippingAddress, String orderTime,
                 int orderNumber, String orderImg) {
        super();
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.ellerId = ellerId;
        this.amounts = amounts;
        this.shippingAddress = shippingAddress;
        this.orderTime = orderTime;
        this.orderNumber = orderNumber;
        this.orderImg = orderImg;
    }

    public Order(String orderId, int buyerId, int ellerId, double amounts, int shippingAddress, String orderTime,
                 String orderState) {
        super();
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.ellerId = ellerId;
        this.amounts = amounts;
        this.shippingAddress = shippingAddress;
        this.orderTime = orderTime;
        this.orderState = orderState;
    }
}
