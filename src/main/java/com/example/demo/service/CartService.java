package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Cart;

import java.util.List;

public interface CartService {
    /**
     * 添加购物车
     *
     * @param cart
     * @return
     */
    public int addCart(Cart cart);

    /**
     * 根据用户编号查询购物车
     *
     * @param userId
     * @return
     */
    public List<Cart> getCartAll(int userId);

    /**
     * 根据商品编号查询
     *
     * @param comId
     * @return
     */
    public Cart getCart(int comId, int userId);

    public Cart getCartById(int cartId);

    /**
     * 根据编号删除购物车信息
     *
     * @param cartId
     * @return
     */
    public int delCart(int cartId);
}
