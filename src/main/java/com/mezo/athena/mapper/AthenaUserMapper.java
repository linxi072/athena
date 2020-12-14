package com.mezo.athena.mapper;

import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.demain.vo.UserVO;

import java.util.List;

public interface AthenaUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaUser record);

    int insertSelective(AthenaUser record);

    int updateByPrimaryKeySelective(AthenaUser record);

    int updateByPrimaryKey(AthenaUser record);

    AthenaUser selectByPrimaryKey(Integer id);

    AthenaUser selectByUserId(String userId);

    List<AthenaUser> queryByCase(UserVO userVO);
}