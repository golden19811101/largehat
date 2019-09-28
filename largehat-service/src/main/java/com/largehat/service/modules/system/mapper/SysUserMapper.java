package com.largehat.service.modules.system.mapper;

import com.largehat.api.modules.system.domain.SysUser;
import com.largehat.api.modules.system.dto.SysUserDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",uses = {SysRoleMapper.class, SysDeptMapper.class, SysJobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysUserMapper extends EntityMapper<SysUserDTO, SysUser> {

}
