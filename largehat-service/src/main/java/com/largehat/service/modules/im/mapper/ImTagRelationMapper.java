package com.largehat.service.modules.im.mapper;


import com.largehat.api.modules.im.domain.ImTagRelation;
import com.largehat.api.modules.im.dto.ImTagRelationDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author
* @date 2019-09-18
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImTagRelationMapper extends EntityMapper<ImTagRelationDTO, ImTagRelation> {

}