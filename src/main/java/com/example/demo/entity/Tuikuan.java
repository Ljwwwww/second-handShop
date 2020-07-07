package com.example.demo.entity;

public class Tuikuan {
    private int weiqId;
    private String ordeId;
    private int userId;
    private int comuserId;
    private String cause;
    private String content;
    private String state;
    private String time;
    private String userName;
    private String comUserName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComUserName() {
        return comUserName;
    }

    public void setComUserName(String comUserName) {
        this.comUserName = comUserName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWeiqId() {
        return weiqId;
    }

    public void setWeiqId(int weiqId) {
        this.weiqId = weiqId;
    }

    public String getOrdeId() {
        return ordeId;
    }

    public void setOrdeId(String ordeId) {
        this.ordeId = ordeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getComuserId() {
        return comuserId;
    }

    public void setComuserId(int comuserId) {
        this.comuserId = comuserId;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Tuikuan() {
        super();
    }

    public Tuikuan(String ordeId, int userId, int comuserId, String cause, String content, String state, String time) {
        super();
        this.ordeId = ordeId;
        this.userId = userId;
        this.comuserId = comuserId;
        this.cause = cause;
        this.content = content;
        this.state = state;
        this.time = time;
    }


}
