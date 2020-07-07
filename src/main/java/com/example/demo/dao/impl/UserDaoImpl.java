package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    //根据信息查询用户
    @Override
    public List<User> getUser(String sql, Object... param) {
        User user = null;
        List<User> list = new ArrayList<User>();
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPwd(rs.getString("userPwd"));
                user.setSex(rs.getString("sex"));
                user.setUserPhone(rs.getString("userPhone"));
                user.setShippingAddress(rs.getInt("shippingAddress"));
                user.setStatusName(rs.getString("statusName"));
                user.setGradeName(rs.getString("gradeName"));
                user.setRegistrationTime(rs.getString("registrationTime"));
                user.setUserMoney(rs.getDouble("userMoney"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

    //更新用户信息
    @Override
    public int upUser(String sql, Object... param) {
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

    //查询单个用户
    @Override
    public User getUserRun(String sql, Object... param) {
        User user = null;
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPwd(rs.getString("userPwd"));
                user.setSex(rs.getString("sex"));
                user.setTradePwd(rs.getString("tradePwd"));
                user.setUserPhone(rs.getString("userPhone"));
                user.setShippingAddress(rs.getInt("shippingAddress"));
                user.setUserStatus(rs.getInt("userStatus"));
                user.setUserGrade(rs.getInt("userGrade"));
                user.setUserMoney(rs.getDouble("userMoney"));
                user.setRegistrationTime(rs.getString("registrationTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return user;
    }

    //查询所有信息
    @Override
    public List<User> getUser(String sql) {
        User user = null;
        List<User> list = new ArrayList<User>();
        try {
            this.rs = executeQuery(sql);
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPwd(rs.getString("userPwd"));
                user.setSex(rs.getString("sex"));
                user.setUserPhone(rs.getString("userPhone"));
                user.setShippingAddress(rs.getInt("shippingAddress"));
                user.setStatusName(rs.getString("statusName"));
                user.setGradeName(rs.getString("gradeName"));
                user.setUserMoney(rs.getDouble("userMoney"));
                user.setRegistrationTime(rs.getString("registrationTime"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

    @Override
    public int getTotalNumber(String sql, Object... objects) {
        int count = 0;
        this.rs = executeQuery(sql, objects);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    @Override
    public int getTotalNumber(String sql) {
        int count = 0;
        this.rs = executeQuery(sql);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

}
 