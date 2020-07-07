package com.example.demo.service.impl;

import com.example.demo.dao.CommodityDao;
import com.example.demo.dao.impl.CommodityDaoImpl;
import com.example.demo.entity.Commodity;
import com.example.demo.service.CommodityService;

import java.util.ArrayList;
import java.util.List;

public class CommodityServiceImpl implements CommodityService {
    /**
     * 查询所有商品
     */
    @Override
    public List<Commodity> getComAll(int page, int limit) {
        CommodityDao commoditydao = new CommodityDaoImpl();
        List<Commodity> list = new ArrayList<Commodity>();
        String sql = "SELECT `commodityId`,`commodityName`,`commodityPrice`,`commodityViewcount`,`commodityShowimg`,`originalCos`,`commodityCondition`,`commodityArea`,`commodityMaster`,`commodityIntroduce`,`commodityClid`,`commodityState`,`commodityDate`,`commodityClassify`,user.`userName` FROM commodity INNER JOIN `user` ON commodity.`commodityMaster`=`user`.`userId` LIMIT ?,?";
        Object[] param = {(page - 1) * limit, limit};
        list = commoditydao.getCommodity(sql, param);
        return list;
    }

    /**
     * 根据信息查询
     */
    @Override
    public List<Commodity> getCom(int page, int limit, Commodity commodity) {
        CommodityDao commoditydao = new CommodityDaoImpl();
        List<Commodity> list = new ArrayList<Commodity>();
        String sql = "SELECT `commodityId`,`commodityName`,`commodityPrice`,`commodityViewcount`,`commodityShowimg`,`originalCos`,`commodityCondition`,`commodityArea`,`commodityMaster`,`commodityIntroduce`,`commodityClid`,`commodityState`,`commodityDate`,`commodityClassify`,user.`userName` FROM commodity INNER JOIN `user` ON commodity.`commodityMaster`=`user`.`userId` where `commodityState`=? LIMIT ?,?";
        Object[] param = {commodity.getCommodityState(), (page - 1) * limit, limit};
        list = commoditydao.getCommodity(sql, param);
        return list;
    }

    /**
     * 查询数据总条数
     */
    @Override
    public int getTotalNumber() {
        CommodityDao commoditydao = new CommodityDaoImpl();
        String sql = "SELECT count(1) FROM commodity";
        int count = commoditydao.getTotalNumber(sql);
        return count;
    }

    /**
     * 根据商品信息查询总条数
     */
    @Override
    public int getTotalNumber(Commodity commodity) {
        CommodityDao commodityDao = new CommodityDaoImpl();
        String sql = null;

        int count = 0;
        if (commodity.getCommodityState() != 0) {
            sql = "SELECT COUNT(1) FROM commodity WHERE commodityState=?";
            Object param[] = {commodity.getCommodityState()};
            count = commodityDao.getTotalNumber(sql, param);
        } else if (commodity.getCommodityMaster() != 0) {
            sql = "SELECT COUNT(1) FROM commodity WHERE commodityMaster=?";
            Object param[] = {commodity.getCommodityMaster()};
            count = commodityDao.getTotalNumber(sql, param);
        }
        System.out.println("根据商品状态查询总条数" + count);
        return count;
    }

    /**
     * 添加商品
     */
    @Override
    public int addCommodity(Commodity commodity) {
        CommodityDao commoditydao = new CommodityDaoImpl();
        int count = 0;
        String sql = "INSERT INTO commodity (commodityName,commodityPrice,commodityViewcount,commodityShowimg,originalCos,commodityCondition,commodityArea,commodityMaster,commodityIntroduce,commodityClid,commodityState,commodityDate,commodityClassify)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] param = {commodity.getCommodityName(), commodity.getCommodityPrice(), commodity.getCommodityViewcount(), commodity.getCommodityShowimg(), commodity.getOriginalCos(), commodity.getCommodityCondition(), commodity.getCommodityArea(), commodity.getCommodityMaster(), commodity.getCommodityIntroduce(), commodity.getCommodityClid(), commodity.getCommodityState(), commodity.getCommodityDate(), commodity.getCommodityClassify()};
        count = commoditydao.updaCommodity(sql, param);
        return count;
    }

