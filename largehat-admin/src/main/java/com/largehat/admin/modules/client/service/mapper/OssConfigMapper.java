package com.largehat.admin.modules.client.service.mapper;

import com.largehat.admin.modules.client.domain.OssConfig;
import com.largehat.admin.modules.client.service.dto.OssConfigDTO;

import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author kafe
* @date 2019-09-12
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OssConfigMapper extends EntityMapper<OssConfigDTO, OssConfig> {

}