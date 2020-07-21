package com.mezo.athena.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
/**
 * @Description 权限实体
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    @TableId
    private Long menuId;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限标识
     */
    private String perms;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}

