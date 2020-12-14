package com.mezo.athena.service;

import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.demain.vo.LoginVO;

/**
 * 登陆类
 */
public interface LoginService {
    AthenaUser login(LoginVO loginVO);
}
