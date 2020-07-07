package com.example.demo.dao;

import com.example.demo.entity.Tuikuan;
import com.example.demo.entity.Tuikuan;

import java.util.List;

public interface TuikuanDao {
    /**
     * 更新维权信息
     *
     * @param tuikuan
     * @return
     */
    public int upTuikuan(String sql, Object... param);

    /**
     * 查询维权信息
     *
     * @param sql
     * @param param
     * @return
     */
    public List<Tuikuan> geTuikuan(String sql, Object... param);
}
