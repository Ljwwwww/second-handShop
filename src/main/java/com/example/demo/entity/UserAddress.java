package com.example.demo.entity;

/**
 * 用户地址实体类
 *
 * @author 平民
 */
public class UserAddress {
    /**
     * 地址编号
     */
    private int addressId;
    /**
     * 所在地区
     */
    private String addressPlace;
    /**
     * 用户编号
     */
    private int userId;
    /**
     * 收货人手机号
     */
    private String phone;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 收货人姓名
     */
    private String consignee;
    /**
     * 是否为默认地址
     */
    private String isDefault;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressPlace() {
        return addressPlace;
    }

    public void setAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }


    public UserAddress() {
        super();
    }

    public UserAddress(String addressPlace, int userId, String phone, String detailedAddress, String consignee,
                       String isDefault) {
        super();
        this.addressPlace = addressPlace;
        this.userId = userId;
        this.phone = phone;
        this.detailedAddress = detailedAddress;
        this.consignee = consignee;
        this.isDefault = isDefault;
    }

    public UserAddress(int addressId, String addressPlace, int userId, String phone, String detailedAddress,
                       String consignee, String isDefault) {
        super();
        this.addressId = addressId;
        this.addressPlace = addressPlace;
        this.userId = userId;
        this.phone = phone;
        this.detailedAddress = detailedAddress;
        this.consignee = consignee;
        this.isDefault = isDefault;
    }


}
