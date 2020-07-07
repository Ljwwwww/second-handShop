package com.example.demo.dao;

import com.example.demo.entity.Order;
import com.example.demo.entity.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 更新订单信息
     *
     * @param sql
     * @param param
     * @return
     */
    public int upOrder(String sql, Object... param);

    /**
     * 根据信息查询订单
     *
     * @param sql
     * @param param
     * @return
     */
    public List<Order> getOrdeerAll(String sql, Object... param);

    /**
     * 根据信息查询单个订单
     *
     * @param sql
     * @param param
     * @return
     */
    public Order getOrdeer(String sql, Object... param);

    /**
     * 查询所有订单
     *
     * @param sql
     * @return
     */
    public List<Order> getOrdeerAll(String sql);

    /**
     * @param sql
     * @return
     */
    public List<Order> getTuiOrder(String sql);

}
