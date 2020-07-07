package com.example.demo.service;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderService {
    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    public int addOrder(Order order);

    /**
     * 根据参数查询订单数据
     *
     * @param order
     * @return List<Order>
     */
    public List<Order> getOrder(Order order);

    /**
     * 查询所有订单
     *
     * @return
     */
    public List<Order> getOrderAll();

    /**
     * 根据订单编号删除订单
     *
     * @param ordeId
     * @return
     */
    public int delOrde(String ordeId);

    /**
     * 根据编号修改订单
     *
     * @param ordeId
     * @return
     */
    public int upOrde(String ordeId, String orderState);

    /**
     * 根据订单编号查询订单信息
     *
     * @param ordeId
     * @return
     */
    public Order getOrder(String ordeId);

    /**
     * 查询所有维权订单
     *
     * @return
     */
    public List<Order> getTuiOrder();

}
