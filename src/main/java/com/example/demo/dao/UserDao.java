package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有
     *
     * @param sql
     * @return
     */
    public List<User> getUser(String sql);

    /**
     * 根据信息查询用户
     *
     * @param objects
     * @param sql
     * @return List<User>
     */
    public List<User> getUser(String sql, Object... param);

    /**
     * 根据信息查询用户
     *
     * @param sql
     * @param objects
     * @return User
     */
    public User getUserRun(String sql, Object... param);

    /**
     * 更新用户信息
     *
     * @param sql
     * @param objects
     * @return
     */
    public int upUser(String sql, Object... param);

    /**
     * 查询总条数
     *
     * @param number
     * @param object
     * @return
     */
    public int getTotalNumber(String sql, Object... object);

    /**
     * 查询总条数
     *
     * @param sql
     * @return
     */
    public int getTotalNumber(String sql);
}
