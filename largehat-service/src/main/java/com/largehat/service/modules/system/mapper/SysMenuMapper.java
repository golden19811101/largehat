package com.largehat.service.modules.system.mapper;

import com.largehat.api.modules.system.domain.SysMenu;
import com.largehat.api.modules.system.dto.SysMenuDTO;
import com.largehat.common.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Lion
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysMenuMapper extends EntityMapper<SysMenuDTO, SysMenu> {

}
