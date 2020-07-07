package com.example.demo.dao;

import com.example.demo.entity.Picture;
import com.example.demo.entity.Picture;

import java.util.List;

public interface PictureDao {
    /**
     * 添加图片
     *
     * @param sql
     * @param param
     * @return
     */
    public int upComImg(String sql, Object... param);

    /**
     * 根据信息查询图片
     *
     * @param sql
     * @param param
     * @return
     */
    public List<Picture> getComImg(String sql, Object... param);


}
