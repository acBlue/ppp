package com.yw.ppp.uc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yw.ppp.uc.entity.User;


public interface UserService extends IService<User> {

    boolean registerUser(User user);

}
