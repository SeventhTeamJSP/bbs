package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.FollowEntity;
import com.nediiii.ncu.bbs.repository.FollowRepository;
import com.nediiii.ncu.bbs.service.FollowService;
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
public class FollowServiceImpl implements FollowService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FollowRepository followRepository;

    @Override
    public List<FollowEntity> insertFollows(List<FollowEntity> followList) {
        for (FollowEntity follow : followList) {
            follow.setId(0);
        }
        return followRepository.saveAll(followList);
    }

    @Override
    public boolean deleteFollows(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            followRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteFollows() {
        followRepository.deleteAll();
        return true;
    }

    @Override
    public List<FollowEntity> updateFollows(List<FollowEntity> followList) {
        return followRepository.saveAll(followList);
    }

    @Override
    public FollowEntity selectFollow(int id) {
        FollowEntity follow = null;
        try {
            Optional<FollowEntity> optional = followRepository.findById(id);
            follow = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return follow;
    }

    @Override
    public List<FollowEntity> selectFollows() {
        return followRepository.findAll();
    }

    @Override
    public Iterator<FollowEntity> selectFollows(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<FollowEntity> follows = followRepository.findAll(pageable);
        Iterator<FollowEntity> followIterator = follows.iterator();
        return followIterator;
    }
}
