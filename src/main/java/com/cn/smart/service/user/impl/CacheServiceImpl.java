package com.cn.smart.service.user.impl;

import com.cn.smart.jpa.repository.user.UserRepository;
import com.cn.smart.mapper.user.UserDao;
import com.cn.smart.model.user.User;
import com.cn.smart.service.user.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CacheServiceImpl implements ICacheService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    @Cacheable(value = "user", key = "#uId")
    @Override
    public User findById(Long uId) {
        User user = userDao.selectByPrimaryKey(uId);
        return user;
    }

}

