package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.CartDao;
import com.example.demo.entity.Cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl extends BaseDao implements CartDao {

    @Override
    public int upCart(String sql, Object... param) {
        Integer result = null;
        try {
            result = this.executeUpdate(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return result;
    }

    @Override
    public List<Cart> getCartAll(String sql, Object... param) {
        List<Cart> list = new ArrayList<Cart>();
        Cart cart = null;
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                cart = new Cart();
                cart.setCartId(rs.getInt("cartId"));
                cart.setComId(rs.getInt("comId"));
                cart.setComName(rs.getString("comName"));
                cart.setOriginalPrice(rs.getDouble("originalPrice"));
                cart.setComImg(rs.getString("comImg"));
                cart.setComprice(rs.getDouble("comprice"));
                cart.setComNum(rs.getInt("comNum"));
                cart.setUserId(rs.getInt("userId"));
                list.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Cart getCart(String sql, Object... param) {
        Cart cart = null;
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                cart = new Cart();
                cart.setCartId(rs.getInt("cartId"));
                cart.setComId(rs.getInt("comId"));
                cart.setComName(rs.getString("comName"));
                cart.setComImg(rs.getString("comImg"));
                cart.setOriginalPrice(rs.getDouble("originalPrice"));
                cart.setComprice(rs.getDouble("comprice"));
                cart.setComNum(rs.getInt("comNum"));
                cart.setUserId(rs.getInt("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

}
