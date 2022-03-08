package com.yw.ppp.uc.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yw.core.base.mapper.JacksonMapper;
import com.yw.ppp.uc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    @Transactional
    void testRegisterUser() {

      User user =  userService.getOne(new LambdaQueryWrapper<User>().eq(User::getAccount,"lisi"));


      userService.lockUser(user.getId());
      System.out.println(JacksonMapper.toJson(user));

    }

    void testTan(){




    }
}