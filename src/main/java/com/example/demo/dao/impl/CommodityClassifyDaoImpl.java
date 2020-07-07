package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.CommodityClassifyDao;
import com.example.demo.entity.CommodityClassify;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CommodityClassifyDaoImpl extends BaseDao implements CommodityClassifyDao {

    @Override
    public List<CommodityClassify> getCommodityClassify(String sql, Object... objects) {
        CommodityClassify commodityClassify = null;
        List<CommodityClassify> list = new ArrayList<CommodityClassify>();
        try {
            this.rs = executeQuery(sql, objects);
            while (rs.next()) {
                commodityClassify = new CommodityClassify();
                commodityClassify.setClassifyId(rs.getInt("classifyId"));
                commodityClassify.setClassifyName(rs.getString("classifyName"));
                list.add(commodityClassify);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;

    }

    @Override
    public int upComCla(String sql, Object... objects) {
        Integer result = null;
        try {
            result = this.executeUpdate(sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //this.closeAll();
        }
        return result;
    }

    @Override
    public List<CommodityClassify> getCommodityClassify(String sql) {
        CommodityClassify commodityClassify = null;
        List<CommodityClassify> list = new ArrayList<CommodityClassify>();
        try {
            this.rs = executeQuery(sql);
            while (rs.next()) {
                commodityClassify = new CommodityClassify();
                commodityClassify.setClassifyId(rs.getInt("classifyId"));
                commodityClassify.setClassifyName(rs.getString("classifyName"));
                list.add(commodityClassify);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

}
