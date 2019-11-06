package com.cn.smart.service.user;

import com.cn.smart.jpa.entity.user.User;

public interface IUserService {

    void addUser(User user);

    User findById(Long id);
}
