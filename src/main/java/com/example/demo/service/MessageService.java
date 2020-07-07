package com.example.demo.service;

import com.example.demo.entity.Message;

import java.util.List;

public interface MessageService {
    /**
     * 添加消息
     *
     * @param message
     * @return int
     */
    public int addMessage(Message message);

    /**
     * 根据用户编号查询消息
     *
     * @param userId
     * @return
     */
    public List<Message> getMessageAll(int userId);

    /**
     * 根据消息编号和状态修改消息
     *
     * @param messageId
     * @return int
     */
    public int upMessage(int messageId, String messageStatus);

    /**
     * 根据编号删除
     *
     * @param messageId
     * @return int
     */
    public int delMessage(int messageId);

    /**
     * 根据用户编号查询总条数
     *
     * @param userId
     * @return
     */
    public int couMessage(int userId);


}