    /**
     * 获取主键id
     */
    @Override
    public int getId() {
        CommodityDao commoditydao = new CommodityDaoImpl();
        String sql = "SELECT MAX(commodityId) FROM commodity";
        int count = commoditydao.getTotalNumber(sql);
        return count;
    }

    /**
     * 修改商品状态
     */
    @Override
    public int upComStatus(int comId, int statusId) {
        CommodityDao commoditydao = new CommodityDaoImpl();
        String sql = "UPDATE commodity SET commodityState=? WHERE commodityId = ?";
        Object[] param = {statusId, comId};
        return commoditydao.updaCommodity(sql, param);
    }

    /**
     * 根据编号查询商品信息
     */
    @Override
    public Commodity getCommodity(int comId) {
        CommodityDao commoditydao = new CommodityDaoImpl();
        Commodity commodity = new Commodity();
        String sql = "SELECT `commodityId`,`commodityName`,`commodityPrice`,`commodityViewcount`,`commodityShowimg`,`originalCos`,`commodityCondition`,`commodityArea`,`commodityMaster`,`commodityIntroduce`,`commodityClid`,`commodityState`,`commodityDate`,`commodityClassify`,user.`userName` FROM commodity INNER JOIN `user` ON commodity.`commodityMaster`=`user`.`userId` WHERE commodityId=?";
        Object[] param = {comId};
        commodity = commoditydao.getCom(sql, param);
        return commodity;
    }

    @Override
    public List<Commodity> getCom(int comId) {
        CommodityDao commoditydao = new CommodityDaoImpl();
        List<Commodity> list = new ArrayList<Commodity>();
        String sql = "SELECT `commodityId`,`commodityName`,`commodityPrice`,`commodityViewcount`,`commodityShowimg`,`originalCos`,`commodityCondition`,`commodityArea`,`commodityMaster`,`commodityIntroduce`,`commodityClid`,`commodityState`,`commodityDate`,`commodityClassify`,user.`userName` FROM commodity INNER JOIN `user` ON commodity.`commodityMaster`=`user`.`userId`  WHERE commodityId=?";
        Object[] param = {comId};
        list = commoditydao.getCommodity(sql, param);
        return list;
    }

    /**
     * 根据用户编号查询商品信息
     */
    @Override
    public List<Commodity> getComId(int userId, int page, int limit) {
        CommodityDao commoditydao = new CommodityDaoImpl();
        List<Commodity> list = new ArrayList<Commodity>();
        Object param[] = {userId, (page - 1) * limit, limit};
        String sql = "SELECT `commodityId`,`commodityName`,`commodityPrice`,`commodityViewcount`,`commodityShowimg`,`originalCos`,`commodityCondition`,`commodityArea`,`commodityMaster`,`commodityIntroduce`,`commodityClid`,`commodityState`,`commodityDate`,`commodityClassify`,user.`userName` FROM commodity INNER JOIN `user` ON commodity.`commodityMaster`=`user`.`userId`  WHERE `commodityMaster`=? LIMIT ?,?";
        list = commoditydao.getCommodity(sql, param);
        return list;
    }

    /**
     * 根据商品编号删除商品
     */
    @Override
    public int delCom(String[] list) {
        String sql = null;
        CommodityDao commodityDao = new CommodityDaoImpl();
        int count = 0;
        if (list.length > 1) {
            sql = "DELETE FROM commodity WHERE commodityId in(?)";
        } else {
            sql = "DELETE FROM commodity WHERE commodityId =?";
        }
        for (int i = 0; i < list.length; i++) {
            if (",".equals(list[i])) {
                break;
            }
            int comId = Integer.parseInt(list[i]);
            Object param[] = {comId};
            count = commodityDao.updaCommodity(sql, param);
        }

        return count;
    }

