package com.mezo.athena.controller;

import com.mezo.athena.common.config.CommonContext;
import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.demain.vo.LoginVO;
import com.mezo.athena.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired(required = false)
    private LoginService loginService;

    /**
     * 登陆
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
     * @param user
     * @return
     */
    @PostMapping("/doRegister")
    public AthenaUser doRegister(LoginVO user) {
        return null;
    }

    /**
     * 注销
     * @param session
     */
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute(CommonContext.CURRENT_USER_CONTEXT);
    }
}
