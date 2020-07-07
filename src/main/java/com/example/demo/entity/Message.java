package com.example.demo.entity;

/**
 * 消息实体类
 *
 * @author 平民
 */
public class Message {
    /**
     * 消息编号
     */
    private int messageId;
    /**
     * 用户编号
     */
    private int userId;
    /**
     * 消息名称
     */
    private String messageName;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息状态
     */
    private String messageStatus;
    /**
     * 发布时间
     */
    private String messageTime;

    private int addresser;

    public int getAddresser() {
        return addresser;
    }

    public void setAddresser(int addresser) {
        this.addresser = addresser;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public Message() {
        super();
    }


    public Message(int userId, String messageName, String content, String messageTime, int addresser) {
        super();
        this.userId = userId;
        this.messageName = messageName;
        this.content = content;
        this.messageTime = messageTime;
        this.addresser = addresser;
    }


}
