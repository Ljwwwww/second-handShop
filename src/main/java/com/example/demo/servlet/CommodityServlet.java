package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.CommodityClassify;
import com.example.demo.entity.Message;
import com.example.demo.entity.Picture;
import com.example.demo.service.CommodityClassifyService;
import com.example.demo.service.CommodityService;
import com.example.demo.service.MessageService;
import com.example.demo.service.PictureService;
import com.example.demo.service.impl.CommodityClassifyServiceImpl;
import com.example.demo.service.impl.CommodityServiceImpl;
import com.example.demo.service.impl.MessageServiceImpl;
import com.example.demo.service.impl.PictureServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class CommodityServlet
 */
@WebServlet("/commodityServlet")
public class CommodityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityServlet() {
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
        int count = 0;//接收更新后的返回值
        CommodityService commodityService = new CommodityServiceImpl();
        String type = request.getParameter("type");

        PrintWriter out = response.getWriter();
        MessageService messageService = new MessageServiceImpl();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //发布时间
        String time = df.format(new Date());// new Date()为获取当前系统时间
        Message message = null;
        if (type.equals("添加")) {
            String commodityClids = request.getParameter("classifyName");//商品分类
            int commodityClid = Integer.parseInt(commodityClids);//商品分类
            String commodityMasters = request.getParameter("userId");
            int commodityMaster = Integer.parseInt(commodityMasters);//主人编号
            String commodityName = request.getParameter("productName");//商品名称
            String originalCoss = request.getParameter("originalPrice");//原价
            double originalCos = Double.parseDouble(originalCoss);
            String commodityPrices = request.getParameter("presentPrice");//现价
            double commodityPrice = Double.parseDouble(commodityPrices);
            String commodityCondition = request.getParameter("condition");//成色
            String commodityArea = request.getParameter("locality");//所在地
            String commodityIntroduce = request.getParameter("remarks");//商品介绍
            String commodityClassifys = request.getParameter("commodityClassify");
            int commodityClassify = Integer.parseInt(commodityClassifys);//商品数量


            Commodity commodity = null;
            String commodityShowimg = request.getParameter("thumbnail");//缩略图

            String articleIdList = request.getParameter("articleIdList");//图集
            String[] strArr = articleIdList.split(",");
            commodity = new Commodity(commodityName, commodityPrice, 0, commodityShowimg, originalCos, commodityCondition, commodityArea, commodityMaster, commodityIntroduce, commodityClid, 1, time, commodityClassify);
            count = commodityService.addCommodity(commodity);
            int idCount = commodityService.getId();//查询总条数
            PictureService pictureService = new PictureServiceImpl();
            System.out.println("提交状态:" + count);
            Picture picture = null;

            int count1 = 0;
            for (int i = 0; i < strArr.length; i++) {
                picture = new Picture();
                picture.setComId(idCount);
                picture.setImgAdd(strArr[i]);
                count1 = pictureService.addComImg(picture);
            }

            if (count > 0 && count1 > 0) {
                out.print("true");
            } else {
                out.print("false");
            }
        } else if (type.equals("分类")) {
            CommodityClassifyService commodityClassifyService = new CommodityClassifyServiceImpl();
            List<CommodityClassify> list = new ArrayList<CommodityClassify>();
            list = commodityClassifyService.getCommodityClassify();

            JSONObject json = new JSONObject();
            json.put("msg", "success");
            json.put("code", 0);
            json.put("data", list);
            out.print(json);
        } else if (type.equals("审核")) {
            String comId = request.getParameter("comId");//商品编号

            int comIds = Integer.parseInt(comId);

            String status = request.getParameter("status");
            int statusId = Integer.parseInt(status);
            System.out.println("status:" + status);
            int coint = commodityService.upComStatus(comIds, statusId);
            Commodity com = new Commodity();
            com = commodityService.getCommodity(comIds);
            if (coint == 1) {
                if (statusId == 3) {
                    message = new Message(com.getCommodityMaster(), "系统消息", "您的商品" + com.getCommodityName() + "通过审核!", time, 1);
                } else if (statusId == 2) {
                    message = new Message(com.getCommodityMaster(), "系统消息", "您的商品" + com.getCommodityName() + "审核已被拒绝通过!", time, 1);
                } else if (statusId == 1) {
                    message = new Message(com.getCommodityMaster(), "系统消息", "您的商品" + com.getCommodityName() + "已经进入反审阶段!", time, 1);
                } else if (statusId == 5) {
                    message = new Message(com.getCommodityMaster(), "系统消息", "您的商品" + com.getCommodityName() + "已被管理员封禁!", time, 1);
                } else if (statusId == 4) {
                    message = new Message(com.getCommodityMaster(), "系统消息", "您的商品" + com.getCommodityName() + "已被管理员解除封禁!", time, 1);
                }
                System.out.println("消息发生状态:" + messageService.addMessage(message));
            }
            out.print(coint);
        } else if (type.equals("查看")) {
            String comId = request.getParameter("comId");//商品编号
            int comIds = Integer.parseInt(comId);
            PictureService pictureService = new PictureServiceImpl();
            List<Picture> liPictures = new ArrayList<>();
            List<Commodity> liCom = new ArrayList<>();
            liPictures = pictureService.getPicture(comIds);//根据编号查询商品展示图
            Commodity commodity = new Commodity();
            liCom = commodityService.getCom(comIds);//根据编号查询商品信息
            request.setAttribute("liPictures", liPictures);
            request.setAttribute("com", liCom);
            request.getRequestDispatcher("admin/get-commodity.jsp").forward(request, response);
        } else if (type.equals("cyli")) {    //获取商品信息
            String comId = request.getParameter("comId");//商品编号
            int comIds = Integer.parseInt(comId);
            PictureService pictureService = new PictureServiceImpl();
            List<Picture> liPictures = new ArrayList<>();
            List<Commodity> liCom = new ArrayList<>();
            liPictures = pictureService.getPicture(comIds);//根据编号查询商品展示图
            Commodity commodity = new Commodity();
            liCom = commodityService.getCom(comIds);//根据编号查询商品信息
            request.setAttribute("liPictures", liPictures);
            request.setAttribute("com", liCom);
            request.getRequestDispatcher("home-page/detail.jsp").forward(request, response);
        } else if (type.equals("删除")) {

            String comId = request.getParameter("comId");//商品编号
            String[] li = null;

            if (comId != null) {
                //删除单个
                li = new String[1];
                li[0] = comId;
                count = commodityService.delCom(li);

            } else {
                //批量删除
                li = request.getParameterValues("ids");
                count = commodityService.delCom(li);
            }
            out.print(count);

        } else if (type.equals("number")) {
            String comId = request.getParameter("comId");
            int comIds = Integer.parseInt(comId);
            String number = request.getParameter("number");
            int numbers = Integer.parseInt(number);
            Commodity commodity = commodityService.getCommodity(comIds);
            System.out.println("数量" + numbers);
            System.err.println(commodity.getCommodityClassify());
            if (commodity.getCommodityClassify() < numbers) {
                out.print("true");
            } else {
                out.print("false");
            }
        } else if (type.equals("userget")) {
            String comId = request.getParameter("comId");//商品编号
            int comIds = Integer.parseInt(comId);
            PictureService pictureService = new PictureServiceImpl();
            List<Picture> liPictures = new ArrayList<>();
            List<Commodity> liCom = new ArrayList<>();
            liPictures = pictureService.getPicture(comIds);//根据编号查询商品展示图
            liCom = commodityService.getCom(comIds);//根据编号查询商品信息
            request.setAttribute("liPictures", liPictures);
            request.setAttribute("com", liCom);
            request.getRequestDispatcher("home-page/get-commodity.jsp").forward(request, response);
        } else if (type.equals("gatAll")) {
            //搜索商品
            String name = request.getParameter("comName");
            List<Commodity> liCom = new ArrayList<>();
            liCom = commodityService.getComAllMo(name);
            request.setAttribute("com", liCom);
            request.getRequestDispatcher("home-page/listTwo.jsp").forward(request, response);

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
