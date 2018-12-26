package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.UserEntity;
import com.nediiii.ncu.bbs.repository.UserRepository;
import com.nediiii.ncu.bbs.service.UserService;
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
public class UserServiceImpl implements UserService {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> insertUsers(List<UserEntity> userList) {
        for (UserEntity user : userList) {
            user.setId(0);
        }
        return userRepository.saveAll(userList);
    }

    @Override
    public boolean deleteUsers(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            userRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteUsers() {
        userRepository.deleteAll();
        return true;
    }

    @Override
    public List<UserEntity> updateUsers(List<UserEntity> userList) {
        return userRepository.saveAll(userList);
    }

    @Override
    public UserEntity selectUser(int id) {
        UserEntity user = null;
        try {
            Optional<UserEntity> optional = userRepository.findById(id);
            user = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
//            ex.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public UserEntity selectUser(String name) {
        UserEntity user = null;
        try {
            user = userRepository.findByName(name);
        } catch (Exception ex) {
            return null;
        }
        return user;
    }

    @Override
    public UserEntity selectUser(String name, String password) {
        UserEntity user = null;
        try {
            user = userRepository.findByNameAndPassword(name, password);
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
//            ex.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public List<UserEntity> selectUsers() {
        return userRepository.findAll();
    }

    @Override
    public Iterator<UserEntity> selectUsers(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<UserEntity> users = userRepository.findAll(pageable);
        Iterator<UserEntity> userIterator = users.iterator();
        return userIterator;
    }

    @Override
    public boolean isUserNameExist(String name) {
        return userRepository.findByName(name) != null ? true : false;
    }
}
