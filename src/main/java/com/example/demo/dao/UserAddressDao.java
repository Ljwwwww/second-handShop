package com.example.demo.dao;

import com.example.demo.entity.UserAddress;
import com.example.demo.entity.UserAddress;

import java.util.List;

public interface UserAddressDao {
    /**
     * 查询地址信息
     *
     * @param sql
     * @param objects
     * @return
     */
    public List<UserAddress> getAddress(String sql, Object... objects);

    /**
     * 更新地址信息
     *
     * @param sql
     * @param objects
     * @return
     */
    public int upAddress(String sql, Object... objects);


}
