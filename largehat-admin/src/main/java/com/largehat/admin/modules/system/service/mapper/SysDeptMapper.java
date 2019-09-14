package com.largehat.admin.modules.system.service.mapper;

import com.largehat.admin.modules.system.domain.SysDept;
import com.largehat.common.core.mapper.EntityMapper;
import com.largehat.admin.modules.system.service.dto.SysDeptDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDeptMapper extends EntityMapper<SysDeptDTO, SysDept> {

}