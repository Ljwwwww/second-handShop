package com.example.demo.servlet;

import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.MessageServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.tool.Md5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class UpdataUserServlet
 */
@WebServlet("/updataUserServlet")
public class UpdataUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataUserServlet() {
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
        String userId = request.getParameter("userId");
        String statusName = request.getParameter("username");
        String upUser = request.getParameter("upUser");
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        String zpwd = request.getParameter("z_pass");
        String sex = request.getParameter("sex");
        String userGrade = request.getParameter("userGrade");
        String userStatu = request.getParameter("userStatus");
        String userMoney = request.getParameter("money");

        String statusNamet = request.getParameter("statusName");
        System.out.println("修改方向:" + upUser);
        System.out.println("等级编号:" + statusNamet);
        UserService userService = new UserServiceImpl();
        PrintWriter out = response.getWriter();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        int userIds = 0;

        User user = null;
        int count = 0;//执行修改的返回值
        if (upUser.equals("信息")) {
            String password = pwd;
            String zpassword = zpwd;
            if (pwd.length() < 10) {
                password = Md5.md5Password(pwd);
                zpassword = Md5.md5Password(zpwd);
            }
            if (zpwd.length() < 10) {
                zpassword = Md5.md5Password(zpwd);
            }
            int userGrades = Integer.parseInt(userGrade);
            int userStatus = Integer.parseInt(userStatu);
            userIds = Integer.parseInt(userId);
            System.out.println("加密后密码:" + password);
            double moeny = Double.parseDouble(userMoney);

            user = new User(userIds, statusName, password, sex, phone, userStatus, userGrades, zpassword, moeny);
            count = userService.upUser(user);
            out.print(count);
        } else if (upUser.equals("删除")) {


            String li = null;
            String[] numberArray = null;
            if (userId != null) {
                //删除单个
                li = request.getParameter("userId");
            } else {
                li = request.getParameter("ids");
            }
            numberArray = li.split(",");
            count = userService.delUser(numberArray);
            out.print(count);


        } else if (upUser.equals("修改密码")) {
            userIds = Integer.parseInt(userId);
            String password = pwd;
            String zpassword = zpwd;
            if (pwd.length() < 10) {
                password = Md5.md5Password(pwd);
                zpassword = Md5.md5Password(zpwd);
            }
            if (zpwd.length() < 10) {
                zpassword = Md5.md5Password(zpwd);
            }

            user = new User(userIds, password, zpassword);
            count = userService.upUser(user);
            out.print(count);
        } else if (upUser.equals("enter")) {
            //入住商家
            userIds = Integer.parseInt(userId);

            count = userService.upEnter(userIds);
            //修改消息状态
            MessageService messageService = new MessageServiceImpl();
            int messageId = Integer.parseInt(request.getParameter("mesId"));
            int mesCount = messageService.upMessage(messageId, "已读");
            if (mesCount == 1 && count == 1) {
                out.print(count);
            }
        } else if (upUser.equals("refuse")) {
            //拒绝商家审核信息
            userIds = Integer.parseInt(userId);
            int messageId = Integer.parseInt(request.getParameter("mesId"));
            MessageService messageService = new MessageServiceImpl();
            int mesCount = messageService.upMessage(messageId, "已拒绝");
            Message message = new Message(userIds, "系统提醒", "您的入驻商家申请已被管理员拒绝!", time, 1);
            ;
            count = messageService.addMessage(message);
            if (mesCount == 1 && count == 1) {
                out.print(count);
            }
        } else if (upUser.equals("upuser")) {
            //用户修改信息
            String password = pwd;
            String zpassword = zpwd;
            if (pwd.length() < 10) {
                password = Md5.md5Password(pwd);
                zpassword = Md5.md5Password(zpwd);
            }
            if (zpwd.length() < 10) {
                zpassword = Md5.md5Password(zpwd);
            }
            userIds = Integer.parseInt(userId);
            System.out.println("加密后密码:" + password);
            user = new User(userIds, statusName, password, sex, phone, zpassword);
            count = userService.upuser(user);
            out.print(count);

        } else {
            userIds = Integer.parseInt(userId);
            user = new User();
            user.setUserId(userIds);
            if (statusNamet.equals("已启用")) {
                user.setUserStatus(2);
            } else {
                user.setUserStatus(1);
            }

            count = userService.updata(user);
            out.print(count);
        }


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
