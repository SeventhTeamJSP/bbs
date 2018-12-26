package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.FollowEntity;

import java.util.Iterator;
import java.util.List;

public interface FollowService {

    //    增
    public List<FollowEntity> insertFollows(List<FollowEntity> followList);

    //    删
    public boolean deleteFollows(List<Integer> ids);

    public boolean deleteFollows();

    //    改
    public List<FollowEntity> updateFollows(List<FollowEntity> followList);

    //    查
    public FollowEntity selectFollow(int id);

    public List<FollowEntity> selectFollows();

    public Iterator<FollowEntity> selectFollows(int pageNum, int pageSize);

}
