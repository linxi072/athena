package com.mezo.athena.admin.mapper;

import com.mezo.athena.admin.demain.AthenaUser;
import com.mezo.athena.admin.demain.vo.UserVO;

import java.util.List;

public interface AthenaUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaUser record);

    int insertSelective(AthenaUser record);

    int updateByPrimaryKeySelective(AthenaUser record);

    int updateByPrimaryKey(AthenaUser record);

    AthenaUser selectByPrimaryKey(Integer id);

    AthenaUser selectByUsername(String username);

    List<AthenaUser> queryByCase(UserVO userVO);
}