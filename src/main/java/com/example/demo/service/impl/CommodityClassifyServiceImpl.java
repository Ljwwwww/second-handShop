package com.example.demo.service.impl;

import com.example.demo.dao.CommodityClassifyDao;
import com.example.demo.dao.impl.CommodityClassifyDaoImpl;
import com.example.demo.entity.CommodityClassify;
import com.example.demo.service.CommodityClassifyService;

import java.util.ArrayList;
import java.util.List;

public class CommodityClassifyServiceImpl implements CommodityClassifyService {

    @Override
    public List<CommodityClassify> getCommodityClassify() {
        String sql = "SELECT * FROM commodity_classify";
        CommodityClassifyDao commodityClassifyDao = new CommodityClassifyDaoImpl();

        List<CommodityClassify> list = new ArrayList<CommodityClassify>();
        list = commodityClassifyDao.getCommodityClassify(sql);
        return list;
    }

    @Override
    public int addComCla(CommodityClassify commodityClassify) {
        String sql = "INSERT INTO `commodity_classify` (`classifyName`) VALUES(?)";
        CommodityClassifyDao commodityClassifyDao = new CommodityClassifyDaoImpl();
        Object[] param = {commodityClassify.getClassifyName()};
        int count = commodityClassifyDao.upComCla(sql, param);
        return count;
    }

    @Override
    public int delComCla(String[] list) {
        String sql = "DELETE FROM commodity_classify WHERE `classifyId` IN(?)";
        CommodityClassifyDao commodityClassifyDao = new CommodityClassifyDaoImpl();
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            Object param[] = {Integer.parseInt(list[i])};
            count = commodityClassifyDao.upComCla(sql, param);
        }
        return count;
    }


}
