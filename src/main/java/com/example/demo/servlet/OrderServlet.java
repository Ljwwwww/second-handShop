package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static Random random = new Random();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String type = request.getParameter("type");
        OrderService orderService = new OrderServiceImpl();
        int count = 0;
        PrintWriter out = response.getWriter();
        List<Order> list = new ArrayList<Order>();
        JSONObject json = new JSONObject();
        Message message = null;
        MessageService messageService = new MessageServiceImpl();
        UserService userService = new UserServiceImpl();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        //维权信息
        TuikunService tuikunService = new TuikunServiceImpl();
        Tuikuan tuikuan = null;
        if (type.equals("add")) {

            String orderId = createFileNameUseTime();
            String comIds = request.getParameter("comId");
            String addId = request.getParameter("classifyName");
            String userName = request.getParameter("userName");
            String numbers = request.getParameter("number");
            System.out.println(numbers);
            int comId = Integer.parseInt(comIds);
            int addIds = Integer.parseInt(addId);
            int number = Integer.parseInt(numbers);


            Commodity com = new Commodity();

            CommodityService commodityService = new CommodityServiceImpl();
            //根据id查询商品信息
            com = commodityService.getCommodity(comId);

            //根据用户名查询用户信息

            User user = new User();
            user.setUserName(userName);
            user = userService.getUser(user);
            if (user.getUserId() == com.getCommodityMaster()) {
                out.print("false");
            } else if (user.getUserMoney() < com.getCommodityPrice()) {
                out.print("isNon");
            } else {
                Order order = new Order(orderId, user.getUserId(), com.getCommodityMaster(), com.getCommodityPrice(), addIds, time, number, com.getCommodityShowimg());
                //修改商品状态为已出售
                commodityService.upComStatus(comId, 6);
                //更新当前购买商品的用户金额
                userService.upMoney(user.getUserMoney() - com.getCommodityPrice(), user.getUserId());
                count = orderService.addOrder(order);
                if (count == 1) {
                    message = new Message(com.getCommodityMaster(), "系统提醒", userName + "已成功购买您的商品《" + com.getCommodityName() + "》,请您尽快发货!", time, 1);
                    messageService.addMessage(message);
                }

                out.print(count);
            }
        } else if (type.equals("ugain")) {
            String buyerId = request.getParameter("userId");
            int buyerIds = Integer.parseInt(buyerId);
            Order order = new Order();
            order.setBuyerId(buyerIds);
            list = orderService.getOrder(order);
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            //json.put("count", count);
            out.print(json);
            //ugais
        } else if (type.equals("ugais")) {
            String ellerIds = request.getParameter("userId");
            int ellerId = Integer.parseInt(ellerIds);
            Order order = new Order();
            order.setEllerId(ellerId);
            list = orderService.getOrder(order);
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            //json.put("count", count);
            out.print(json);
            //
        } else if (type.equals("all")) {
            list = orderService.getOrderAll();
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            json.put("count", count);
            out.print(json);
        } else if (type.equals("del")) {
            String ordeId = request.getParameter("ordeId");
            System.out.println(ordeId);
            count = orderService.delOrde(ordeId);
            out.print(count);
        } else if (type.equals("shipments")) {
            //发货
            String orderId = request.getParameter("orderId");
            count = orderService.upOrde(orderId, "已发货");
            out.print(count);
        } else if (type.equals("addAll")) {
            String addId = request.getParameter("classifyName");
            double originalPrice = Double.parseDouble(request.getParameter("originalPrice"));
            int addIds = Integer.parseInt(addId);
            String arrayA = request.getParameter("data");
            String[] array = arrayA.split(",");
            CartService cartService = new CartServiceImpl();
            CommodityServiceImpl commodityService = new CommodityServiceImpl();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            User user = new User();
            int cartId1 = Integer.parseInt(array[0]);
            Cart cart1 = cartService.getCartById(cartId1);
            user.setUserId(cart1.getUserId());
            user = userService.getUser(user);
            userService.getUser(user);
            //判断用户金额是否足够支付
            if (user.getUserMoney() > originalPrice) {

                for (int i = 0; i < array.length; i++) {
                    int cartId = Integer.parseInt(array[i]);
                    Cart cart = cartService.getCartById(cartId);
                    Order order = new Order();
                    order.setOrderId(createFileNameUseTime());
                    order.setBuyerId(cart.getUserId());
                    order.setEllerId(commodityService.getEllerIdByComId(cart.getComId()));
                    order.setAmounts(cart.getComprice() * cart.getComNum());
                    order.setShippingAddress(addIds);
                    order.setOrderTime(format.format(new Date()));
                    order.setOrderNumber(cart.getComNum());
                    order.setOrderImg(cart.getComImg());
                    count = orderService.addOrder(order);

                    commodityService.upComStatus(cart.getComId(), 6);
                    //更新当前购买商品的用户金额
                    userService.upMoney(user.getUserMoney() - cart.getComprice(), user.getUserId());
                    if (count == 1) {
                        //删除购买成功的购物车信息
                        cartService.delCart(cartId);
                        //订单添加成功发生消息到卖家账户
                        message = new Message(commodityService.getEllerIdByComId(cart.getComId()), "系统提醒", user.getUserName() + "已成功购买您的商品《" + cart.getComName() + "》,请您尽快发货!", format.format(new Date()), 1);
                        messageService.addMessage(message);
                    }
                }
                out.print(1);
            } else {
                out.print("isNon");
            }

        } else if (type.equals("receiving")) {
            //确认收货
            String orderId = request.getParameter("orderId");
            Order order = new Order();
            order = orderService.getOrder(orderId);//根据订单编号查询订单信息
            count = orderService.upOrde(orderId, "已确认收货");//修改订单状态
            User user = new User();
            user.setUserId(order.getEllerId());
            user = userService.getUser(user);//根据用户编号查询用户信息(获取用户金额)
            int yun = userService.upMoney(user.getUserMoney() + order.getAmounts(), order.getEllerId());
            if (yun == 1 && count == 1) {
                message = new Message(order.getEllerId(), "确认收货", "订单号为:" + orderId + "已确认收货", time, 1);
                messageService.addMessage(message);
                out.print(count);
            }

        } else if (type.equals("getOrde")) {
            String ordeId = request.getParameter("ordeId");
            Order order = new Order();
            order = orderService.getOrder(ordeId);
            request.setAttribute("order", order);
            request.getRequestDispatcher("admin/get-orde.jsp").forward(request, response);
        } else if (type.equals("upOrde")) {
            String ordeId = request.getParameter("orderId");
            count = orderService.upOrde(ordeId, "退款中");//修改订单状态
            Order order = new Order();
            order = orderService.getOrder(ordeId);

            String tuikuan1 = request.getParameter("tuikuan");
            String yuany = request.getParameter("yuany");
            //添加一条维权信息
            tuikuan = new Tuikuan(ordeId, order.getBuyerId(), order.getEllerId(), yuany, tuikuan1, "退款中", time);
            tuikunService.addTuikun(tuikuan);

            //给卖家发送退货申请消息
            message = new Message(order.getEllerId(), "系统提醒", "订单号为:" + ordeId + "已发出退款申请,退款原因:" + yuany + "退款理由:" + tuikuan1, time, 1);
            messageService.addMessage(message);

            message = new Message(1, "退款申请", "订单号为:" + ordeId + "发出退款申请,退款原因:" + yuany + "退款理由:" + tuikuan1, time, 1);
            messageService.addMessage(message);
            out.print(count);
        } else if (type.equals("att")) {
            list = orderService.getTuiOrder();
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            json.put("count", count);
            out.print(json);
        }
        out.close();
        out.flush();

    }

    //生成订单号
    public static String createFileNameUseTime() {
        String time = sdf2.format(new Date());
        Integer num = random.nextInt(9000) + 1000;
        return "as" + time + num;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
