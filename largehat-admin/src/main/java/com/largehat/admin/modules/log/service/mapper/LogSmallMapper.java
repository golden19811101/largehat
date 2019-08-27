package com.largehat.admin.modules.log.service.mapper;


import com.largehat.common.core.mapper.EntityMapper;

import com.largehat.admin.modules.log.domain.Log;
import com.largehat.admin.modules.log.service.dto.LogSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends EntityMapper<LogSmallDTO, Log> {

}