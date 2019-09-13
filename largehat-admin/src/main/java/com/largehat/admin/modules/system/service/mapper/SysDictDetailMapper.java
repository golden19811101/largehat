package com.largehat.admin.modules.system.service.mapper;

import com.largehat.admin.modules.system.domain.SysDictDetail;
import com.largehat.admin.modules.system.service.dto.SysDictDetailDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDictDetailMapper extends EntityMapper<SysDictDetailDTO, SysDictDetail> {

}