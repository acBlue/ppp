package com.yw.ppp.uc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yw.ppp.uc.entity.Permission;
import com.yw.ppp.uc.repository.PermissionRepository;
import com.yw.ppp.uc.service.PermissionService;
import org.springframework.stereotype.Service;

@Service(value = "permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionRepository, Permission> implements PermissionService {
}
