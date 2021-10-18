package com.yw.ppp.uc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yw.ppp.uc.entity.Menu;
import com.yw.ppp.uc.repository.MenuRepository;
import com.yw.ppp.uc.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service(value = "meunService")
public class MenuServiceImpl extends ServiceImpl<MenuRepository, Menu> implements MenuService {


}
