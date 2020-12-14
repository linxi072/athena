package com.mezo.athena.service;

import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.demain.vo.UserVO;

import java.util.List;

/**
 * 用户类
 */
public interface UserService {

    AthenaUser queryOneByUserId(String userId);

    List<AthenaUser> queryByCase(UserVO userVO);
}
