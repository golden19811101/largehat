package com.largehat.service.modules.log.mapper;


import com.largehat.api.modules.log.domain.SysLog;
import com.largehat.api.modules.log.dto.LogSmallDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends EntityMapper<LogSmallDTO, SysLog> {

}