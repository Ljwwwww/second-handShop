package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.TuikuanDao;
import com.example.demo.entity.Tuikuan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TuikunDaoImpl extends BaseDao implements TuikuanDao {

    @Override
    public int upTuikuan(String sql, Object... param) {
        Integer result = null;
        try {
            result = this.executeUpdate(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return result;
    }

    @Override
    public List<Tuikuan> geTuikuan(String sql, Object... param) {
        List<Tuikuan> list = new ArrayList<Tuikuan>();
        Tuikuan tuikuan = null;

        try {
            this.rs = this.executeQuery(sql, param);
            while (rs.next()) {
                tuikuan = new Tuikuan();
                tuikuan.setWeiqId(rs.getInt("weiqId"));
                tuikuan.setOrdeId(rs.getString("ordeId"));
                tuikuan.setUserId(rs.getInt("userId"));
                tuikuan.setComuserId(rs.getInt("comuserId"));
                tuikuan.setCause(rs.getString("cause"));
                tuikuan.setContent(rs.getString("content"));
                tuikuan.setState(rs.getString("state"));
                tuikuan.setTime(rs.getString("time"));
                tuikuan.setUserName(rs.getString("userName"));
                tuikuan.setComUserName(rs.getString("comUserName"));
                list.add(tuikuan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
