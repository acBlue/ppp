package com.yw.ppp.uc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yw.ppp.uc.entity.Role;
import com.yw.ppp.uc.mapper.RoleMapper;
import com.yw.ppp.uc.service.RoleService;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


}
