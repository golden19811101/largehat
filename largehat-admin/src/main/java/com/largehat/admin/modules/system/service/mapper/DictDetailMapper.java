package com.largehat.admin.modules.system.service.mapper;

import com.largehat.common.core.mapper.EntityMapper;
import com.largehat.admin.modules.system.domain.DictDetail;
import com.largehat.admin.modules.system.service.dto.DictDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends EntityMapper<DictDetailDTO, DictDetail> {

}