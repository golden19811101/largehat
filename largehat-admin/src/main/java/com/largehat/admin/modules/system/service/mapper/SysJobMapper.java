package com.largehat.admin.modules.system.service.mapper;


import com.largehat.api.modules.system.domain.SysJob;
import com.largehat.api.modules.system.dto.SysJobDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
* @author Lion
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {SysDeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysJobMapper extends EntityMapper<SysJobDTO, SysJob> {

    @Mapping(source = "deptSuperiorName", target = "deptSuperiorName")
    SysJobDTO toDto(SysJob job, String deptSuperiorName);
}