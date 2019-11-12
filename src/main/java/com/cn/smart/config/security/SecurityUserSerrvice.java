package com.cn.smart.config.security;

import com.cn.smart.common.BizException;
import com.cn.smart.common.ResultConstanst;
import com.cn.smart.jpa.entity.user.Role;
import com.cn.smart.jpa.entity.user.User;
import com.cn.smart.jpa.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringSecurity服务类
 * 需要实现UserDetailsService接口
 * 因为在Spring Security中配置的相关参数需要是UserDetailsService类型的数据
 */
@Service
public class SecurityUserSerrvice implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /*
     *  重写UserDetailsService接口中的loadUserByUsername方法，通过该方法查询到对应的用户(non-Javadoc)
     *  返回对象UserDetails是Spring Security中一个核心的接口。
     *  其中定义了一些可以获取用户名、密码、权限等与认证相关的信息的方法。
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if(user == null){
            throw new BizException(ResultConstanst.FAIL, ResultConstanst.MSG.USER_IS_NOT_EXIST);
        }
        //获得当前用户权限集合
        List<Role> roles = user.getRoles();
        //创建List集合，用来保存用户权限，GrantedAuthority对象代表赋予给当前用户的权限
        List<GrantedAuthority> authorityList = new ArrayList<>(roles.size());
        for(Role role: roles){
            // 将关联对象Role的authority属性保存为用户的认证权限
            authorityList.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        // 此处返回的是org.springframework.security.core.userdetails.User类，该类是Spring Security内部的实现
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorityList);
    }
}
