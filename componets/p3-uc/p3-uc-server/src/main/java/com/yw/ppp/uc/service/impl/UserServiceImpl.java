package com.yw.ppp.uc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yw.core.base.exception.BusinessException;
import com.yw.ppp.uc.entity.User;
import com.yw.ppp.uc.mapper.UserMapper;
import com.yw.ppp.uc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;


@Service("userService")
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * @param user
     * @return
     */
    @Override
    public void registerUser(User user) {
        log.debug("注册用户");
        log.debug("用户入参:{}", user);

        String account = user.getAccount();

        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getAccount, account);
        List<User> userList = this.list(userQueryWrapper);
        if (!userList.isEmpty()) {
            log.error("用户已存在，注册失败,account:{}", account);
            throw new BusinessException("用户已经存在");
        }
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        user.setCreateTime(LocalDateTime.now());
        this.save(user);
        log.info("用户注册完成");

        userMapper.insert(user);

    }

    @Override
    public void lockUser(Long userId) {
       User user = this.getById(userId);
       user.setActive(false);
       this.updateById(user);

    }

}
