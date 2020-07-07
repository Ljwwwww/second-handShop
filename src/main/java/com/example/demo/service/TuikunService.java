package com.example.demo.service;

import com.example.demo.entity.Tuikuan;

import java.util.List;

public interface TuikunService {
    /**
     * 添加维权信息
     *
     * @param tuikuan
     * @return
     */
    public int addTuikun(Tuikuan tuikuan);

    /**
     * 根据用户名和订单号查询
     *
     * @param userId
     * @param ordeId
     * @return
     */
    public List<Tuikuan> getTuikuan(String ordeId);

}
