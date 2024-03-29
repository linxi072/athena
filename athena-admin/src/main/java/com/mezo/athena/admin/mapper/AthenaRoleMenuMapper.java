package com.mezo.athena.admin.mapper;

import com.mezo.athena.admin.demain.AthenaRoleMenu;

public interface AthenaRoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaRoleMenu record);

    int insertSelective(AthenaRoleMenu record);

    AthenaRoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AthenaRoleMenu record);

    int updateByPrimaryKey(AthenaRoleMenu record);
}