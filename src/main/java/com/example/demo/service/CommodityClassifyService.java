package com.example.demo.service;

import com.example.demo.entity.CommodityClassify;

import java.util.List;

public interface CommodityClassifyService {
    /**
     * 查询所有分类
     *
     * @return
     */
    public List<CommodityClassify> getCommodityClassify();

    /**
     * 添加分类
     *
     * @param commodityClassify
     * @return
     */
    public int addComCla(CommodityClassify commodityClassify);

    /**
     * 根据编号删除分类
     *
     * @param comClaId
     * @return
     */
    public int delComCla(String[] list);


}
