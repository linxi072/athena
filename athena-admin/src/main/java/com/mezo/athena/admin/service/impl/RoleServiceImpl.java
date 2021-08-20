package com.mezo.athena.admin.service.impl;

import com.mezo.athena.admin.demain.AthenaRole;
import com.mezo.athena.admin.demain.AthenaUserRole;
import com.mezo.athena.admin.mapper.AthenaRoleMapper;
import com.mezo.athena.admin.mapper.AthenaUserRoleMapper;
import com.mezo.athena.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private AthenaRoleMapper athenaRoleMapper;
    @Autowired(required = false)
    private AthenaUserRoleMapper athenaUserRoleMapper;

    @Override
    public AthenaUserRole selectRoleByUserId(String userId) {
        return athenaUserRoleMapper.selectRoleByUserId(userId);
    }

    @Override
    public AthenaRole selectRoleById(String roleId) {
        return athenaRoleMapper.selectByRoleId(roleId);
    }
}
