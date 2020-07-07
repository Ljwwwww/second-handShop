package com.example.demo.service.impl;

import com.example.demo.dao.CartDao;
import com.example.demo.dao.impl.CartDaoImpl;
import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    //添加购物车信息
    @Override
    public int addCart(Cart cart) {
        String sql = "INSERT INTO cart (comId,comName,originalPrice,comprice,comNum,comImg,userId)VALUES(?,?,?,?,?,?,?)";
        CartDao cartDao = new CartDaoImpl();
        Object[] param = {cart.getComId(), cart.getComName(), cart.getOriginalPrice(), cart.getComprice(), cart.getComNum(), cart.getComImg(), cart.getUserId()};
        int count = cartDao.upCart(sql, param);
        return count;
    }

    //查询购物车信息
    @Override
    public List<Cart> getCartAll(int userId) {
        String sql = "SELECT * FROM cart WHERE userId=?";
        Object[] param = {userId};
        CartDao cartDao = new CartDaoImpl();
        return cartDao.getCartAll(sql, param);
    }

    //根据商品编号查询
    @Override
    public Cart getCart(int comId, int userId) {
        String sql = "SELECT * FROM cart WHERE comId=? AND userId=?";
        CartDao cartDao = new CartDaoImpl();
        Object[] param = {comId, userId};
        return cartDao.getCart(sql, param);
    }

    @Override
    public Cart getCartById(int cartId) {
        String sql = "SELECT * FROM cart WHERE cartId=?";
        CartDao cartDao = new CartDaoImpl();
        Object[] param = {cartId};
        return cartDao.getCart(sql, param);
    }

    @Override
    public int delCart(int cartId) {
        String sql = "DELETE FROM `cart` WHERE `cartId`=?";
        CartDao cartDao = new CartDaoImpl();
        Object[] param = {cartId};
        return cartDao.upCart(sql, param);
    }

}
