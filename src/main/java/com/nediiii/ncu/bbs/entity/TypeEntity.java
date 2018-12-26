package com.nediiii.ncu.bbs.entity;


/**
 * 枚举类型
 * 表示记录所指向的目标类型 给评论点赞则type为TypeEntity.COMMENT
 */
public enum TypeEntity {
    USER, // 用户
    POST, // 帖子
    COMMENT // 评论
}
