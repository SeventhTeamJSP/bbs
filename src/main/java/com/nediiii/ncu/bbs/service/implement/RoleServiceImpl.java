package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.RoleEntity;
import com.nediiii.ncu.bbs.repository.RoleRepository;
import com.nediiii.ncu.bbs.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> insertRoles(List<RoleEntity> roleList) {
        for (RoleEntity role : roleList) {
            role.setId(0);
        }
        return roleRepository.saveAll(roleList);
    }

    @Override
    public boolean deleteRoles(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            roleRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteRoles() {
        roleRepository.deleteAll();
        return true;
    }

    @Override
    public List<RoleEntity> updateRoles(List<RoleEntity> roleList) {
        return roleRepository.saveAll(roleList);
    }

    @Override
    public RoleEntity selectRole(int id) {
        RoleEntity role = null;
        try {
            Optional<RoleEntity> optional = roleRepository.findById(id);
            role = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return role;
    }

    @Override
    public RoleEntity selectRole(String name) {
        return null;
    }

    @Override
    public List<RoleEntity> selectRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Iterator<RoleEntity> selectRoles(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<RoleEntity> roles = roleRepository.findAll(pageable);
        Iterator<RoleEntity> roleIterator = roles.iterator();
        return roleIterator;
    }
}
