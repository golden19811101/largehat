package com.largehat.api.modules.quartz.service;

import com.largehat.api.modules.system.dto.SysUserDTO;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public interface JwtPermissionService {

     Collection<GrantedAuthority> mapToGrantedAuthorities(SysUserDTO user);

}
