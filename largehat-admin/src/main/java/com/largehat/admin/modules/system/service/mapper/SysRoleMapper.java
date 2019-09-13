package com.largehat.admin.modules.system.service.mapper;

import com.largehat.admin.modules.system.service.dto.SysRoleDTO;
import com.largehat.common.core.mapper.EntityMapper;
import com.largehat.admin.modules.system.domain.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {SysPermissionMapper.class, SysMenuMapper.class, SysDeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysRoleMapper extends EntityMapper<SysRoleDTO, SysRole> {

}
