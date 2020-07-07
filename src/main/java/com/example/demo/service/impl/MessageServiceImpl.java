package com.example.demo.service.impl;

import com.example.demo.dao.MessageDao;
import com.example.demo.dao.impl.MessageDaoImpl;
import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    @Override
    public int addMessage(Message message) {
        String sql = "INSERT INTO `message` (`userId`,`messageName`,`content`,`messageTime`,`addresser`)VALUES(?,?,?,?,?)";
        Object[] param = {message.getUserId(), message.getMessageName(), message.getContent(), message.getMessageTime(), message.getAddresser()};
        MessageDao messageDao = new MessageDaoImpl();
        return messageDao.upMessage(sql, param);
    }

    @Override
    public List<Message> getMessageAll(int userId) {
        String sql = "SELECT * FROM message WHERE userId=? ORDER BY messageId";
        MessageDao messageDao = new MessageDaoImpl();
        Object[] param = {userId};
        return messageDao.getMessage(sql, param);
    }

    @Override
    public int upMessage(int messageId, String messageStatus) {
        String sql = "UPDATE `message` SET `messageStatus`=? WHERE `messageId` = ?";
        MessageDao messageDao = new MessageDaoImpl();
        Object[] param = {messageStatus, messageId};
        return messageDao.upMessage(sql, param);
    }

    @Override
    public int delMessage(int messageId) {
        String sql = "DELETE FROM `message` where  `messageId`=?";
        MessageDao messageDao = new MessageDaoImpl();
        Object[] param = {messageId};
        return messageDao.upMessage(sql, param);
    }

    @Override
    public int couMessage(int userId) {
        String sql = "SELECT count(1) FROM message WHERE userId=?";
        MessageDao messageDao = new MessageDaoImpl();
        Object[] param = {userId};
        return messageDao.getTotalNumber(sql, param);
    }

}
