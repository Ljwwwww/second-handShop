package com.example.demo.service;

import com.example.demo.entity.Commodity;

import java.util.List;

public interface CommodityService {
    /**
     * 查询所有商品
     *
     * @return
     */
    public List<Commodity> getComAll(int page, int limit);

    /**
     * 模糊查询商品信息
     *
     * @param name
     * @param paga
     * @param limit
     * @return
     */
    public List<Commodity> getComAllMo(String name);

    /**
     * 根据信息查询
     *
     * @param commodity
     * @return
     */
    public List<Commodity> getCom(int page, int limit, Commodity commodity);

    /**
     * 查询数据总条数
     *
     * @return
     */
    public int getTotalNumber();

    /**
     * 根据商品状态查询总条数
     *
     * @param page
     * @param limit
     * @param state
     * @return
     */
    public int getTotalNumber(Commodity commodity);

    /**
     * 添加商品
     *
     * @param commodity
     * @return
     */
    public int addCommodity(Commodity commodity);

    /**
     * 获取主键id
     *
     * @return
     */
    public int getId();

    /**
     * 修改商品状态
     *
     * @param comId
     * @param statusId
     * @return
     */
    public int upComStatus(int comId, int statusId);

    /**
     * 根据id查询商品信息
     *
     * @param comId
     * @return
     */
    public Commodity getCommodity(int comId);

    /**
     * @param comId
     * @return
     */
    public List<Commodity> getCom(int comId);

    /**
     * 根据用户编号查询商品信息
     *
     * @param userId
     * @return
     */
    public List<Commodity> getComId(int userId, int page, int limit);

    /**
     * 根据商品编号删除商品
     *
     * @param comId
     * @return
     */
    public int delCom(String[] list);

    /**
     * 根据参数查询商品信息(用于搜索)
     *
     * @param date1
     * @param date2
     * @param status
     * @param name
     * @param page
     * @param limit
     * @return
     */
    public List<Commodity> getCommodityAndStatus(String date1, String date2, String status, String name, String contrllerGet, int page, int limit);

    /**
     * 根据参数查询总条数
     *
     * @param date1
     * @param date2
     * @param status
     * @param name
     * @param contrllerGet
     * @return
     */
    public int getComCount(String date1, String date2, String status, String name, String contrllerGet);

    /**
     * 根据商品编号返回商家id
     *
     * @param comId
     * @return
     */
    public int getEllerIdByComId(int comId);
}
