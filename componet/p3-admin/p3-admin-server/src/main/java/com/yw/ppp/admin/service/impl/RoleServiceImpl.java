package com.yw.ppp.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yw.ppp.admin.entity.Role;
import com.yw.ppp.admin.repository.RoleRepository;
import com.yw.ppp.admin.service.RoleService;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl extends ServiceImpl<RoleRepository, Role> implements RoleService {


}
