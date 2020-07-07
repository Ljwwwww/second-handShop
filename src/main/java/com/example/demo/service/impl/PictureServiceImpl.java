package com.example.demo.service.impl;

import com.example.demo.dao.PictureDao;
import com.example.demo.dao.impl.PictureDaoImpl;
import com.example.demo.entity.Picture;
import com.example.demo.service.PictureService;

import java.util.ArrayList;
import java.util.List;

public class PictureServiceImpl implements PictureService {
    /**
     * 添加图片
     */
    @Override
    public int addComImg(Picture picture) {
        String sql = "INSERT INTO picture (imgAdd,comId)VALUES(?,?)";
        PictureDao pictureDao = new PictureDaoImpl();
        int count = 0;
        Object param[] = {picture.getImgAdd(), picture.getComId()};
        count = pictureDao.upComImg(sql, param);
        return count;
    }

    /**
     * 根据商品编号查询图片
     */
    @Override
    public List<Picture> getPicture(int comId) {
        List<Picture> list = new ArrayList<Picture>();
        PictureDao pictureDao = new PictureDaoImpl();
        Object param[] = {comId};
        String sql = "SELECT * FROM picture WHERE comId=?";
        list = pictureDao.getComImg(sql, param);
        return list;
    }

}
