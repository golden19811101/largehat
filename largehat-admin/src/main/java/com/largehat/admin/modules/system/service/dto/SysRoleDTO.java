package com.largehat.admin.modules.system.service.dto;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Data
public class SysRoleDTO implements Serializable {

    private Long id;

    private String name;

    private String dataScope;

    private Integer level;

    private String remark;

    private Set<SysPermissionDTO> permissions;

    private Set<SysMenuDTO> menus;

    private Set<SysDeptDTO> depts;

    private Timestamp createTime;
}
