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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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

        UserService userService = new UserServiceImpl();
        User user = new User();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (type.equals("login")) {
            String name = request.getParameter("username");
            String pwd = request.getParameter("password");
            String password = Md5.md5Password(pwd);//md5加密
            user.setUserName(name);
            user.setUserPwd(password);
            int count = userService.login(user);
            if (count == -1) {
                out.print("-1");
            } else {
                if (count == 0) {
                    out.print(count);
                    session.setAttribute("user", user);//登录成功，将用户数据放入到Session中
                } else {
                    out.print(count);
                    user.setUserName(user.getUserName());
                    user = userService.getUser(user);
                    session.setAttribute("userl", user);//登录成功，将用户数据放入到Session中
                }
            }
        } else if (type.equals("logout")) {
            //注销登陆
            session.removeAttribute("userl");
            out.print("1");
        }
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
