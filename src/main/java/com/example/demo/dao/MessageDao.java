package com.example.demo.dao;

import com.example.demo.entity.Message;
import com.example.demo.entity.Message;

import java.util.List;

public interface MessageDao {
    /**
     * 根据参数查询消息
     *
     * @param sql
     * @param param
     * @return
     */
    public List<Message> getMessage(String sql, Object... param);

    /**
     * 更新消息表
     *
     * @param sql
     * @param param
     * @return
     */
    public int upMessage(String sql, Object... param);

    /**
     * 查询总条数
     *
     * @param number
     * @param object
     * @return
     */
    public int getTotalNumber(String sql, Object... object);

}
