package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.CommentEntity;
import com.nediiii.ncu.bbs.service.implement.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping("/comments")
    public Object addComment(@RequestBody List<CommentEntity> commentList) {
        commentList = commentService.insertComments(commentList);
        return commentList;
    }

    @DeleteMapping("/comments")
    public Object deleteComment(@RequestBody List<Integer> ids) {
        return commentService.deleteComments(ids);
    }

    @DeleteMapping("/comments/all")
    public Object deleteComment() {
        return commentService.deleteComments();
    }

    @PutMapping("/comments")
    public Object updateComment(@RequestBody List<CommentEntity> commentList) {
        commentList = commentService.updateComments(commentList);
        return commentList;
    }

    @GetMapping("/comments/{id}")
    public Object getCommentById(@PathVariable int id) {
        CommentEntity comment = commentService.selectComment(id);
        return new ResponseEntity<>(
                comment,
                comment == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/comments")
    public Object getComments() {
        return commentService.selectComments();
    }
}
