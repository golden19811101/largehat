package com.largehat.service.modules.system.mapper;


import com.largehat.api.modules.system.domain.SysDept;
import com.largehat.api.modules.system.dto.SysDeptSmallDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDeptSmallMapper extends EntityMapper<SysDeptSmallDTO, SysDept> {

}