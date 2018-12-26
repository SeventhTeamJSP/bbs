package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.ThumbsUpEntity;
import com.nediiii.ncu.bbs.repository.ThumbsUpRepository;
import com.nediiii.ncu.bbs.service.ThumbsUpService;
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
public class ThumbsUpServiceImpl implements ThumbsUpService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ThumbsUpRepository thumbsUpRepository;

    @Override
    public List<ThumbsUpEntity> insertThumbsUps(List<ThumbsUpEntity> thumbsUpList) {
        for (ThumbsUpEntity thumbsUp : thumbsUpList) {
            thumbsUp.setId(0);
        }
        return thumbsUpRepository.saveAll(thumbsUpList);
    }

    @Override
    public boolean deleteThumbsUps(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            thumbsUpRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteThumbsUps() {
        thumbsUpRepository.deleteAll();
        return true;
    }

    @Override
    public List<ThumbsUpEntity> updateThumbsUps(List<ThumbsUpEntity> thumbsUpList) {
        return thumbsUpRepository.saveAll(thumbsUpList);
    }

    @Override
    public ThumbsUpEntity selectThumbsUp(int id) {
        ThumbsUpEntity thumbsUp = null;
        try {
            Optional<ThumbsUpEntity> optional = thumbsUpRepository.findById(id);
            thumbsUp = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return thumbsUp;
    }

    @Override
    public List<ThumbsUpEntity> selectThumbsUps() {
        return thumbsUpRepository.findAll();
    }

    @Override
    public Iterator<ThumbsUpEntity> selectThumbsUps(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<ThumbsUpEntity> thumbsUps = thumbsUpRepository.findAll(pageable);
        Iterator<ThumbsUpEntity> thumbsUpIterator = thumbsUps.iterator();
        return thumbsUpIterator;
    }
}
