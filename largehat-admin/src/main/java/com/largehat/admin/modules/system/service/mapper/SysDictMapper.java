package com.largehat.admin.modules.system.service.mapper;

import com.largehat.admin.modules.system.service.dto.SysDictDTO;
import com.largehat.common.core.mapper.EntityMapper;
import com.largehat.admin.modules.system.domain.SysDict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDictMapper extends EntityMapper<SysDictDTO, SysDict> {

}