package com.mezo.athena.admin.service;

import com.mezo.athena.admin.demain.AthenaUser;
import com.mezo.athena.admin.demain.vo.LoginVO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 登陆类
 *
 * @author qzrs
 */
public interface LoginService extends UserDetailsService {
    AthenaUser login(LoginVO loginVO);
}
