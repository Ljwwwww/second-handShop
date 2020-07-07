package com.example.demo.dao;

import com.example.demo.entity.Collect;
import com.example.demo.entity.Collect;

import java.util.List;

/**
 * 商品收藏表
 *
 * @author 平民
 */
public interface CollectDao {
    /**
     * 更新商品收藏
     *
     * @param sql
     * @param param
     * @return
     */
    public int upCollect(String sql, Object... param);

    /**
     * 根据参数查询
     *
     * @param sql
     * @param param
     * @return
     */
    public List<Collect> getCollectAll(String sql, Object... param);

    /**
     * 根据参数查询单个
     *
     * @param sql
     * @param param
     * @return
     */
    public Collect getCollect(String sql, Object... param);
}
