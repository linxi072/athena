package com.mezo.athena.mapper;

import com.mezo.athena.demain.AthenaUserRole;

public interface AthenaUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaUserRole record);

    int insertSelective(AthenaUserRole record);

    AthenaUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AthenaUserRole record);

    int updateByPrimaryKey(AthenaUserRole record);

    AthenaUserRole selectRoleByUserId(String userId);
}