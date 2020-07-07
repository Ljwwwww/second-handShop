package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Message;
import com.example.demo.entity.Order;
import com.example.demo.entity.Tuikuan;
import com.example.demo.entity.User;
import com.example.demo.service.MessageService;
import com.example.demo.service.OrderService;
import com.example.demo.service.TuikunService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.MessageServiceImpl;
import com.example.demo.service.impl.OrderServiceImpl;
import com.example.demo.service.impl.TuikunServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;

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

/**
 * Servlet implementation class TuikuanServlet
 */
@WebServlet("/tuikuanServlet")
public class TuikuanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TuikuanServlet() {
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
        TuikunService tuikunService = new TuikunServiceImpl();
        List<Tuikuan> list = new ArrayList<Tuikuan>();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        Tuikuan tuikuan = null;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());

        OrderService orderService = new OrderServiceImpl();
        Order order = new Order();


        Message message = null;
        MessageService messageService = new MessageServiceImpl();
        if (type.equals("all")) {
            String ordeId = request.getParameter("ordeId");
            String stat = request.getParameter("stat");
            list = tuikunService.getTuikuan(ordeId);
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            out.print(json);
        } else if (type.equals("add")) {
            String ordeId = request.getParameter("ordeId");
            int userId = Integer.parseInt(request.getParameter("userId"));
            int buyerId = Integer.parseInt(request.getParameter("buyerId"));
            String nei = request.getParameter("nei");
            String yuan = request.getParameter("yuan");

            //添加一条维权信息
            tuikuan = new Tuikuan(ordeId, userId, buyerId, yuan, nei, yuan, time);
            int count = 0;
            if (yuan.equals("同意退款")) {
                count = tuikunService.addTuikun(tuikuan);
                if (count == 1) {
                    //根据订单号查询订单信息
                    order = orderService.getOrder(ordeId);

                    UserService userService = new UserServiceImpl();
                    User user = new User();
                    user.setUserId(order.getBuyerId());//根据订单买家编号查询用户信息
                    user = userService.getUser(user);
                    userService.upMoney(user.getUserMoney() + order.getAmounts(), order.getBuyerId());
                    orderService.upOrde(ordeId, "维权结束");
                    out.print(count);
                }
            } else {
                count = tuikunService.addTuikun(tuikuan);
                if (count == 1) {
                    message = new Message(buyerId, "系统提醒", "订单号为:" + ordeId + "的订单,商家拒绝了你的退款申请,理由:" + nei, time, 1);
                    messageService.addMessage(message);
                    orderService.upOrde(ordeId, "已拒绝");
                    out.print(count);
                }
            }

        } else if (type.equals("addt")) {
            String ordeId = request.getParameter("ordeId");
            int userId = Integer.parseInt(request.getParameter("userId"));
            int ellerId = Integer.parseInt(request.getParameter("ellerId"));
            String nei = request.getParameter("nei");
            //添加一条维权信息
            tuikuan = new Tuikuan(ordeId, userId, ellerId, "订单号为:" + ordeId + "订单,买家添加维权信息", nei, "申诉中", time);

            int count = tuikunService.addTuikun(tuikuan);
            if (count == 1) {
                message = new Message(ellerId, "系统提醒", "添加了维权信息:" + nei, time, 1);
                messageService.addMessage(message);
                orderService.upOrde(ordeId, "申诉中");
                out.print(count);
            }
        } else if (type.equals("admin")) {
            String ordeId = request.getParameter("ordeId");
            int userId = Integer.parseInt(request.getParameter("userId"));
            int buyerId = Integer.parseInt(request.getParameter("buyerId"));
            String nei = request.getParameter("nei");
            String yuan = request.getParameter("yuan");

            //添加一条维权信息
            tuikuan = new Tuikuan(ordeId, userId, buyerId, yuan, nei, yuan, time);
            int count = 0;
            if (yuan.equals("同意退款给买家")) {
                count = tuikunService.addTuikun(tuikuan);
                if (count == 1) {
                    //根据订单号查询订单信息
                    order = orderService.getOrder(ordeId);

                    UserService userService = new UserServiceImpl();
                    User user = new User();
                    user.setUserId(order.getBuyerId());//根据订单买家编号查询用户信息
                    user = userService.getUser(user);
                    userService.upMoney(user.getUserMoney() + order.getAmounts(), order.getBuyerId());
                    orderService.upOrde(ordeId, "维权结束");
                    message = new Message(order.getBuyerId(), "系统提醒", "人工已成功介入,并同意了您的退款申请", time, 1);

                    message = new Message(order.getEllerId(), "系统提醒", "人工已成功介入,并同意了对方的退款申请,理由:" + nei, time, 1);
                    messageService.addMessage(message);
                    out.print(count);
                }
            } else {
                count = tuikunService.addTuikun(tuikuan);
                if (count == 1) {
                    //根据订单号查询订单信息
                    order = orderService.getOrder(ordeId);
                    UserService userService = new UserServiceImpl();
                    User user = new User();
                    user.setUserId(order.getEllerId());//根据订单买家编号查询用户信息
                    user = userService.getUser(user);
                    userService.upMoney(user.getUserMoney() + order.getAmounts(), order.getEllerId());
                    orderService.upOrde(ordeId, "维权结束");
                    message = new Message(order.getBuyerId(), "系统提醒", "人工已成功介入,并拒绝了您的退款申请,拒绝理由:" + nei, time, 1);
                    messageService.addMessage(message);

                    message = new Message(order.getEllerId(), "系统提醒", "人工已成功介入,并拒绝了对方的退款申请,拒绝理由:" + nei, time, 1);
                    messageService.addMessage(message);
                    out.print(count);
                }
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
