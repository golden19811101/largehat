package com.largehat.admin.modules.system.service.mapper;

import com.largehat.api.modules.system.domain.SysPermission;
import com.largehat.api.modules.system.dto.SysPermissionDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysPermissionMapper extends EntityMapper<SysPermissionDTO, SysPermission> {

}
