package com.example.demo.dao;

import com.example.demo.entity.UserGrade;
import com.example.demo.entity.UserGrade;

import java.util.List;

public interface UserGradeDao {


    /**
     * 根据参数查询等级
     *
     * @param sql
     * @param param
     * @return
     */
    public List<UserGrade> getUserGradeAll(String sql);

    /**
     * 根据参数查询等级
     *
     * @param sql
     * @param param
     * @return
     */
    public List<UserGrade> getUserGradeAll(String sql, Object... param);

    /**
     * 更新等级信息
     *
     * @param sql
     * @param param
     * @return
     */
    public int upUserGarde(String sql, Object... param);

    /**
     * 查询单个等级信息
     *
     * @param sql
     * @param param
     * @return
     */
    public UserGrade getUserGrade(String sql, Object... param);
}
