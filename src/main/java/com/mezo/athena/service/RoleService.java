package com.mezo.athena.service;

import com.mezo.athena.demain.AthenaRole;
import com.mezo.athena.demain.AthenaUserRole;

/**
 * 角色类
 */
public interface RoleService {

    AthenaUserRole selectRoleByUserId(String userId);

    AthenaRole selectRoleById(String roleId);
}
