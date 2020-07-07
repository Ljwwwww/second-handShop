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
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Get
 */
@WebServlet("/getUserServlet")
public class GetUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserServlet() {
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
        List<User> liUser = new ArrayList<User>();
        PrintWriter out = response.getWriter();
        if (type.equals("getId")) {
            String userName = request.getParameter("userName");
            user.setUserName(userName);
            userService.getUser(user);
            user = userService.getUser(user);
            out.print(user.getUserId());
        } else if (type.equals("修改")) {
            String userId = request.getParameter("userId");
            int userIds = 0;
            if (userId != null) {
                userIds = Integer.parseInt(userId);
            }
            user.setUserId(userIds);
            user = userService.getUser(user);
            liUser.add(user);
            request.setAttribute("ten", liUser);
            request.getRequestDispatcher("admin/upuser.jsp").forward(request, response);

        } else if (type.equals("zpwd")) {
            int count = 0;
            String zpwd = request.getParameter("zpwd");
            String userName = request.getParameter("userName");
            String zpwd1 = Md5.md5Password(zpwd);//md5加密
            //根据用户名查询用户信息


            user.setUserName(userName);
            user = userService.getUser(user);
            count = userService.isCorrect(user.getUserId(), zpwd1);
            out.print(count);
        } else if (type.equals("register")) {
            String userName = request.getParameter("username");
            user.setUserName(userName);
            user = userService.getUser(user);
            if (user == null) {
                out.print("true");
            } else {
                out.print("false");
            }
        } else if (type.equals("upUser")) {
            //用户修改
            String userId = request.getParameter("userId");
            int userIds = 0;
            if (userId != null) {
                userIds = Integer.parseInt(userId);
            }
            user.setUserId(userIds);
            user = userService.getUser(user);
            liUser.add(user);
            request.setAttribute("ten", liUser);
            request.getRequestDispatcher("home-page/upuser.jsp").forward(request, response);

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
