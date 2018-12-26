package com.nediiii.ncu.bbs.security;

import com.nediiii.ncu.bbs.entity.UserEntity;
import com.nediiii.ncu.bbs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        logger.warn("自定义UserDetailsService执行");
        logger.warn("登录用户名为:" + name);
        UserEntity user = userService.selectUser(name);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        CustomUserDetails userDetails = new CustomUserDetails(user, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));
        return userDetails;
    }
}
