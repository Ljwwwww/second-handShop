package com.example.demo.dao;

import com.example.demo.entity.CommodityClassify;
import com.example.demo.entity.CommodityClassify;

import java.util.List;

public interface CommodityClassifyDao {
    /**
     * 查询
     *
     * @param sql
     * @param objects
     * @return
     */
    public List<CommodityClassify> getCommodityClassify(String sql, Object... objects);

    /**
     * 查询
     *
     * @param sql
     * @return
     */
    public List<CommodityClassify> getCommodityClassify(String sql);

    /**
     * 更新
     *
     * @param sql
     * @param objects
     * @return
     */
    public int upComCla(String sql, Object... objects);


}
