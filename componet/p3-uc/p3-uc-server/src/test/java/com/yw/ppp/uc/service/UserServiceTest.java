package com.yw.ppp.uc.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.yw.core.base.mapper.JacksonMapper;
import com.yw.ppp.uc.entity.Menu;
import com.yw.ppp.uc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    MenuService menuService;

    @Test
    @Transactional
    void testRegisterUser() {

      User user =  userService.getOne(new LambdaQueryWrapper<User>().eq(User::getAccount,"lisi"));


      userService.lockUser(user.getId());
      System.out.println(JacksonMapper.toJson(user));

        Menu menu = new Menu();
        menu.setName("权限");
        menu.setParentId(user.getId());
        menu.setUrl("");
      menuService.save(menu);

      //  LambdaQueryWrapper lambdaQueryWrapper();

      int a = 0/1;
    }

    void testTan(){




    }
}