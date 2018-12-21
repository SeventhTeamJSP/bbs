package com.barret.ncu.bbs.controller;

import com.barret.ncu.bbs.entity.UserEntity;
import com.barret.ncu.bbs.service.implement.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "新增用户")
    @PostMapping("/users")
    public Object addUser(@RequestBody List<UserEntity> userList) {
        userList = userService.insertUsers(userList);
        return userList;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/users")
    public Object deleteUser(@RequestBody List<Integer> ids) {
        return userService.deleteUsers(ids);
    }

    @ApiOperation(value = "删除所有用户")
    @DeleteMapping("/users/all")
    public Object deleteUser() {
        return userService.deleteUsers();
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/users")
    public Object updateUser(@RequestBody List<UserEntity> userList) {
        userList = userService.updateUsers(userList);
        return userList;
    }

    @ApiOperation(value = "获得一个用户")
    @GetMapping("/users/{id}")
    public Object getUserById(@PathVariable int id) {
        UserEntity user = userService.selectUser(id);
        return new ResponseEntity<>(
                user,
                user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @ApiOperation(value = "获得所有用户")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "请求成功",
                    response = UserEntity.class,
                    responseContainer = "List"),
            @ApiResponse(
                    code = 403,
                    message = "无权限",
                    response = Object.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "无内容",
                    response = Object.class
            )
    })
    @GetMapping("/users")
    public Object getUsers() {
        return userService.selectUsers();
    }
}
