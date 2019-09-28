package com.largehat.service.modules.system.mapper;


import com.largehat.api.modules.system.domain.SysDict;
import com.largehat.api.modules.system.dto.SysDictDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDictMapper extends EntityMapper<SysDictDTO, SysDict> {

}