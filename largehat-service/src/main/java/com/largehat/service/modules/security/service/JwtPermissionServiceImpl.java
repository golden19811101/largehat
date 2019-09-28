package com.largehat.service.modules.security.service;


import com.largehat.service.modules.system.repository.SysRoleRepository;
import com.largehat.api.modules.quartz.service.JwtPermissionService;
import com.largehat.api.modules.system.domain.SysRole;
import com.largehat.api.modules.system.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@org.apache.dubbo.config.annotation.Service(
        timeout = 30000,
        version = "${api.service.version}")
@CacheConfig(cacheNames = "role")
public class JwtPermissionServiceImpl implements JwtPermissionService {

    @Autowired
    private SysRoleRepository roleRepository;

    /**
     * key的名称如有修改，请同步修改 UserServiceImpl 中的 update 方法
     * @param user
     * @return
     */
    @Override
    @Cacheable(key = "'loadPermissionByUser:' + #p0.username")
    public Collection<GrantedAuthority> mapToGrantedAuthorities(SysUserDTO user) {
        Set<SysRole> roles = roleRepository.findByUsers_Id(user.getId());

        return roles.stream().flatMap(role -> role.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());
    }
}
