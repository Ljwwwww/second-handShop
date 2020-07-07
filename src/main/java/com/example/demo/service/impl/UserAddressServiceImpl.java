package com.example.demo.service.impl;

import com.example.demo.dao.UserAddressDao;
import com.example.demo.dao.impl.UserAddressDaoImpl;
import com.example.demo.entity.UserAddress;
import com.example.demo.service.UserAddressService;

import java.util.ArrayList;
import java.util.List;

public class UserAddressServiceImpl implements UserAddressService {
    /**
     * 添加地址
     */
    @Override
    public int addUserAddress(UserAddress userAddress) {
        int num = 0;
        String sql = "INSERT INTO user_address (addressPlace,userId,phone,detailedAddress,isDefault,consignee)VALUES(?,?,?,?,?,?)";
        UserAddressDao userAddressDao = new UserAddressDaoImpl();
        Object[] param = {userAddress.getAddressPlace(), userAddress.getUserId(), userAddress.getPhone(), userAddress.getDetailedAddress(), userAddress.getIsDefault(), userAddress.getConsignee()};
        num = userAddressDao.upAddress(sql, param);
        return num;
    }

    //根据用户编号查询地址
    @Override
    public List<UserAddress> getAddAll(int userId) {
        String sql = "SELECT * FROM user_address WHERE userId=?";
        Object param[] = {userId};
        UserAddressDao userAddressDao = new UserAddressDaoImpl();
        List<UserAddress> list = new ArrayList<UserAddress>();
        list = userAddressDao.getAddress(sql, param);
        return list;
    }

    //根据地址编号删除地址
    @Override
    public int delAdd(int addressId) {
        String sql = "DELETE FROM user_address WHERE addressId =?";
        UserAddressDao userAddressDao = new UserAddressDaoImpl();
        Object param[] = {addressId};
        return userAddressDao.upAddress(sql, param);
    }

}
