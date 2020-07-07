package com.example.demo.service;

import com.example.demo.entity.UserGrade;

import java.util.List;

public interface UserGradeService {
    /**
     * 查询所有等级信息
     *
     * @return
     */
    public List<UserGrade> getUserAll();

    /**
     * 根据参数查询等信息
     *
     * @param userGrade
     * @return
     */
    public UserGrade getUserGrade(UserGrade userGrade);

    /**
     * 添加等级信息
     *
     * @param userGrade
     * @return
     */
    public int addUserGrade(UserGrade userGrade);

    /**
     * 根据编号删除等级信息
     *
     * @param userGardeId
     * @return
     */
    public int delUserGrade(String[] userGardeId);
}
