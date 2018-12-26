package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.ThumbsDownEntity;
import com.nediiii.ncu.bbs.service.implement.ThumbsDownServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ThumbsDownController {

    @Autowired
    private ThumbsDownServiceImpl thumbsDownService;

    @PostMapping("/thumbsDowns")
    public Object addThumbsDown(@RequestBody List<ThumbsDownEntity> thumbsDownList) {
        thumbsDownList = thumbsDownService.insertThumbsDowns(thumbsDownList);
        return thumbsDownList;
    }

    @DeleteMapping("/thumbsDowns")
    public Object deleteThumbsDown(@RequestBody List<Integer> ids) {
        return thumbsDownService.deleteThumbsDowns(ids);
    }

    @DeleteMapping("/thumbsDowns/all")
    public Object deleteThumbsDown() {
        return thumbsDownService.deleteThumbsDowns();
    }

    @PutMapping("/thumbsDowns")
    public Object updateThumbsDown(@RequestBody List<ThumbsDownEntity> thumbsDownList) {
        thumbsDownList = thumbsDownService.updateThumbsDowns(thumbsDownList);
        return thumbsDownList;
    }

    @GetMapping("/thumbsDowns/{id}")
    public Object getThumbsDownById(@PathVariable int id) {
        ThumbsDownEntity thumbsDown = thumbsDownService.selectThumbsDown(id);
        return new ResponseEntity<>(
                thumbsDown,
                thumbsDown == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/thumbsDowns")
    public Object getThumbsDowns() {
        return thumbsDownService.selectThumbsDowns();
    }
}
