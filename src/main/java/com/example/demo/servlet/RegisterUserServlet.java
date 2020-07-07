package com.example.demo.servlet;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
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
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
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
        String phone = request.getParameter("phone");
        String name = request.getParameter("username");
        String sexCon = request.getParameter("sex");
        String pwd = request.getParameter("pwd");
        String userGrade = request.getParameter("userGrade");//用户等级
        System.out.println("等级:" + userGrade);
        int userGrades = 0;
        if (userGrade != null) {
            userGrades = Integer.parseInt(userGrade);
        }
//		System.out.println(name);
        String password = Md5.md5Password(pwd);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date());// new Date()为获取当前系统时间
        User user = null;
        UserService userService = new UserServiceImpl();

        int count = 0;
        if (userGrade != null) {
            user = new User(name, password, sexCon, phone, userGrades, time, password);
            count = userService.addUser(user);
        } else {
            user = new User(name, password, sexCon, phone, time, password);
            count = userService.addUser(user);

        }

        PrintWriter out = response.getWriter();
        out.print(count);
        out.flush();
        out.close();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
