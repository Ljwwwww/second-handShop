package com.example.demo.service;

import com.example.demo.entity.Collect;

import java.util.List;

public interface CollectService {
    /**
     * 添加收藏
     *
     * @param collect
     * @return int
     */
    public int addColl(Collect collect);

    /**
     * 根据用户编号查询收藏
     *
     * @param userId
     * @return List<Collect>
     */
    public List<Collect> getCollAll(int userId);

    /**
     * 根据商品编号查询收藏商品信息
     *
     * @param comId
     * @return Collect
     */
    public Collect getColl(int comId, int userId);

    /**
     * 删除收藏表信息
     *
     * @param comId
     * @return
     */
    public int delColl(int comId);
}
