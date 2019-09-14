package com.largehat.admin.modules.system.service.mapper;

import com.largehat.common.core.mapper.EntityMapper;
import com.largehat.admin.modules.system.domain.SysUser;
import com.largehat.admin.modules.system.service.dto.SysUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",uses = {SysRoleMapper.class, SysDeptMapper.class, SysJobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysUserMapper extends EntityMapper<SysUserDTO, SysUser> {

}
