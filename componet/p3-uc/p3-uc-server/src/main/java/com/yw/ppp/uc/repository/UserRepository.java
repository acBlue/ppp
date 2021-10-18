package com.yw.ppp.uc.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yw.ppp.uc.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseMapper<User> {
}

