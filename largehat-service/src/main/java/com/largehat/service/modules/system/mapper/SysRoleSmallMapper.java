package com.largehat.service.modules.system.mapper;

import com.largehat.api.modules.system.domain.SysRole;
import com.largehat.api.modules.system.dto.SysRoleSmallDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2019-5-23
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysRoleSmallMapper extends EntityMapper<SysRoleSmallDTO, SysRole> {

}
