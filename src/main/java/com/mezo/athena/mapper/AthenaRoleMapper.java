package com.mezo.athena.mapper;

import com.mezo.athena.demain.AthenaRole;

public interface AthenaRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaRole record);

    int insertSelective(AthenaRole record);

    AthenaRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AthenaRole record);

    int updateByPrimaryKey(AthenaRole record);

    AthenaRole selectByRoleId(String roleId);
}