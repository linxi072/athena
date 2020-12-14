package com.mezo.athena.mapper;

import com.mezo.athena.demain.AthenaUserOrgan;

public interface AthenaUserOrganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AthenaUserOrgan record);

    int insertSelective(AthenaUserOrgan record);

    AthenaUserOrgan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AthenaUserOrgan record);

    int updateByPrimaryKey(AthenaUserOrgan record);
}