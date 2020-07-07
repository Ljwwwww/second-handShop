package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.UserAddressDao;
import com.example.demo.entity.UserAddress;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAddressDaoImpl extends BaseDao implements UserAddressDao {

    @Override
    public List<UserAddress> getAddress(String sql, Object... params) {
        UserAddress userAddress = null;
        List<UserAddress> list = new ArrayList<UserAddress>();

        try {
            this.rs = executeQuery(sql, params);
            while (rs.next()) {
                userAddress = new UserAddress();
                userAddress.setAddressId(rs.getInt("addressId"));
                userAddress.setAddressPlace(rs.getString("addressPlace"));
                userAddress.setConsignee(rs.getString("consignee"));
                userAddress.setDetailedAddress(rs.getString("detailedAddress"));
                userAddress.setPhone(rs.getString("phone"));
                userAddress.setUserId(rs.getInt("userId"));
                list.add(userAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public int upAddress(String sql, Object... objects) {
        Integer result = null;
        try {
            result = this.executeUpdate(sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return result;
    }

}
