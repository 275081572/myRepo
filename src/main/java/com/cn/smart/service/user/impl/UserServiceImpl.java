package com.cn.smart.service.user.impl;

import com.cn.smart.dto.ADTO;
import com.cn.smart.dto.Account;
import com.cn.smart.dto.BDTO;
import com.cn.smart.dto.MemberDTO;
import com.cn.smart.dto.MixDTO;
import com.cn.smart.jpa.entity.user.User;
import com.cn.smart.jpa.repository.user.UserRepository;
import com.cn.smart.rocketmq.MsgProducer;
import com.cn.smart.service.user.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MsgProducer msgProducer;

    /**线程池测试**/
    ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(512), new ThreadPoolExecutor.DiscardPolicy());

    ExecutorService executorService2 = Executors.newFixedThreadPool(5);
    private void testExecutor(){
        executorService.submit(new Runnable() {
            @Override public void run() {
                System.out.println("");
            }
        });
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
        System.out.println(user);
    }

    //@Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        //TODO测试
        ADTO aDto = new ADTO();
        aDto.setAge(12);
        aDto.setName("xuwei");

        BDTO bDto = new BDTO();
        bDto.setPrice(12.3D);
        bDto.setRemark("hehe...");

        MixDTO mixDTO = new MixDTO();
        BeanUtils.copyProperties(aDto, mixDTO);
        BeanUtils.copyProperties(bDto, mixDTO);
        System.out.println(mixDTO);

        //return jdbcTemplate.queryForObject("", User.class);

        User user = userRepository.getOne(id);
        //消息队列测试
        //msgProducer.sendSettleOrderToMq(mixDTO);


        //测试静态内部类
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setAge(12);
        memberDTO.setName("徐伟");

        Account account = new Account();
        account.setId("111");
        Account.Member member = new Account.Member();
        BeanUtils.copyProperties(memberDTO, member);
        account.setMember(member);

        return user;
    }

    @Override
    public void ececptionTest() {
        throw new NullPointerException();
    }
}
