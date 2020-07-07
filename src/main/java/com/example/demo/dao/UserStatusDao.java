package com.example.demo.dao;

import com.example.demo.entity.UserStatus;
import com.example.demo.entity.UserStatus;

import java.util.List;

public interface UserStatusDao {
    /**
     * 查询所有状态
     *
     * @return
     */
    public List<UserStatus> getStatusAll();

    /**
     * 根据信息查询状态
     */
    public UserStatus getStatus(UserStatus user_status);
}	
