package com.example.demo.entity;

/**
 * 商品分类实体类
 *
 * @author 平民
 */
public class CommodityClassify {
    /**
     * 分类编号
     */
    private int classifyId;
    /**
     * 分类名称
     */
    private String classifyName;

    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public CommodityClassify() {
        super();
    }

    public CommodityClassify(String classifyName) {
        super();
        this.classifyName = classifyName;
    }

    public CommodityClassify(int classifyId, String classifyName) {
        super();
        this.classifyId = classifyId;
        this.classifyName = classifyName;
    }


}
