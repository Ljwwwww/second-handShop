package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dao.impl.OrderDaoImpl;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    //添加商品
    @Override
    public int addOrder(Order order) {
        String sql = "INSERT INTO `order` (`orderId`,`buyerId`,`ellerId`,`amounts`,`shippingAddress`,`orderTime`,`orderNumber`,`orderImg`)VALUES(?,?,?,?,?,?,?,?)";
        int num = 0;
        OrderDao orderDao = new OrderDaoImpl();
        Object[] param = {order.getOrderId(), order.getBuyerId(), order.getEllerId(), order.getAmounts(), order.getShippingAddress(), order.getOrderTime(), order.getOrderNumber(), order.getOrderImg()};
        num = orderDao.upOrder(sql, param);
        return num;
    }

    //根据用户编号查询订单
    @Override
    public List<Order> getOrder(Order order) {
        String sql = null;
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> list = new ArrayList<Order>();
        if (order.getBuyerId() != 0) {
            sql = "SELECT * FROM `order` WHERE buyerId=?";
            Object param[] = {order.getBuyerId()};
            list = orderDao.getOrdeerAll(sql, param);
        } else if (order.getEllerId() != 0) {
            sql = "SELECT * FROM `order` WHERE `ellerId`=?";
            Object param[] = {order.getEllerId()};
            list = orderDao.getOrdeerAll(sql, param);
        }
        return list;
    }

    @Override
    public List<Order> getOrderAll() {
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> list = new ArrayList<Order>();
        String sql = "SELECT `orderId`,`buyerId`,`ellerId`,`amounts`,`order`.`shippingAddress`,`orderTime`,`orderState`,`orderNumber`,`orderImg`,u.userName AS '买家',uu.userName AS '卖家' FROM `order` LEFT JOIN `user` u ON `order`.`buyerId`=u.`userId` LEFT JOIN `user` uu ON `order`.`ellerId`=uu.`userId`";
        list = orderDao.getOrdeerAll(sql);
        return list;
    }

    @Override
    public int delOrde(String ordeId) {
        OrderDao orderDao = new OrderDaoImpl();
        String sql = "DELETE FROM `order` WHERE orderId=?";
        Object param[] = {ordeId};
        int count = orderDao.upOrder(sql, param);
        return count;
    }

    //根据编号修改
    @Override
    public int upOrde(String ordeId, String orderState) {
        OrderDao orderDao = new OrderDaoImpl();
        String sql = "UPDATE `order` SET  `orderState`=? WHERE `orderId` =?";
        Object param[] = {orderState, ordeId};
        return orderDao.upOrder(sql, param);
    }

    @Override
    public Order getOrder(String ordeId) {
        String sql = "SELECT `orderId`,`buyerId`,`ellerId`,`amounts`,`order`.`shippingAddress`,`orderTime`,`orderState`,`orderNumber`,`orderImg`,u.userName AS '买家',uu.userName AS '卖家' FROM `order` LEFT JOIN `user` u ON `order`.`buyerId`=u.`userId` LEFT JOIN `user` uu ON `order`.`ellerId`=uu.`userId` where orderId=? ";
        Object[] param = {ordeId};
        OrderDao orderDao = new OrderDaoImpl();
        return orderDao.getOrdeer(sql, param);
    }

    @Override
    public List<Order> getTuiOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> list = new ArrayList<Order>();
        String sql = "SELECT DISTINCT (t.`ordeId`),o.*,u.`userName` AS 'buyName',us.`userName` AS 'elName' FROM `tuikuan` t\r\n" +
                "INNER JOIN `order` o ON t.`ordeId`=o.`orderId`\r\n" +
                "INNER JOIN `user` u ON o.`buyerId`=u.`userId` \r\n" +
                "INNER JOIN `user` us ON o.`ellerId`=us.`userId` \r\n" +
                "";
        list = orderDao.getTuiOrder(sql);
        return list;
    }

}
