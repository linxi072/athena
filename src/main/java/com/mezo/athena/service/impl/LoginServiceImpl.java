package com.mezo.athena.service.impl;

import com.mezo.athena.common.config.CommonContext;
import com.mezo.athena.common.exception.IllegalDataException;
import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.demain.AthenaUserRole;
import com.mezo.athena.demain.vo.LoginVO;
import com.mezo.athena.service.LoginService;
import com.mezo.athena.service.MenuService;
import com.mezo.athena.service.RoleService;
import com.mezo.athena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author qzrs
 */
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
        UserDetails userDetails = loadUserByUsername(loginVO.getUsername());
        if (userDetails == null) {
            throw new IllegalDataException("用户不存在!");
        }
        if (loginVO.getPassword().equals(userDetails.getPassword())) {
            throw new IllegalDataException("密码错误!");
        }
        return (AthenaUser) userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        userService.queryOneByUsername(username);
        return null;
    }
}
