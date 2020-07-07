package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.CommodityClassify;
import com.example.demo.service.CommodityClassifyService;
import com.example.demo.service.impl.CommodityClassifyServiceImpl;

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
 * Servlet implementation class CommodityClassifyServlet
 */
@WebServlet("/commodityClassifyServlet")
public class CommodityClassifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityClassifyServlet() {
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
        CommodityClassifyService commodityClassifyService = new CommodityClassifyServiceImpl();
        List<CommodityClassify> list = new ArrayList<CommodityClassify>();
        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        int count = 0;

        if (type.equals("all")) {
            list = commodityClassifyService.getCommodityClassify();
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            out.print(json);
        } else if (type.equals("add")) {
            String claName = request.getParameter("classifyName");
            CommodityClassify commodityClassify = new CommodityClassify(claName);
            count = commodityClassifyService.addComCla(commodityClassify);
            out.print(count);
        } else if (type.equals("del")) {
            String comClaId = request.getParameter("comClaId");
            String li = null;
            String[] numberArray = null;
            if (comClaId != null) {
                li = request.getParameter("comClaId");
            } else {
                li = request.getParameter("ids");
            }
            numberArray = li.split(",");
            count = commodityClassifyService.delComCla(numberArray);
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
