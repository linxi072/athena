package com.mezo.athena.mapper;

import com.mezo.athena.demain.UserVO;
import org.springframework.data.repository.query.Param;

public interface UserMapper {

    UserVO queryOneByAccount(@Param("account") String account);
}
