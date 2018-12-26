package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.ThumbsUpEntity;
import com.nediiii.ncu.bbs.service.implement.ThumbsUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ThumbsUpController {

    @Autowired
    private ThumbsUpServiceImpl thumbsUpService;

    @PostMapping("/thumbsUps")
    public Object addThumbsUp(@RequestBody List<ThumbsUpEntity> thumbsUpList) {
        thumbsUpList = thumbsUpService.insertThumbsUps(thumbsUpList);
        return thumbsUpList;
    }

    @DeleteMapping("/thumbsUps")
    public Object deleteThumbsUp(@RequestBody List<Integer> ids) {
        return thumbsUpService.deleteThumbsUps(ids);
    }

    @DeleteMapping("/thumbsUps/all")
    public Object deleteThumbsUp() {
        return thumbsUpService.deleteThumbsUps();
    }

    @PutMapping("/thumbsUps")
    public Object updateThumbsUp(@RequestBody List<ThumbsUpEntity> thumbsUpList) {
        thumbsUpList = thumbsUpService.updateThumbsUps(thumbsUpList);
        return thumbsUpList;
    }

    @GetMapping("/thumbsUps/{id}")
    public Object getThumbsUpById(@PathVariable int id) {
        ThumbsUpEntity thumbsUp = thumbsUpService.selectThumbsUp(id);
        return new ResponseEntity<>(
                thumbsUp,
                thumbsUp == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/thumbsUps")
    public Object getThumbsUps() {
        return thumbsUpService.selectThumbsUps();
    }
}
