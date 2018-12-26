package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.CommentEntity;

import java.util.Iterator;
import java.util.List;

public interface CommentService {

    //    增
    public List<CommentEntity> insertComments(List<CommentEntity> commentList);

    //    删
    public boolean deleteComments(List<Integer> ids);

    public boolean deleteComments();

    //    改
    public List<CommentEntity> updateComments(List<CommentEntity> commentList);

    //    查
    public CommentEntity selectComment(int id);

    public List<CommentEntity> selectComments();

    public Iterator<CommentEntity> selectComments(int pageNum, int pageSize);

}
