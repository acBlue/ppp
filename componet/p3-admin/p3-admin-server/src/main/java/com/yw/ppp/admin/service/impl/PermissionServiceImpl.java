package com.yw.ppp.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yw.ppp.admin.entity.Permission;
import com.yw.ppp.admin.repository.PermissionRepository;
import com.yw.ppp.admin.service.PermissionService;
import org.springframework.stereotype.Service;

@Service(value = "permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionRepository, Permission> implements PermissionService {
}
