package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.ThumbsDownEntity;

import java.util.Iterator;
import java.util.List;

public interface ThumbsDownService {

    //    增
    public List<ThumbsDownEntity> insertThumbsDowns(List<ThumbsDownEntity> thumbsDownList);

    //    删
    public boolean deleteThumbsDowns(List<Integer> ids);

    public boolean deleteThumbsDowns();

    //    改
    public List<ThumbsDownEntity> updateThumbsDowns(List<ThumbsDownEntity> thumbsDownList);

    //    查
    public ThumbsDownEntity selectThumbsDown(int id);

    public List<ThumbsDownEntity> selectThumbsDowns();

    public Iterator<ThumbsDownEntity> selectThumbsDowns(int pageNum, int pageSize);

}
