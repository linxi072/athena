package com.mezo.athena.service.impl;

import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.demain.vo.UserVO;
import com.mezo.athena.mapper.AthenaUserMapper;
import com.mezo.athena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private AthenaUserMapper athenaUserMapper;
    @Override
    public AthenaUser queryOneByUsername(String userId) {
        AthenaUser athenaUser = athenaUserMapper.selectByUserId(userId);
        return athenaUser;
    }

    @Override
    public List<AthenaUser> queryByCase(UserVO userVO) {
        return athenaUserMapper.queryByCase(userVO);
    }
}
