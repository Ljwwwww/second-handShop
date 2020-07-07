package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.CollectDao;
import com.example.demo.entity.Collect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectDaoImpl extends BaseDao implements CollectDao {

    @Override
    public int upCollect(String sql, Object... param) {
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
    public List<Collect> getCollectAll(String sql, Object... param) {
        List<Collect> list = new ArrayList<Collect>();
        Collect collect = null;
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                collect = new Collect();
                collect.setCollectId(rs.getInt("collectId"));
                collect.setComId(rs.getInt("comId"));
                collect.setComName(rs.getString("comName"));
                collect.setUserId(rs.getInt("userId"));
                collect.setComPrice(rs.getDouble("comPrice"));
                collect.setComImg(rs.getString("comImg"));
                list.add(collect);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Collect getCollect(String sql, Object... param) {
        Collect collect = null;
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                collect = new Collect();
                collect.setCollectId(rs.getInt("collectId"));
                collect.setComId(rs.getInt("comId"));
                collect.setComName(rs.getString("comName"));
                collect.setUserId(rs.getInt("userId"));
                collect.setComPrice(rs.getDouble("comPrice"));
                collect.setComImg(rs.getString("comImg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collect;
    }

}
