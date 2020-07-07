package com.example.demo.entity;

/**
 * 用户状态实体类
 *
 * @author clown
 */
public class UserStatus {
    /**
     * 状态编号
     */
    private int statusId;
    /**
     * 状态名称
     */
    private String statusName;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public UserStatus() {
        super();
    }

    public UserStatus(int statusId, String statusName) {
        super();
        this.statusId = statusId;
        this.statusName = statusName;
    }


}
