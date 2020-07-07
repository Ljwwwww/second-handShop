package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.CommodityDao;
import com.example.demo.entity.Commodity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityDaoImpl extends BaseDao implements CommodityDao {

    @Override
    public List<Commodity> getCommodityAll(String sql) {
        List<Commodity> list = new ArrayList<Commodity>();
        Commodity commodity = null;
        this.rs = executeQuery(sql);
        try {
            while (rs.next()) {
                commodity = new Commodity();
                commodity.setCommodityId(rs.getInt("commodityId"));
                commodity.setCommodityName(rs.getString("commodityName"));
                commodity.setCommodityPrice(rs.getDouble("commodityPrice"));
                commodity.setCommodityViewcount(rs.getInt("commodityViewcount"));
                commodity.setCommodityShowimg("\\secondhand_shop\\upload\\" + rs.getString("commodityShowimg"));
                commodity.setOriginalCos(rs.getDouble("originalCos"));
                commodity.setCommodityCondition(rs.getString("commodityCondition"));
                commodity.setCommodityArea(rs.getString("commodityArea"));
                commodity.setCommodityMaster(rs.getInt("commodityMaster"));
                commodity.setCommodityIntroduce(rs.getString("commodityIntroduce"));
                commodity.setCommodityClid(rs.getInt("commodityClid"));
                commodity.setCommodityState(rs.getInt("commodityState"));
                commodity.setCommodityDate(rs.getString("commodityDate"));
                commodity.setCommodityClassify(rs.getInt("commodityClassify"));
                list.add(commodity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Commodity> getCommodity(String sql, Object... param) {
        List<Commodity> list = new ArrayList<Commodity>();
        Commodity commodity = null;

        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                commodity = new Commodity();
                commodity.setCommodityId(rs.getInt("commodityId"));
                commodity.setCommodityName(rs.getString("commodityName"));
                commodity.setCommodityPrice(rs.getDouble("commodityPrice"));
                commodity.setCommodityViewcount(rs.getInt("commodityViewcount"));
                commodity.setCommodityShowimg("\\secondhand_shop\\upload\\" + rs.getString("commodityShowimg"));
                commodity.setOriginalCos(rs.getDouble("originalCos"));
                commodity.setCommodityCondition(rs.getString("commodityCondition"));
                commodity.setCommodityArea(rs.getString("commodityArea"));
                commodity.setCommodityMaster(rs.getInt("commodityMaster"));
                commodity.setCommodityIntroduce(rs.getString("commodityIntroduce"));
                commodity.setCommodityClid(rs.getInt("commodityClid"));
                commodity.setCommodityState(rs.getInt("commodityState"));
                commodity.setCommodityDate(rs.getString("commodityDate"));
                commodity.setCommodityClassify(rs.getInt("commodityClassify"));
                list.add(commodity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 更新商品信息
     */
    @Override
    public int updaCommodity(String sql, Object... param) {
        Integer result = null;
        try {
            result = this.executeUpdate(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return result;
    }

    /**
     * 根据参数查询商品总条数
     */
    @Override
    public int getTotalNumber(String sql, Object... object) {
        int count = 0;
        this.rs = executeQuery(sql, object);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    /**
     * 查询总条数
     */
    @Override
    public int getTotalNumber(String sql) {
        int count = 0;
        this.rs = executeQuery(sql);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    @Override
    public int getId() {
        String sql = "SELECT LAST_INSERT_ID() AS id";
        int count = 0;
        this.rs = executeQuery(sql);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    @Override
    public Commodity getCom(String sql, Object... param) {
        Commodity commodity = null;

        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                commodity = new Commodity();
                commodity.setCommodityId(rs.getInt("commodityId"));
                commodity.setCommodityName(rs.getString("commodityName"));
                commodity.setCommodityPrice(rs.getDouble("commodityPrice"));
                commodity.setCommodityViewcount(rs.getInt("commodityViewcount"));
                commodity.setCommodityShowimg("\\secondhand_shop\\upload\\" + rs.getString("commodityShowimg"));
                commodity.setOriginalCos(rs.getDouble("originalCos"));
                commodity.setCommodityCondition(rs.getString("commodityCondition"));
                commodity.setCommodityArea(rs.getString("commodityArea"));
                commodity.setCommodityMaster(rs.getInt("commodityMaster"));
                commodity.setCommodityIntroduce(rs.getString("commodityIntroduce"));
                commodity.setCommodityClid(rs.getInt("commodityClid"));
                commodity.setCommodityState(rs.getInt("commodityState"));
                commodity.setCommodityDate(rs.getString("commodityDate"));
                commodity.setCommodityClassify(rs.getInt("commodityClassify"));
                commodity.setUserName(rs.getString("userName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity;
    }

    @Override
    public Commodity getComIdM(String sql, Object... objects) {
        Commodity commodity = null;
        try {
            this.rs = executeQuery(sql, objects);
            while (rs.next()) {
                commodity = new Commodity();
                commodity.setCommodityId(rs.getInt("commodityId"));
                commodity.setCommodityMaster(rs.getInt("commodityMaster"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity;
    }

    @Override
    public List<Commodity> getcom(String sql, Object... param) {
        List<Commodity> list = new ArrayList<Commodity>();
        Commodity commodity = null;

        try {
            this.rs = executeSearch(sql, param);
            while (rs.next()) {
                commodity = new Commodity();
                commodity.setCommodityId(rs.getInt("commodityId"));
                commodity.setCommodityName(rs.getString("commodityName"));
                commodity.setCommodityPrice(rs.getDouble("commodityPrice"));
                commodity.setCommodityViewcount(rs.getInt("commodityViewcount"));
                commodity.setCommodityShowimg("\\secondhand_shop\\upload\\" + rs.getString("commodityShowimg"));
                commodity.setOriginalCos(rs.getDouble("originalCos"));
                commodity.setCommodityCondition(rs.getString("commodityCondition"));
                commodity.setCommodityArea(rs.getString("commodityArea"));
                commodity.setCommodityMaster(rs.getInt("commodityMaster"));
                commodity.setCommodityIntroduce(rs.getString("commodityIntroduce"));
                commodity.setCommodityClid(rs.getInt("commodityClid"));
                commodity.setCommodityState(rs.getInt("commodityState"));
                commodity.setCommodityDate(rs.getString("commodityDate"));
                commodity.setCommodityClassify(rs.getInt("commodityClassify"));
                commodity.setUserName(rs.getString("userName"));
                list.add(commodity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
