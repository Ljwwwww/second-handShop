package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAddress;
import com.example.demo.service.UserAddressService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserAddressServiceImpl;
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
 * Servlet implementation class UserAddressServlet
 */
@WebServlet("/userAddressServlet")
public class UserAddressServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddressServlet() {
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
        UserAddressService userAddressServlet = new UserAddressServiceImpl();
        String userName = request.getParameter("userName");
        int count = 0;
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        String type = request.getParameter("type");
        if (type.equals("add")) {
            String province = request.getParameter("province");
            String city = request.getParameter("city");
            String area = request.getParameter("area");
            String consignee = request.getParameter("consignee");
            String phone = request.getParameter("phone");
            String mo = request.getParameter("mo");

            String detailedAddress = request.getParameter("address");
            if (mo == null) {
                mo = "否";
            } else {
                mo = "是";
            }
            //获取用户编号
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setUserName(userName);
            user = userService.getUser(user);
            UserAddress userAddress = new UserAddress(province + city + area, user.getUserId(), phone, detailedAddress, consignee, mo);
            count = userAddressServlet.addUserAddress(userAddress);
            out.print(count);
        } else if (type.equals("getadd")) {
            //获取用户编号
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setUserName(userName);
            user = userService.getUser(user);
            List<UserAddress> list = new ArrayList<UserAddress>();

            list = userAddressServlet.getAddAll(user.getUserId());

            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            json.put("count", count);
            out.print(json);
        } else if (type.equals("del")) {
            //删除
            int addressId = Integer.parseInt(request.getParameter("addressId"));
            count = userAddressServlet.delAdd(addressId);
            out.print(count);
        }


        out.close();
        out.flush();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
