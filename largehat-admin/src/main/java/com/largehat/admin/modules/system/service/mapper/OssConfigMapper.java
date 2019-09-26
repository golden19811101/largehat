package com.largehat.admin.modules.system.service.mapper;


import com.largehat.api.modules.system.domain.OssConfig;
import com.largehat.api.modules.system.dto.OssConfigDTO;
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