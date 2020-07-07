package com.example.demo.entity;

/**
 * 用户等级( 等级:{超级管理员/卖家/普通会员})实体类
 *
 * @author clown
 */
public class UserGrade {
    /**
     * 等级编号
     */
    private int gradeId;
    /**
     * 等级名称(超级管理员/卖家/普通会员)
     */
    private String gradeName;
    /**
     * 权限说明
     */
    private String explain;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public UserGrade() {
        super();
    }


    public UserGrade(String gradeName, String explain) {
        super();
        this.gradeName = gradeName;
        this.explain = explain;
    }

    public UserGrade(int gradeId, String gradeName, String explain) {
        super();
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.explain = explain;
    }


}
