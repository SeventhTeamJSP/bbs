package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.FavoriteEntity;
import com.nediiii.ncu.bbs.service.implement.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FavoriteController {

    @Autowired
    private FavoriteServiceImpl favoriteService;

    @PostMapping("/favorites")
    public Object addFavorite(@RequestBody List<FavoriteEntity> favoriteList) {
        favoriteList = favoriteService.insertFavorites(favoriteList);
        return favoriteList;
    }

    @DeleteMapping("/favorites")
    public Object deleteFavorite(@RequestBody List<Integer> ids) {
        return favoriteService.deleteFavorites(ids);
    }

    @DeleteMapping("/favorites/all")
    public Object deleteFavorite() {
        return favoriteService.deleteFavorites();
    }

    @PutMapping("/favorites")
    public Object updateFavorite(@RequestBody List<FavoriteEntity> favoriteList) {
        favoriteList = favoriteService.updateFavorites(favoriteList);
        return favoriteList;
    }

    @GetMapping("/favorites/{id}")
    public Object getFavoriteById(@PathVariable int id) {
        FavoriteEntity favorite = favoriteService.selectFavorite(id);
        return new ResponseEntity<>(
                favorite,
                favorite == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/favorites")
    public Object getFavorites() {
        return favoriteService.selectFavorites();
    }
}
