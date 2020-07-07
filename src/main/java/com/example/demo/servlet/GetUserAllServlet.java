package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Search;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

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
 * Servlet implementation class GetUserAllServlet
 */
@WebServlet("/getUserAllServlet")
public class GetUserAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserAllServlet() {
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
        //获取开始日期
        String start = request.getParameter("start");
        //获取结束日期
        String end = request.getParameter("end");
        //获取用户名
        String name = request.getParameter("name");


        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        int pages = 0;
        int limits = 0;
        int count = 0;
        System.out.println("分页:" + page + "," + limit);

        List<User> liUser = new ArrayList<User>();
        UserService userService = new UserServiceImpl();

        User user = new User();
        Search search = new Search();
        if (type.equals("memberlist")) {
            //获取所有会员
            pages = Integer.parseInt(page);
            limits = Integer.parseInt(limit);
            liUser = userService.getUserAll(pages, limits);
            //根据参数查询总条数
            count = userService.getTotalNumber(search, type);

        } else if (type.equals("refermember")) {
            //根据参数查询会员
            pages = Integer.parseInt(page);
            limits = Integer.parseInt(limit);
            search.setEnd(end);
            search.setName(name);
            search.setStart(start);
            liUser = userService.getUser(search, type, pages, limits);
            //根据参数查询总条数
            count = userService.getTotalNumber(search, type);

            //根据参数查询总条数

        } else if (type.equals("merchantlist")) {
            //查询所有商家
            pages = Integer.parseInt(page);
            limits = Integer.parseInt(limit);
            user.setUserGrade(2);
            liUser = userService.getUserRun(user, pages, limits);
            search.setUser(user);
            //根据参数查询总条数
            count = userService.getTotalNumber(search, type);
        } else if (type.equals("violation")) {
            //查询所有封禁商家
            pages = Integer.parseInt(page);
            limits = Integer.parseInt(limit);
            user.setUserGrade(2);
            user.setUserStatus(2);
            search.setUser(user);
            liUser = userService.getUserRun(user, pages, limits);
            count = userService.getTotalNumber(search, type);
        } else if (type.equals("merchant")) {
            //根据参数查询商家
            pages = Integer.parseInt(page);
            limits = Integer.parseInt(limit);
            user.setUserGrade(2);
            search.setUser(user);
            search.setEnd(end);
            search.setName(name);
            search.setStart(start);
            liUser = userService.getUser(search, type, pages, limits);
            count = userService.getTotalNumber(search, type);
        } else if (type.equals("violationlist")) {
            //查询所有封禁商家
            pages = Integer.parseInt(page);
            limits = Integer.parseInt(limit);
            user.setUserGrade(2);
            user.setUserStatus(2);
            search.setUser(user);
            search.setUser(user);
            search.setEnd(end);
            search.setName(name);
            search.setStart(start);
            liUser = userService.getUser(search, type, pages, limits);
            count = userService.getTotalNumber(search, type);
        }

        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 0);
        json.put("data", liUser);
        json.put("count", count);
        out.print(json);


//		request.setAttribute("liUsers", liUser);
//		request.getRequestDispatcher("admin/member-list.jsp").forward(request, response);
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
