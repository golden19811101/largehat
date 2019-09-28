package com.largehat.service.modules.system.mapper;


import com.largehat.api.modules.system.domain.SysJob;
import com.largehat.api.modules.system.dto.SysJobSmallDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysJobSmallMapper extends EntityMapper<SysJobSmallDTO, SysJob> {

}