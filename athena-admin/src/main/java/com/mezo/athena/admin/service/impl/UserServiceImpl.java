package com.mezo.athena.admin.service.impl;

import com.mezo.athena.admin.demain.AthenaUser;
import com.mezo.athena.admin.demain.vo.UserVO;
import com.mezo.athena.admin.mapper.AthenaUserMapper;
import com.mezo.athena.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private AthenaUserMapper athenaUserMapper;

    @Override
    public AthenaUser queryOneByUsername(String username) {
        AthenaUser athenaUser = athenaUserMapper.selectByUsername(username);
        return athenaUser;
    }

    @Override
    public List<AthenaUser> queryByCase(UserVO userVO) {
        return athenaUserMapper.queryByCase(userVO);
    }
}
