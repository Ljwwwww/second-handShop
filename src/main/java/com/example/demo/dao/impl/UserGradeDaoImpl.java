package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.UserGradeDao;
import com.example.demo.entity.UserGrade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGradeDaoImpl extends BaseDao implements UserGradeDao {


    //根据参数修改等级信息
    @Override
    public int upUserGarde(String sql, Object... param) {
        Integer result = null;
        try {
            result = this.executeUpdate(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //this.closeAll();
        }
        return result;
    }

    //根据参数查询等级信息
    @Override
    public List<UserGrade> getUserGradeAll(String sql, Object... param) {
        List<UserGrade> list = new ArrayList<UserGrade>();
        UserGrade user_grade = null;
        this.rs = executeQuery(sql, param);
        try {
            while (rs.next()) {
                user_grade = new UserGrade();
                user_grade.setGradeId(rs.getInt("gradeId"));
                user_grade.setGradeName(rs.getString("gradeName"));
                user_grade.setExplain(rs.getString("explain"));
                list.add(user_grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

    //根据参数查询单个等级信息
    @Override
    public UserGrade getUserGrade(String sql, Object... param) {
        UserGrade user_grade = null;
        this.rs = executeQuery(sql, param);
        try {
            while (rs.next()) {
                user_grade = new UserGrade();
                user_grade.setGradeId(rs.getInt("gradeId"));
                user_grade.setGradeName(rs.getString("gradeName"));
                user_grade.setExplain(rs.getString("explain"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return user_grade;
    }

    @Override
    public List<UserGrade> getUserGradeAll(String sql) {
        List<UserGrade> list = new ArrayList<UserGrade>();
        UserGrade user_grade = null;
        this.rs = executeQuery(sql);
        try {
            while (rs.next()) {
                user_grade = new UserGrade();
                user_grade.setGradeId(rs.getInt("gradeId"));
                user_grade.setGradeName(rs.getString("gradeName"));
                user_grade.setExplain(rs.getString("explain"));
                list.add(user_grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

}
