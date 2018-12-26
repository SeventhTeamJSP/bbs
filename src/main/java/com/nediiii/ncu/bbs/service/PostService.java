package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.PostEntity;

import java.util.Iterator;
import java.util.List;

public interface PostService {

    //    增
    public List<PostEntity> insertPosts(List<PostEntity> postList);

    //    删
    public boolean deletePosts(List<Integer> ids);

    public boolean deletePosts();

    //    改
    public List<PostEntity> updatePosts(List<PostEntity> postList);

    //    查
    public PostEntity selectPost(int id);

    public List<PostEntity> selectPosts();

    public Iterator<PostEntity> selectPosts(int pageNum, int pageSize);

}
