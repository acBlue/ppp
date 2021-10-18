package com.yw.ppp.uc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yw.ppp.uc.entity.User;
import com.yw.ppp.uc.repository.UserRepository;
import com.yw.ppp.uc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * @param user
     * @return
     */
    @Override
    public boolean registerUser(User user) {
        logger.debug("注册用户");
        logger.debug("用户入参:{}", user);

        String account = user.getAccount();

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("account", account);
        List<User> userList = this.list(userQueryWrapper);
        if (!userList.isEmpty()) {
            logger.error("用户已存在，注册失败,account:{}", account);
            //throw new
        }

        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        user.setCreateTime(LocalDateTime.now());

        logger.info("用户注册完成");
        return this.save(user);
    }
}
