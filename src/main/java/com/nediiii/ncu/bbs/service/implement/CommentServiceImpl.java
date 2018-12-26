package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.CommentEntity;
import com.nediiii.ncu.bbs.repository.CommentRepository;
import com.nediiii.ncu.bbs.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentEntity> insertComments(List<CommentEntity> commentList) {
        for (CommentEntity comment : commentList) {
            comment.setId(0);
        }
        return commentRepository.saveAll(commentList);
    }

    @Override
    public boolean deleteComments(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            commentRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteComments() {
        commentRepository.deleteAll();
        return true;
    }

    @Override
    public List<CommentEntity> updateComments(List<CommentEntity> commentList) {
        return commentRepository.saveAll(commentList);
    }

    @Override
    public CommentEntity selectComment(int id) {
        CommentEntity comment = null;
        try {
            Optional<CommentEntity> optional = commentRepository.findById(id);
            comment = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return comment;
    }

    @Override
    public List<CommentEntity> selectComments() {
        return commentRepository.findAll();
    }

    @Override
    public Iterator<CommentEntity> selectComments(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<CommentEntity> comments = commentRepository.findAll(pageable);
        Iterator<CommentEntity> commentIterator = comments.iterator();
        return commentIterator;
    }
}
