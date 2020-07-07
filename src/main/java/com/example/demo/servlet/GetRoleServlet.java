package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserGrade;
import com.example.demo.service.UserGradeService;
import com.example.demo.service.impl.UserGradeServiceImpl;

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
 * Servlet implementation class GetRoleServlet
 */
@WebServlet("/getRoleServlet")
public class GetRoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRoleServlet() {
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

        List<UserGrade> list = new ArrayList<UserGrade>();
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        UserGradeService userGradeService = new UserGradeServiceImpl();
        JSONObject json = new JSONObject();
        String userGradeId = request.getParameter("userGradeId");
        int count = 0;
        if (type.equals("all")) {
            //查询所有等级

            list = userGradeService.getUserAll();
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            out.print(json);
        } else if (type.equals("del")) {

            //删除等级信息
            String li = null;
            String[] numberArray = null;
            if (userGradeId != null) {
                //删除单个
                numberArray = new String[1];
                numberArray[0] = userGradeId;
            } else {
                li = request.getParameter("ids");
            }
            numberArray = li.split(",");
            count = userGradeService.delUserGrade(numberArray);
            out.print(count);
        } else if (type.equals("add")) {
            //添加等级信息
            String gradeName = request.getParameter("gradeName");
            String explain = request.getParameter("explain");
            UserGrade userGrade = new UserGrade(gradeName, explain);
            count = userGradeService.addUserGrade(userGrade);
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
