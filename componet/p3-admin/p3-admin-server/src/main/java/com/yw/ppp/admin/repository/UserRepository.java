package com.yw.ppp.admin.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yw.ppp.admin.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseMapper<User> {
}

