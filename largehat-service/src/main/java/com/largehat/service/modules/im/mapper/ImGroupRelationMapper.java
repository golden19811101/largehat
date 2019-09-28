package com.largehat.service.modules.im.mapper;



import com.largehat.api.modules.im.domain.ImGroupRelation;
import com.largehat.api.modules.im.dto.ImGroupRelationDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author
* @date 2019-09-18
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImGroupRelationMapper extends EntityMapper<ImGroupRelationDTO, ImGroupRelation> {

}