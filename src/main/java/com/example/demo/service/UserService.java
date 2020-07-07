package com.example.demo.service;

import com.example.demo.entity.Search;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public int login(User user);

    /**
     * 查询所有用户信息
     *
     * @return List<User>
     */
    public List<User> getUserAll(int page, int limit);

    /**
     * 根据参数查询用户
     *
     * @param user
     * @param page
     * @param limit
     * @return
     */
    public List<User> getUserRun(User user, int page, int limit);

    /**
     * 根据信息查询单个用户
     *
     * @param user
     * @return
     */
    public User getUser(User user);

    /**
     * 根据参数查询用户信息
     *
     * @param name
     * @param start
     * @param end
     * @param page
     * @param limit
     * @return
     */
    public List<User> getUser(Search search, String type, int page, int limit);

    /**
     * 根据参数查询总条数
     *
     * @param name
     * @param start
     * @param end
     * @return
     */
    public int getTotalNumber(Search search, String type);

    /**
     * 用户注册
     *
     * @return
     */
    public int addUser(User user);

    /**
     * 修改用户状态信息
     *
     * @param user
     * @return
     */
    public int updata(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public int upUser(User user);

    /**
     * 用户修改信息
     *
     * @return
     */
    public int upuser(User user);

    /**
     * 批量删除用户
     *
     * @param list
     * @return
     */
    public int delUser(String[] li);

    /**
     * 验证支付密码是否正确
     *
     * @param userId
     * @param pwd
     * @return
     */
    public int isCorrect(int userId, String pwd);

    /**
     * 更新用户金额
     *
     * @param money
     * @param userId
     * @return
     */
    public int upMoney(double money, int userId);

    /**
     * 用户入驻商家
     *
     * @param userId
     * @return
     */
    public int upEnter(int userId);
}
