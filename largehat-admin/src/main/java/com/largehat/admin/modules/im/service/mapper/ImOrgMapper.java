package com.largehat.admin.modules.im.service.mapper;


import com.largehat.admin.modules.im.domain.ImOrg;
import com.largehat.admin.modules.im.service.dto.ImOrgDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author
* @date 2019-09-18
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImOrgMapper extends EntityMapper<ImOrgDTO, ImOrg> {

}