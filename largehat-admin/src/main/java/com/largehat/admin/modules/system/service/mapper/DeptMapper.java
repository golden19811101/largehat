package com.largehat.admin.modules.system.service.mapper;

import com.largehat.web.mapper.EntityMapper;
import com.largehat.admin.modules.system.domain.Dept;
import com.largehat.admin.modules.system.service.dto.DeptDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends EntityMapper<DeptDTO, Dept> {

}