package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.ThumbsUpEntity;

import java.util.Iterator;
import java.util.List;

public interface ThumbsUpService {

    //    增
    public List<ThumbsUpEntity> insertThumbsUps(List<ThumbsUpEntity> thumbsUpList);

    //    删
    public boolean deleteThumbsUps(List<Integer> ids);

    public boolean deleteThumbsUps();

    //    改
    public List<ThumbsUpEntity> updateThumbsUps(List<ThumbsUpEntity> thumbsUpList);

    //    查
    public ThumbsUpEntity selectThumbsUp(int id);

    public List<ThumbsUpEntity> selectThumbsUps();

    public Iterator<ThumbsUpEntity> selectThumbsUps(int pageNum, int pageSize);

}
