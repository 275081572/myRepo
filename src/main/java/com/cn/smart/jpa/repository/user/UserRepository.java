package com.cn.smart.jpa.repository.user;

import com.cn.smart.jpa.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
