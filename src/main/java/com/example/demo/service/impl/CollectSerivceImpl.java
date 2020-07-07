package com.example.demo.service.impl;

import com.example.demo.dao.CollectDao;
import com.example.demo.dao.impl.CollectDaoImpl;
import com.example.demo.entity.Collect;
import com.example.demo.service.CollectService;

import java.util.List;

public class CollectSerivceImpl implements CollectService {
    //添加收藏
    @Override
    public int addColl(Collect collect) {
        String sql = "INSERT INTO collect (comId,comName,userId,comPrice,comImg)VALUES(?,?,?,?,?)";
        CollectDao collectDao = new CollectDaoImpl();
        Object[] param = {collect.getComId(), collect.getComName(), collect.getUserId(), collect.getComPrice(), collect.getComImg()};
        return collectDao.upCollect(sql, param);
    }

    //根据用户编号查询收藏
    @Override
    public List<Collect> getCollAll(int userId) {
        String sql = "SELECT * FROM collect WHERE userId=?";
        CollectDao collectDao = new CollectDaoImpl();
        Object[] param = {userId};
        return collectDao.getCollectAll(sql, param);
    }

    //根据商品编号查询收藏商品信息
    @Override
    public Collect getColl(int comId, int userId) {
        String sql = "SELECT * FROM collect WHERE comId=? and userId=?";
        CollectDao collectDao = new CollectDaoImpl();
        Object[] param = {comId, userId};
        return collectDao.getCollect(sql, param);
    }

    //根据商品编号删除收藏信息
    @Override
    public int delColl(int comId) {
        String sql = "DELETE FROM `collect` WHERE `collectId` =?";
        Object[] param = {comId};
        CollectDao collectDao = new CollectDaoImpl();
        return collectDao.upCollect(sql, param);
    }

}
