package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.FollowEntity;
import com.nediiii.ncu.bbs.service.implement.FollowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FollowController {

    @Autowired
    private FollowServiceImpl followService;

    @PostMapping("/follows")
    public Object addFollow(@RequestBody List<FollowEntity> followList) {
        followList = followService.insertFollows(followList);
        return followList;
    }

    @DeleteMapping("/follows")
    public Object deleteFollow(@RequestBody List<Integer> ids) {
        return followService.deleteFollows(ids);
    }

    @DeleteMapping("/follows/all")
    public Object deleteFollow() {
        return followService.deleteFollows();
    }

    @PutMapping("/follows")
    public Object updateFollow(@RequestBody List<FollowEntity> followList) {
        followList = followService.updateFollows(followList);
        return followList;
    }

    @GetMapping("/follows/{id}")
    public Object getFollowById(@PathVariable int id) {
        FollowEntity follow = followService.selectFollow(id);
        return new ResponseEntity<>(
                follow,
                follow == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/follows")
    public Object getFollows() {
        return followService.selectFollows();
    }
}
