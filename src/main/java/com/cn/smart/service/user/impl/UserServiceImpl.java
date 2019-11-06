package com.cn.smart.service.user.impl;

import com.cn.smart.jpa.entity.user.User;
import com.cn.smart.jpa.repository.user.UserRepository;
import com.cn.smart.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
        System.out.println(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }
}
