package com.largehat.admin.modules.system.service.mapper;

import com.largehat.common.core.mapper.EntityMapper;
import com.largehat.admin.modules.system.domain.Job;
import com.largehat.admin.modules.system.service.dto.JobSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends EntityMapper<JobSmallDTO, Job> {

}