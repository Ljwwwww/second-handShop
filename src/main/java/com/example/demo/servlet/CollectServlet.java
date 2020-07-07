package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Collect;
import com.example.demo.entity.Commodity;
import com.example.demo.service.CollectService;
import com.example.demo.service.CommodityService;
import com.example.demo.service.impl.CollectSerivceImpl;
import com.example.demo.service.impl.CommodityServiceImpl;

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
 * Servlet implementation class CollectServlet
 */
@WebServlet("/collectServlet")
public class CollectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectServlet() {
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
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        CollectService collectService = new CollectSerivceImpl();
        Collect collect = null;
        CommodityService commodityService = new CommodityServiceImpl();

        if (type.equals("add")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int comId = Integer.parseInt(request.getParameter("comId"));
            collect = collectService.getColl(comId, userId);
            Commodity com = new Commodity();
            int count = 0;
            if (collect != null) {
                //商品已存在购物车
                out.print(-2);

            } else {
                com = commodityService.getCommodity(comId);
                //comId, String comName, int userId, double comPrice, String comImg
                collect = new Collect(com.getCommodityId(), com.getCommodityName(), userId, com.getCommodityPrice(), com.getCommodityShowimg());
                count = collectService.addColl(collect);
                System.out.println(count);
                out.print(count);

            }

        } else if (type.equals("all")) {
            List<Collect> list = new ArrayList<Collect>();
            int userId = Integer.parseInt(request.getParameter("userId"));
            list = collectService.getCollAll(userId);
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            json.put("count", 0);
            out.print(json);
        } else if (type.equals("del")) {
            //删除
            int comId = Integer.parseInt(request.getParameter("comId"));
            int count = collectService.delColl(comId);
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
