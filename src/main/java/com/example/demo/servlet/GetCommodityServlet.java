package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.User;
import com.example.demo.service.CommodityService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.CommodityServiceImpl;
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
 * Servlet implementation class GetCommodityServlet
 */
@WebServlet("/getCommodityServlet")
public class GetCommodityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String type = request.getParameter("type");
        System.out.println("分页:" + page + "," + limit);
        int pages = Integer.parseInt(page);
        int limits = Integer.parseInt(limit);
        String userName = request.getParameter("userName");//获取用户名
        List<Commodity> list = new ArrayList<Commodity>();
        CommodityService commodityService = new CommodityServiceImpl();

        Commodity commodity = new Commodity();
        int count = 0;
        if (type.equals("个人")) {
            //根据用户名获取用户信息
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setUserName(userName);
            user = userService.getUser(user);
            //根据用户编号查询商品信息
            list = commodityService.getComId(user.getUserId(), pages, limits);
            commodity.setCommodityMaster(user.getUserId());
            count = commodityService.getTotalNumber(commodity);

        } else if (type.equals("admin")) {
            list = commodityService.getComAll(pages, limits);
            count = commodityService.getTotalNumber();
        } else if (type.equals("上架")) {
            //查询所有上架的产品
            commodity.setCommodityState(3);
            list = commodityService.getCom(pages, limits, commodity);
            count = commodityService.getTotalNumber(commodity);

        } else if (type.equals("待审核")) {
            //查询所有待审核商品
            commodity.setCommodityState(1);
            list = commodityService.getCom(pages, limits, commodity);
            count = commodityService.getTotalNumber(commodity);
        } else if (type.equals("封禁")) {
            //查询所有封禁商品

            commodity.setCommodityState(5);
            list = commodityService.getCom(pages, limits, commodity);
            count = commodityService.getTotalNumber(commodity);
        } else if (type.equals("seek")) {
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            String content = request.getParameter("content");
            String status = request.getParameter("status");
            String contrllerGet = request.getParameter("contrllerGet");
            list = commodityService.getCommodityAndStatus(start, end, status, content, contrllerGet, pages, limits);
            count = commodityService.getComCount(start, end, status, content, contrllerGet);
        }


        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 0);
        json.put("data", list);
        json.put("count", count);
        out.print(json);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
