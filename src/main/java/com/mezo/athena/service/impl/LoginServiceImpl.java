package com.mezo.athena.service.impl;

import com.mezo.athena.demain.User;
import com.mezo.athena.demain.UserVO;
import com.mezo.athena.service.LoginService;
import com.mezo.athena.service.MenuService;
import com.mezo.athena.service.RoleService;
import com.mezo.athena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @Override
    public UserVO login(UserVO userVO) {
        User user = userService.queryOneByAccount(userVO.getAccount());
        return null;
    }
}
