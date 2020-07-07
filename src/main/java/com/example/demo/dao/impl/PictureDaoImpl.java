package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.PictureDao;
import com.example.demo.entity.Picture;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PictureDaoImpl extends BaseDao implements PictureDao {

    @Override
    public int upComImg(String sql, Object... param) {
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
    public List<Picture> getComImg(String sql, Object... param) {
        List<Picture> list = new ArrayList<Picture>();
        Picture picture = null;
        try {
            this.rs = executeQuery(sql, param);
            while (rs.next()) {
                picture = new Picture();
                picture.setImgId(rs.getInt("imgId"));
                picture.setImgAdd("\\secondhand_shop\\upload\\" + rs.getString("imgAdd"));
                picture.setComId(rs.getInt("comId"));
                list.add(picture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
