package com.example.demo.entity;

/**
 * 商品状态实体类
 *
 * @author 平民
 */
public class CommodityState {
    /**
     * 状态编号
     */
    private int comStid;
    /**
     * 状态名称
     */
    private String comStname;

    public int getComStid() {
        return comStid;
    }

    public void setComStid(int comStid) {
        this.comStid = comStid;
    }

    public String getComStname() {
        return comStname;
    }

    public void setComStname(String comStname) {
        this.comStname = comStname;
    }

    public CommodityState() {
        super();
    }

    public CommodityState(int comStid, String comStname) {
        super();
        this.comStid = comStid;
        this.comStname = comStname;
    }


}
