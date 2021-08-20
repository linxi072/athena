package com.mezo.athena.admin.service.impl;

import com.mezo.athena.admin.common.constant.RedisConstant;
import com.mezo.athena.admin.common.exception.IllegalDataException;
import com.mezo.athena.admin.common.util.HttpServletUtils;
import com.mezo.athena.admin.demain.AthenaUser;
import com.mezo.athena.admin.demain.vo.LoginVO;
import com.mezo.athena.admin.service.LoginService;
import com.mezo.athena.admin.service.MenuService;
import com.mezo.athena.admin.service.RoleService;
import com.mezo.athena.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author qzrs
 */
@Service
public class LoginServiceImpl implements LoginService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
        HttpSession session = HttpServletUtils.getSession();
        session.setAttribute(RedisConstant.REDIS_SESSION_USER_KEY,userDetails);
        return (AthenaUser) userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userService.queryOneByUsername(username);
        return null;
    }
}
