package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.MessageDao;
import com.example.demo.entity.Message;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl extends BaseDao implements MessageDao {

    @Override
    public List<Message> getMessage(String sql, Object... param) {
        List<Message> list = new ArrayList<Message>();
        Message message = null;
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                message = new Message();
                message.setMessageId(rs.getInt("messageId"));
                message.setMessageName(rs.getString("messageName"));
                message.setUserId(rs.getInt("userId"));
                message.setContent(rs.getString("content"));
                message.setMessageStatus(rs.getString("messageStatus"));
                message.setMessageTime(rs.getString("messageTime"));
                message.setAddresser(rs.getInt("addresser"));
                list.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public int upMessage(String sql, Object... param) {
        Integer result = null;
        try {
            result = this.executeUpdate(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return result;
    }

    @Override
    public int getTotalNumber(String sql, Object... object) {
        int count = 0;
        this.rs = executeQuery(sql, object);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

}
