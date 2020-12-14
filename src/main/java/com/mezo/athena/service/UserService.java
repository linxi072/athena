package com.mezo.athena.service;

import com.mezo.athena.demain.AthenaUser;

/**
 * 用户类
 */
public interface UserService {

    AthenaUser queryOneByAccount(String account);
}
