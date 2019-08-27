package com.largehat.admin.modules.system.service.mapper;

import com.largehat.common.core.mapper.EntityMapper;
import com.largehat.admin.modules.system.domain.Role;
import com.largehat.admin.modules.system.service.dto.RoleSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2019-5-23
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends EntityMapper<RoleSmallDTO, Role> {

}
