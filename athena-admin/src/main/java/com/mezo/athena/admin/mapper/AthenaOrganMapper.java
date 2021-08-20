package com.mezo.athena.admin.mapper;

import com.mezo.athena.admin.demain.AthenaOrgan;

public interface AthenaOrganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaOrgan record);

    int insertSelective(AthenaOrgan record);

    AthenaOrgan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AthenaOrgan record);

    int updateByPrimaryKey(AthenaOrgan record);
}