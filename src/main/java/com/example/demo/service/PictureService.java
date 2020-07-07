package com.example.demo.service;

import com.example.demo.entity.Picture;

import java.util.List;

public interface PictureService {
    /**
     * 添加图片
     *
     * @param prPicture
     * @return
     */
    public int addComImg(Picture picture);

    /**
     * 根据商品编号查询图片
     *
     * @param comId
     * @return
     */
    public List<Picture> getPicture(int comId);
}
