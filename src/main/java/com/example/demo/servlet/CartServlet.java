package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Commodity;
import com.example.demo.service.CartService;
import com.example.demo.service.CommodityService;
import com.example.demo.service.impl.CartServiceImpl;
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
 * Servlet implementation class CartServlet
 */
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
        CommodityService commodityService = new CommodityServiceImpl();
        CartService cartService = new CartServiceImpl();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        int count = 0;
        if (type.equals("add")) {
            String comIds = request.getParameter("comId");
            int shul = Integer.parseInt(request.getParameter("shul"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            int comId = Integer.parseInt(comIds);
            Commodity com = new Commodity();
            com = commodityService.getCommodity(comId);
            Cart cart1 = new Cart();
            cart1 = cartService.getCart(comId, userId);
            if (cart1 == null) {
                Cart cart = new Cart(com.getCommodityId(), com.getCommodityName(), com.getOriginalCos(), com.getCommodityPrice(), shul, com.getCommodityShowimg(), userId);
                count = cartService.addCart(cart);
                out.print(count);
            } else {
                out.print(-2);
            }

        } else if (type.equals("all")) {
            List<Cart> list = new ArrayList<Cart>();
            int userId = Integer.parseInt(request.getParameter("userId"));
            list = cartService.getCartAll(userId);
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            json.put("count", count);
            out.print(json);
        } else if (type.equals("del")) {
            //删除
            int cartId = Integer.parseInt(request.getParameter("cartId"));
            count = cartService.delCart(cartId);
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
