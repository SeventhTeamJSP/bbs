package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.PostEntity;
import com.nediiii.ncu.bbs.service.implement.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/posts")
    public Object addPost(@RequestBody List<PostEntity> postList) {
        postList = postService.insertPosts(postList);
        return postList;
    }

    @DeleteMapping("/posts")
    public Object deletePost(@RequestBody List<Integer> ids) {
        return postService.deletePosts(ids);
    }

    @DeleteMapping("/posts/all")
    public Object deletePost() {
        return postService.deletePosts();
    }

    @PutMapping("/posts")
    public Object updatePost(@RequestBody List<PostEntity> postList) {
        postList = postService.updatePosts(postList);
        return postList;
    }

    @GetMapping("/posts/{id}")
    public Object getPostById(@PathVariable int id) {
        PostEntity post = postService.selectPost(id);
        return new ResponseEntity<>(
                post,
                post == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/posts")
    public Object getPosts() {
        return postService.selectPosts();
    }
}
