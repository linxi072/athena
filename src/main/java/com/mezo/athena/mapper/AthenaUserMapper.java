package com.mezo.athena.mapper;

import com.mezo.athena.demain.AthenaUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AthenaUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AthenaUser record);

    int insertSelective(AthenaUser record);

    AthenaUser selectByPrimaryKey(Integer id);

    List<AthenaUser> selectByUserName(String userName);

    int updateByPrimaryKeySelective(AthenaUser record);

    int updateByPrimaryKey(AthenaUser record);
}