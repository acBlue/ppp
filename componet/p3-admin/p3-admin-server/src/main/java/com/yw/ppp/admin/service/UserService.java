package com.yw.ppp.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yw.ppp.admin.entity.User;


public interface UserService extends IService<User> {

    boolean registerUser(User user);
}
