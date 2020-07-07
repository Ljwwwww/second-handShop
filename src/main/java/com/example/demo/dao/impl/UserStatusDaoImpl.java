package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.UserStatusDao;
import com.example.demo.entity.UserStatus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserStatusDaoImpl extends BaseDao implements UserStatusDao {

    //查询所有状态
    @Override
    public List<UserStatus> getStatusAll() {
        String sql = "SELECT * FROM user_status";
        List<UserStatus> list = new ArrayList<UserStatus>();
        UserStatus user_status = null;
        this.rs = executeQuery(sql);
        try {
            while (rs.next()) {
                user_status = new UserStatus();
                user_status.setStatusId(rs.getInt("statusId"));
                user_status.setStatusName(rs.getString("statusName"));
                list.add(user_status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

    //根据信息查询状态
    @Override
    public UserStatus getStatus(UserStatus user_status) {
        String sql = "SELECT * FROM user_status where statusName=?";
        Object param[] = {user_status.getStatusName()};
        this.rs = executeQuery(sql, param);
        try {
            while (rs.next()) {
                user_status = new UserStatus();
                user_status.setStatusId(rs.getInt("statusId"));
                user_status.setStatusName(rs.getString("statusName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return user_status;
    }

}
