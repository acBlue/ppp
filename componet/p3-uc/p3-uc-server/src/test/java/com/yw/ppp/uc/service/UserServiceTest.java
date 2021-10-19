package com.yw.ppp.uc.service;

import com.yw.ppp.uc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void testRegisterUser() {

        User user = new User();
        user.setAccount("zhangsan");
        user.setActive(false);
        user.setCreateTime(LocalDateTime.now());
        user.setName("大嫂");
        user.setPassword("23123143");

        boolean flag =  userService.registerUser(user);
        assert  flag == true;
    }
}