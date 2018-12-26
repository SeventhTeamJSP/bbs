package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.FavoriteEntity;
import com.nediiii.ncu.bbs.repository.FavoriteRepository;
import com.nediiii.ncu.bbs.service.FavoriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public List<FavoriteEntity> insertFavorites(List<FavoriteEntity> favoriteList) {
        for (FavoriteEntity favorite : favoriteList) {
            favorite.setId(0);
        }
        return favoriteRepository.saveAll(favoriteList);
    }

    @Override
    public boolean deleteFavorites(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            favoriteRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteFavorites() {
        favoriteRepository.deleteAll();
        return true;
    }

    @Override
    public List<FavoriteEntity> updateFavorites(List<FavoriteEntity> favoriteList) {
        return favoriteRepository.saveAll(favoriteList);
    }

    @Override
    public FavoriteEntity selectFavorite(int id) {
        FavoriteEntity favorite = null;
        try {
            Optional<FavoriteEntity> optional = favoriteRepository.findById(id);
            favorite = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return favorite;
    }

    @Override
    public List<FavoriteEntity> selectFavorites() {
        return favoriteRepository.findAll();
    }

    @Override
    public Iterator<FavoriteEntity> selectFavorites(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<FavoriteEntity> favorites = favoriteRepository.findAll(pageable);
        Iterator<FavoriteEntity> favoriteIterator = favorites.iterator();
        return favoriteIterator;
    }
}
