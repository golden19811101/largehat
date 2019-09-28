package com.largehat.service.modules.im.mapper;



import com.largehat.api.modules.im.domain.ImOrgAuth;
import com.largehat.api.modules.im.dto.ImOrgAuthDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author
* @date 2019-09-18
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImOrgAuthMapper extends EntityMapper<ImOrgAuthDTO, ImOrgAuth> {

}