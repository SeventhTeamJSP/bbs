package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.UserRoleEntity;

import java.util.Iterator;
import java.util.List;

public interface UserRoleService {

    //    增
    public List<UserRoleEntity> insertUserRoles(List<UserRoleEntity> userRoleList);

    //    删
    public boolean deleteUserRoles(List<Integer> ids);

    public boolean deleteUserRoles();

    //    改
    public List<UserRoleEntity> updateUserRoles(List<UserRoleEntity> userRoleList);

    //    查
    public UserRoleEntity selectUserRole(int id);

    public List<UserRoleEntity> selectUserRoles();

    public Iterator<UserRoleEntity> selectUserRoles(int pageNum, int pageSize);

}
