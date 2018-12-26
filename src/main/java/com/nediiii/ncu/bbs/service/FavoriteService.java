package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.FavoriteEntity;

import java.util.Iterator;
import java.util.List;

public interface FavoriteService {

    //    增
    public List<FavoriteEntity> insertFavorites(List<FavoriteEntity> favoriteList);

    //    删
    public boolean deleteFavorites(List<Integer> ids);

    public boolean deleteFavorites();

    //    改
    public List<FavoriteEntity> updateFavorites(List<FavoriteEntity> favoriteList);

    //    查
    public FavoriteEntity selectFavorite(int id);

    public List<FavoriteEntity> selectFavorites();

    public Iterator<FavoriteEntity> selectFavorites(int pageNum, int pageSize);

}
