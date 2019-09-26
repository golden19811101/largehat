package com.largehat.admin.modules.im.service.mapper;



import com.largehat.api.modules.im.domain.ImFriend;
import com.largehat.api.modules.im.dto.ImFriendDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author
* @date 2019-09-18
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImFriendMapper extends EntityMapper<ImFriendDTO, ImFriend> {

}