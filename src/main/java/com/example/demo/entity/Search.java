package com.example.demo.entity;

/**
 * 搜索参数实体类
 *
 * @author 平民
 */

public class Search {

    private String name;

    private String start;

    private String end;

    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Search() {
        super();
    }

    public Search(String name, String start, String end, User user) {
        super();
        this.name = name;
        this.start = start;
        this.end = end;
        this.user = user;
    }


}