    @Override
    public List<Commodity> getCommodityAndStatus(String date1, String date2, String status, String name, String contrllerGet, int page, int limit) {
        List<Commodity> list = new ArrayList<>();
        System.out.println("时间:" + date1 + "\n时间2:" + date2);
        System.out.println("状态:" + status);
        System.out.println("name:" + name);
        CommodityDao commodityDao = new CommodityDaoImpl();
        StringBuffer buffer = new StringBuffer("SELECT * FROM commodity \r\n" +
                "INNER JOIN commodity_state ON  commodity.`commodityState`="
                + "commodity_state.`comStid` INNER JOIN `user` ON user.userId="
                + "commodity.commodityMaster \r\nWHERE 1=1  ");

        List<Object> params = new ArrayList<>();
        if (date1 != "") {
            buffer.append("AND commodityDate>? ");
            params.add(date1);
        }
        if (date2 != "") {
            buffer.append("AND commodityDate<? ");
            params.add(date2);
        }
        if (status != null && status != "") {
            buffer.append("AND comStname=? ");
            params.add(status);
        }
        System.out.println(name);
        if (name != null && name != "") {
            if (contrllerGet.equals("成色")) {
                buffer.append("AND commodityCondition=?");
                params.add(name);
            } else if (contrllerGet.equals("商品名")) {
                if (name != null && name != "商家名") {
                    buffer.append("AND commodityName like concat('%',?,'%') ");
                    params.add(name);
                }

            } else if (contrllerGet.equals("商家名")) {
                buffer.append("AND userName like concat('%',?,'%') ");
                params.add(name);
            }

        }
        buffer.append("LIMIT ?,?");
        params.add((page - 1) * limit);
        params.add(limit);
        String sql = buffer.toString();
        System.out.println("sql:" + sql);
        Object[] param = params.toArray();
        list = commodityDao.getCommodity(sql, param);
        return list;
    }

    @Override
    public int getComCount(String date1, String date2, String status, String name, String contrllerGet) {
        CommodityDao commodityDao = new CommodityDaoImpl();
        StringBuffer buffer = new StringBuffer("SELECT count(1) FROM commodity \r\n" +
                "INNER JOIN commodity_state ON  commodity.`commodityState`="
                + "commodity_state.`comStid` INNER JOIN `user` ON user.userId="
                + "commodity.commodityMaster \r\nWHERE 1=1  ");

        List<Object> params = new ArrayList<>();
        if (date1 != "") {
            buffer.append("AND commodityDate>? ");
            params.add(date1);
        }
        if (date2 != "") {
            buffer.append("AND commodityDate<? ");
            params.add(date2);
        }
        if (status != null && status != "") {
            buffer.append("AND comStname=? ");
            params.add(status);
        }
        System.out.println(name);
        if (name != null && name != "") {
            if (contrllerGet.equals("成色")) {
                buffer.append("AND commodityCondition=?");
                params.add(name);
            } else if (contrllerGet.equals("商品名")) {
                if (name != null && name != "商家名") {
                    buffer.append("AND commodityName like concat('%',?,'%') ");
                    params.add(name);
                }

            } else if (contrllerGet.equals("商家名")) {
                buffer.append("AND userName like concat('%',?,'%') ");
                params.add(name);
            }

        }
        String sql = buffer.toString();
        Object[] param = params.toArray();
        return commodityDao.getTotalNumber(sql, param);
    }

    //根据商品编号返回商家id
    public int getEllerIdByComId(int comId) {
        CommodityDao commodityDao = new CommodityDaoImpl();
        String sql = "SELECT commodityId,commodityMaster FROM  commodity where commodityId=?";
        Commodity commodity = commodityDao.getComIdM(sql, comId);
        return commodity.getCommodityMaster();
    }

    //模糊搜索
    @Override
    public List<Commodity> getComAllMo(String name) {
        CommodityDao commodityDao = new CommodityDaoImpl();
        String sql = "SELECT * FROM `commodity` WHERE `commodityState`=3 AND `commodityName`like concat('%',?,'%')";
        Object[] param = {name};
        return commodityDao.getCommodity(sql, param);

    }
}
