package com.example.demo.entity;

/**
 * 图片信息实体类
 *
 * @author 平民
 */
public class Picture {
    /**
     * 图片编号
     */
    private int imgId;
    /**
     * 图片地址
     */
    private String imgAdd;
    /**
     * 商品编号
     */
    private int comId;


    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgAdd() {
        return imgAdd;
    }

    public void setImgAdd(String imgAdd) {
        this.imgAdd = imgAdd;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public Picture() {
        super();
    }

    public Picture(String imgAdd, int comId) {
        super();
        this.imgAdd = imgAdd;
        this.comId = comId;
    }

    public Picture(int imgId, String aimgAdd, int comId) {
        super();
        this.imgId = imgId;
        this.imgAdd = aimgAdd;
        this.comId = comId;
    }


}
