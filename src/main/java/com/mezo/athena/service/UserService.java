package com.mezo.athena.service;

import com.mezo.athena.demain.User;

/**
 * 用户类
 */
public interface UserService {

    User queryOneByAccount(String account);
}
