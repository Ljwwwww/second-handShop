package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int upOrder(String sql, Object... param) {
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
    public List<Order> getOrdeerAll(String sql, Object... param) {
        List<Order> list = new ArrayList<Order>();
        Order order = null;

        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                order = new Order();
                order.setOrderId(rs.getString("orderId"));
                order.setBuyerId(rs.getInt("buyerId"));
                order.setEllerId(rs.getInt("ellerId"));
                order.setAmounts(rs.getDouble("amounts"));
                order.setShippingAddress(rs.getInt("shippingAddress"));
                order.setOrderTime(rs.getString("orderTime"));
                order.setOrderState(rs.getString("orderState"));
                order.setOrderNumber(rs.getInt("orderNumber"));
                order.setOrderImg(rs.getString("orderImg"));
				/*order.setBuyName(rs.getString("买家"));
				order.setElName(rs.getString("卖家"));*/
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public Order getOrdeer(String sql, Object... param) {
        Order order = null;
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                order = new Order();
                order.setOrderId(rs.getString("orderId"));
                order.setBuyerId(rs.getInt("buyerId"));
                order.setEllerId(rs.getInt("ellerId"));
                order.setAmounts(rs.getDouble("amounts"));
                order.setShippingAddress(rs.getInt("shippingAddress"));
                order.setOrderTime(rs.getString("orderTime"));
                order.setOrderState(rs.getString("orderState"));
                order.setOrderNumber(rs.getInt("orderNumber"));
                order.setOrderImg(rs.getString("orderImg"));
                order.setBuyName(rs.getString(10));
                order.setElName(rs.getString(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return order;
    }

    @Override
    public List<Order> getOrdeerAll(String sql) {
        List<Order> list = new ArrayList<Order>();
        Order order = null;
        try {
            this.rs = executeQuery(sql);
            while (rs.next()) {
                order = new Order();
                order.setOrderId(rs.getString("orderId"));
                order.setBuyerId(rs.getInt("buyerId"));
                order.setEllerId(rs.getInt("ellerId"));
                order.setAmounts(rs.getDouble("amounts"));
                order.setShippingAddress(rs.getInt("shippingAddress"));
                order.setOrderTime(rs.getString("orderTime"));
                order.setOrderState(rs.getString("orderState"));
                order.setOrderNumber(rs.getInt("orderNumber"));
                order.setOrderImg(rs.getString("orderImg"));
                order.setBuyName(rs.getString(10));
                order.setElName(rs.getString(11));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public List<Order> getTuiOrder(String sql) {
        List<Order> list = new ArrayList<Order>();
        Order order = null;
        try {
            this.rs = executeQuery(sql);
            while (rs.next()) {
                order = new Order();
                order.setOrderId(rs.getString("orderId"));
                order.setBuyerId(rs.getInt("buyerId"));
                order.setEllerId(rs.getInt("ellerId"));
                order.setAmounts(rs.getDouble("amounts"));
                order.setShippingAddress(rs.getInt("shippingAddress"));
                order.setOrderTime(rs.getString("orderTime"));
                order.setOrderState(rs.getString("orderState"));
                order.setOrderNumber(rs.getInt("orderNumber"));
                order.setOrderImg(rs.getString("orderImg"));
                order.setBuyName(rs.getString("buyName"));
                order.setElName(rs.getString("elName"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return list;
    }

}
