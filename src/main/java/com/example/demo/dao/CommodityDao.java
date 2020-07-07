package com.example.demo.dao;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.Commodity;

import java.util.List;

public interface CommodityDao {

    /**
     * 查询所有商品
     *
     * @return
     */
    public List<Commodity> getCommodityAll(String sql);

    /**
     * 根据信息查询商品
     *
     * @param sql
     * @param objects
     * @return
     */
    public List<Commodity> getCommodity(String sql, Object... objects);

    /**
     * 根据信息查询单个商品信息
     *
     * @param sql
     * @param objects
     * @return
     */
    public Commodity getCom(String sql, Object... objects);

    /**
     * 根据参数查询商品的编号和主人编号
     *
     * @param sql
     * @param objects
     * @return
     */
    public Commodity getComIdM(String sql, Object... objects);

    /**
     * 更新商品信息
     *
     * @param sql
     * @param commodity
     * @return
     */
    public int updaCommodity(String sql, Object... param);

    /**
     * 查询总条数
     *
     * @param number
     * @param object
     * @return
     */
    public int getTotalNumber(String sql, Object... object);

    /**
     * 查询总条数
     *
     * @param sql
     * @return
     */
    public int getTotalNumber(String sql);

    /**
     * 获取插入的id值
     *
     * @return
     */
    public int getId();

    public List<Commodity> getcom(String sql, Object... param);
}
