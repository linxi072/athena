package com.mezo.athena.admin.mapper;

import com.mezo.athena.admin.demain.AthenaUserOrgan;

public interface AthenaUserOrganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaUserOrgan record);

    int insertSelective(AthenaUserOrgan record);

    AthenaUserOrgan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AthenaUserOrgan record);

    int updateByPrimaryKey(AthenaUserOrgan record);
}