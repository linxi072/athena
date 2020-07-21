package com.mezo.athena.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mezo.athena.dao.SysUserRoleDao;
import com.mezo.athena.entity.SysUserRoleEntity;
import com.mezo.athena.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 用户与角色业务实现
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

}