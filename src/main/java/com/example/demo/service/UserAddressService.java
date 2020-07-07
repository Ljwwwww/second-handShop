package com.example.demo.service;

import com.example.demo.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
    /**
     * 添加地址
     *
     * @param userAddressService
     * @return
     */
    public int addUserAddress(UserAddress userAddress);

    /**
     * 根据用户编号查询地址
     *
     * @param userId
     * @return
     */
    public List<UserAddress> getAddAll(int userId);

    /**
     * 根据地址编号删除地址信息
     *
     * @param addressId
     * @return int
     */
    public int delAdd(int addressId);
}
