package com.mezo.athena.controller;

import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired(required = false)
    private LoginService loginService;

    @PostMapping("/toLogin")
    public AthenaUser login(AthenaUser user) {
        AthenaUser login = loginService.login(user);
        return login;
    }
}
