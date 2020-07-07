package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.MessageServiceImpl;
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
 * Servlet implementation class MessageServlet
 */
@WebServlet("/messageServlet")
public class MessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        MessageService messageService = new MessageServiceImpl();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //发布时间
        String time = df.format(new Date());// new Date()为获取当前系统时间

        Message message = null;
        if (type.equals("all")) {
            List<Message> list = new ArrayList<Message>();
            int userId = Integer.parseInt(request.getParameter("userId"));
            list = messageService.getMessageAll(userId);
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            out.print(json);
        } else if (type.equals("del")) {
            int messageId = Integer.parseInt(request.getParameter("messageId"));
            int count = messageService.delMessage(messageId);
            out.print(count);
        } else if (type.equals("biao")) {
            int messageId = Integer.parseInt(request.getParameter("messageId"));
            int count = messageService.upMessage(messageId, "已读");
            out.print(count);
        } else if (type.equals("enter")) {
            //入驻商家
            int userId = Integer.parseInt(request.getParameter("userId"));
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setUserId(userId);
            user = userService.getUser(user);
            message = new Message(1, "申请注入商家", "用户编号为:" + userId + "的用户,用户名为:" + user.getUserName() + "申请注册为商家", time, user.getUserId());
            messageService.addMessage(message);
        } else if (type.equals("audit")) {
            List<Message> list = new ArrayList<Message>();
            int userId = 1;
            list = messageService.getMessageAll(userId);
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            out.print(json);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
