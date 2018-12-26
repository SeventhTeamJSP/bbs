package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.UserRoleEntity;
import com.nediiii.ncu.bbs.repository.UserRoleRepository;
import com.nediiii.ncu.bbs.service.UserRoleService;
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
public class UserRoleServiceImpl implements UserRoleService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRoleEntity> insertUserRoles(List<UserRoleEntity> userRoleList) {
        for (UserRoleEntity userRole : userRoleList) {
            userRole.setId(0);
        }
        return userRoleRepository.saveAll(userRoleList);
    }

    @Override
    public boolean deleteUserRoles(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            userRoleRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteUserRoles() {
        userRoleRepository.deleteAll();
        return true;
    }

    @Override
    public List<UserRoleEntity> updateUserRoles(List<UserRoleEntity> userRoleList) {
        return userRoleRepository.saveAll(userRoleList);
    }

    @Override
    public UserRoleEntity selectUserRole(int id) {
        UserRoleEntity userRole = null;
        try {
            Optional<UserRoleEntity> optional = userRoleRepository.findById(id);
            userRole = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return userRole;
    }

    @Override
    public List<UserRoleEntity> selectUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public Iterator<UserRoleEntity> selectUserRoles(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<UserRoleEntity> userRoles = userRoleRepository.findAll(pageable);
        Iterator<UserRoleEntity> userRoleIterator = userRoles.iterator();
        return userRoleIterator;
    }
}
