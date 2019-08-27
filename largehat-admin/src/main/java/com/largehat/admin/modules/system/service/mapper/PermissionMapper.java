package com.largehat.admin.modules.system.service.mapper;

import com.largehat.common.core.mapper.EntityMapper;
import com.largehat.admin.modules.system.domain.Permission;
import com.largehat.admin.modules.system.service.dto.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
