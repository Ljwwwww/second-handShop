package com.example.demo.entity;

/**
 * 用户表
 *
 * @author clown
 */
public class User {

    private int userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话
     */
    private String userPhone;
    /**
     * 收货地址
     */
    private int shippingAddress;
    /**
     * 用户状态(正常/封禁)
     */
    private int userStatus;
    /**
     * 用户等级(超级管理员/卖家/普通会员)
     */
    private int userGrade;
    /**
     * 用户注册时间
     */
    private String registrationTime;

    /**
     * 余额
     */
    private double userMoney;

    /**
     * 等级名称
     */

    private String gradeName;
    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 支付密码
     */
    private String tradePwd;


    public double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(double userMoney) {
        this.userMoney = userMoney;
    }

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(int shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public User() {
        super();
    }

    //修改密码
    public User(int userId, String userPwd, String tradePwd) {
        super();
        this.userId = userId;
        this.userPwd = userPwd;
        this.tradePwd = tradePwd;
    }

    //用户注册用
    public User(String userName, String userPwd, String sex, String userPhone, String registrationTime,
                String tradePwd) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.userPhone = userPhone;
        this.registrationTime = registrationTime;
        this.tradePwd = tradePwd;
    }

    //用户修改信息
    public User(int userId, String userName, String userPwd, String sex, String userPhone, String tradePwd) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.userPhone = userPhone;
        this.tradePwd = tradePwd;
    }

    public User(int userId, String userName, String userPwd, String sex, String userPhone, int userStatus,
                int userGrade, String tradePwd, double money) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.userPhone = userPhone;
        this.userStatus = userStatus;
        this.userGrade = userGrade;
        this.tradePwd = tradePwd;
        this.userMoney = money;
    }

    public User(String userName, String userPwd, String sex, String userPhone, int userGrade, String registrationTime,
                String tradePwd) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.userPhone = userPhone;
        this.userGrade = userGrade;
        this.registrationTime = registrationTime;
        this.tradePwd = tradePwd;
    }

    public User(int userId, String userName, String userPwd, String sex, String userPhone, int shippingAddress,
                int userStatus, int userGrade, String registrationTime, double userMoney, String gradeName,
                String statusName, String tradePwd) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.userPhone = userPhone;
        this.shippingAddress = shippingAddress;
        this.userStatus = userStatus;
        this.userGrade = userGrade;
        this.registrationTime = registrationTime;
        this.userMoney = userMoney;
        this.gradeName = gradeName;
        this.statusName = statusName;
        this.tradePwd = tradePwd;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", sex=" + sex
                + ", userPhone=" + userPhone + ", shippingAddress=" + shippingAddress + ", userStatus=" + userStatus
                + ", userGrade=" + userGrade + ", registrationTime=" + registrationTime + ", gradeName=" + gradeName
                + ", statusName=" + statusName + ", tradePwd=" + tradePwd + "]";
    }

}
