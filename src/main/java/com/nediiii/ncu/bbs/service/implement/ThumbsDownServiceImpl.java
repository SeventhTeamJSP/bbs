package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.ThumbsDownEntity;
import com.nediiii.ncu.bbs.repository.ThumbsDownRepository;
import com.nediiii.ncu.bbs.service.ThumbsDownService;
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
public class ThumbsDownServiceImpl implements ThumbsDownService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ThumbsDownRepository thumbsDownRepository;

    @Override
    public List<ThumbsDownEntity> insertThumbsDowns(List<ThumbsDownEntity> thumbsDownList) {
        for (ThumbsDownEntity thumbsDown : thumbsDownList) {
            thumbsDown.setId(0);
        }
        return thumbsDownRepository.saveAll(thumbsDownList);
    }

    @Override
    public boolean deleteThumbsDowns(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            thumbsDownRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteThumbsDowns() {
        thumbsDownRepository.deleteAll();
        return true;
    }

    @Override
    public List<ThumbsDownEntity> updateThumbsDowns(List<ThumbsDownEntity> thumbsDownList) {
        return thumbsDownRepository.saveAll(thumbsDownList);
    }

    @Override
    public ThumbsDownEntity selectThumbsDown(int id) {
        ThumbsDownEntity thumbsDown = null;
        try {
            Optional<ThumbsDownEntity> optional = thumbsDownRepository.findById(id);
            thumbsDown = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return thumbsDown;
    }

    @Override
    public List<ThumbsDownEntity> selectThumbsDowns() {
        return thumbsDownRepository.findAll();
    }

    @Override
    public Iterator<ThumbsDownEntity> selectThumbsDowns(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<ThumbsDownEntity> thumbsDowns = thumbsDownRepository.findAll(pageable);
        Iterator<ThumbsDownEntity> thumbsDownIterator = thumbsDowns.iterator();
        return thumbsDownIterator;
    }
}
