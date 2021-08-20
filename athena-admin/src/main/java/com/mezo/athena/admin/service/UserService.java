package com.mezo.athena.admin.service;

import com.mezo.athena.admin.demain.AthenaUser;
import com.mezo.athena.admin.demain.vo.UserVO;

import java.util.List;

/**
 * 用户类
 */
public interface UserService {

    AthenaUser queryOneByUsername(String username);

    List<AthenaUser> queryByCase(UserVO userVO);
}
