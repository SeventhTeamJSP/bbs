package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.RoleEntity;

import java.util.Iterator;
import java.util.List;

public interface RoleService {

    //    增
    public List<RoleEntity> insertRoles(List<RoleEntity> roleList);

    //    删
    public boolean deleteRoles(List<Integer> ids);

    public boolean deleteRoles();

    //    改
    public List<RoleEntity> updateRoles(List<RoleEntity> roleList);

    //    查
    public RoleEntity selectRole(int id);

    public RoleEntity selectRole(String name);

    public List<RoleEntity> selectRoles();

    public Iterator<RoleEntity> selectRoles(int pageNum, int pageSize);

}
