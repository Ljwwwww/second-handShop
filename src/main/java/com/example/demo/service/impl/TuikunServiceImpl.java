package com.example.demo.service.impl;

import com.example.demo.dao.TuikuanDao;
import com.example.demo.dao.impl.TuikunDaoImpl;
import com.example.demo.entity.Tuikuan;
import com.example.demo.service.TuikunService;

import java.util.List;

public class TuikunServiceImpl implements TuikunService {

    @Override
    public int addTuikun(Tuikuan tuikuan) {
        TuikuanDao tuikuanDao = new TuikunDaoImpl();
        String sql = "INSERT INTO `tuikuan`(`ordeId`,`userId`,`comuserId`,`cause`,`content`,`state`,`time`) VALUES(?,?,?,?,?,?,?)";
        Object[] param = {tuikuan.getOrdeId(), tuikuan.getUserId(), tuikuan.getComuserId(), tuikuan.getCause(), tuikuan.getContent(), tuikuan.getState(), tuikuan.getTime()};
        return tuikuanDao.upTuikuan(sql, param);
    }

    @Override
    public List<Tuikuan> getTuikuan(String ordeId) {
        TuikuanDao tuikuanDao = new TuikunDaoImpl();
        String sql = "SELECT `weiqId`,`ordeId`,`tuikuan`.`userId`,`comuserId`,`cause`,`content`,`state`,`time`,u.userName AS userName,uu.userName AS comUserName FROM tuikuan LEFT JOIN `user` u ON  tuikuan.`userId`=u.userId LEFT JOIN `user` uu ON tuikuan.`comuserId`=uu.userId WHERE  `ordeId`=?";
        Object[] param = {ordeId};
        return tuikuanDao.geTuikuan(sql, param);
    }

}
