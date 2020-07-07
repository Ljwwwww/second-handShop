package com.example.demo.service.impl;

import com.example.demo.dao.UserGradeDao;
import com.example.demo.dao.impl.UserGradeDaoImpl;
import com.example.demo.entity.UserGrade;
import com.example.demo.service.UserGradeService;

import java.util.ArrayList;
import java.util.List;

public class UserGradeServiceImpl implements UserGradeService {
    //查询所有等级信息
    @Override
    public List<UserGrade> getUserAll() {
        String sql = "SELECT * FROM user_grade";
        UserGradeDao userGradeDao = new UserGradeDaoImpl();
        List<UserGrade> list = new ArrayList<UserGrade>();
        list = userGradeDao.getUserGradeAll(sql);
        return list;
    }

    //根据等级名称查询
    @Override
    public UserGrade getUserGrade(UserGrade userGrade) {
        String sql = "SELECT * FROM user_grade where userName=?";
        UserGradeDao userGradeDao = new UserGradeDaoImpl();
        Object param[] = {userGrade.getGradeName()};
        userGrade = userGradeDao.getUserGrade(sql, param);
        return userGrade;
    }

    //添加等级信息
    @Override
    public int addUserGrade(UserGrade userGrade) {
        String sql = "INSERT INTO user_grade (gradeName,`explain`) VALUES(?,?)";
        Object[] param = {userGrade.getGradeName(), userGrade.getExplain()};
        UserGradeDao userGradeDao = new UserGradeDaoImpl();
        return userGradeDao.upUserGarde(sql, param);
    }

    //删除等级信息
    @Override
    public int delUserGrade(String[] list) {
        String sql = "DELETE FROM user_grade WHERE gradeId in(?)";
        UserGradeDao userGradeDao = new UserGradeDaoImpl();
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            Object param[] = {Integer.parseInt(list[i])};
            count = userGradeDao.upUserGarde(sql, param);
        }
        return count;
    }

}
