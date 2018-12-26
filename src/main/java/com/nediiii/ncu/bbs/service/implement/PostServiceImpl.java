package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.PostEntity;
import com.nediiii.ncu.bbs.repository.PostRepository;
import com.nediiii.ncu.bbs.service.PostService;
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
public class PostServiceImpl implements PostService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostEntity> insertPosts(List<PostEntity> postList) {
        for (PostEntity post : postList) {
            post.setId(0);
        }
        return postRepository.saveAll(postList);
    }

    @Override
    public boolean deletePosts(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            postRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deletePosts() {
        postRepository.deleteAll();
        return true;
    }

    @Override
    public List<PostEntity> updatePosts(List<PostEntity> postList) {
        return postRepository.saveAll(postList);
    }

    @Override
    public PostEntity selectPost(int id) {
        PostEntity post = null;
        try {
            Optional<PostEntity> optional = postRepository.findById(id);
            post = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return post;
    }

    @Override
    public List<PostEntity> selectPosts() {
        return postRepository.findAll();
    }

    @Override
    public Iterator<PostEntity> selectPosts(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<PostEntity> posts = postRepository.findAll(pageable);
        Iterator<PostEntity> postIterator = posts.iterator();
        return postIterator;
    }
}
