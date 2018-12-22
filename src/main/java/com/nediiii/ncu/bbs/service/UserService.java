package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

public interface UserService {

    //    增
    public List<UserEntity> insertUsers(List<UserEntity> userList);

    //    删
    public boolean deleteUsers(List<Integer> ids);

    public boolean deleteUsers();

    //    改
    public List<UserEntity> updateUsers(List<UserEntity> userList);

    //    查
    public UserEntity selectUser(int id);

    public UserEntity selectUser(String name, String password);

    public List<UserEntity> selectUsers();

    public Iterator<UserEntity> selectUsers(int pageNum, int pageSize);

    public boolean isUserNameExist(String name);
}
