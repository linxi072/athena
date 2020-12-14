package com.mezo.athena.service.impl;

import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.demain.AthenaUserRole;
import com.mezo.athena.demain.vo.LoginVO;
import com.mezo.athena.service.LoginService;
import com.mezo.athena.service.MenuService;
import com.mezo.athena.service.RoleService;
import com.mezo.athena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private RoleService roleService;
    @Autowired(required = false)
    private MenuService menuService;

    @Override
    public AthenaUser login(LoginVO loginVO) {
        AthenaUser user = userService.queryOneByUserId(loginVO.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("用户不存在!");
        }
        if (loginVO.getPassWord().equals(user.getPassWord())) {
            throw new IllegalArgumentException("密码错误!");
        }
        AthenaUserRole userRole = roleService.selectRoleByUserId(user.getUserId());
        return user;
    }

}
