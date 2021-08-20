package com.mezo.athena.admin.controller;

import com.mezo.athena.admin.common.constant.SystemConstant;
import com.mezo.athena.admin.demain.AthenaUser;
import com.mezo.athena.admin.demain.vo.LoginVO;
import com.mezo.athena.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @author qzrs
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired(required = false)
    private LoginService loginService;

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    @PostMapping("/toLogin")
    public AthenaUser login(LoginVO user) {
        AthenaUser login = loginService.login(user);
        return login;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping("/doRegister")
    public AthenaUser doRegister(LoginVO user) {
        return null;
    }

    /**
     * 注销
     *
     * @param session
     */
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute(SystemConstant.CURRENT_USER_CONTEXT);
    }
}
