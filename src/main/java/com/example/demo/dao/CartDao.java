package com.example.demo.dao;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Cart;

import java.util.List;

public interface CartDao {
    /**
     * 更新购物车信息
     *
     * @param sql
     * @param param
     * @return
     */
    public int upCart(String sql, Object... param);

    /**
     * 根据参数查询购物车信息
     *
     * @param sql
     * @param param
     * @return
     */
    public List<Cart> getCartAll(String sql, Object... param);

    /**
     * 根据参数查询单个
     *
     * @param sql
     * @param param
     * @return
     */
    public Cart getCart(String sql, Object... param);
}
