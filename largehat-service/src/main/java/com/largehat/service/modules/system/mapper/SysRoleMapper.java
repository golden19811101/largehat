package com.largehat.service.modules.system.mapper;


import com.largehat.api.modules.system.domain.SysRole;
import com.largehat.api.modules.system.dto.SysRoleDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {SysPermissionMapper.class, SysMenuMapper.class, SysDeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysRoleMapper extends EntityMapper<SysRoleDTO, SysRole> {

}
