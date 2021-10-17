package com.yw.ppp.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yw.ppp.admin.entity.Menu;
import com.yw.ppp.admin.repository.MenuRepository;
import com.yw.ppp.admin.service.MenuService;
import org.springframework.stereotype.Service;

@Service(value = "meunService")
public class MenuServiceImpl extends ServiceImpl<MenuRepository, Menu> implements MenuService {


}
