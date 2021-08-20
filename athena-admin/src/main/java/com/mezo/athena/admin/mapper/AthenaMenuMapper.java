package com.mezo.athena.admin.mapper;

import com.mezo.athena.admin.demain.AthenaMenu;

public interface AthenaMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaMenu record);

    int insertSelective(AthenaMenu record);

    AthenaMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AthenaMenu record);

    int updateByPrimaryKey(AthenaMenu record);
}