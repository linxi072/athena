package com.mezo.athena.service;

import com.mezo.athena.demain.AthenaUser;

/**
 * 登陆类
 */
public interface LoginService {
    AthenaUser login(AthenaUser userVO);
}
