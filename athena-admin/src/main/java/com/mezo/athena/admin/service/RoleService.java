package com.mezo.athena.admin.service;

import com.mezo.athena.admin.demain.AthenaRole;
import com.mezo.athena.admin.demain.AthenaUserRole;

/**
 * 角色类
 */
public interface RoleService {

    AthenaUserRole selectRoleByUserId(String userId);

    AthenaRole selectRoleById(String roleId);
}
