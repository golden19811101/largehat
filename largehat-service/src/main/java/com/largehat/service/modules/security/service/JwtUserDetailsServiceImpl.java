package com.largehat.service.modules.security.service;


import com.largehat.api.modules.quartz.service.JwtUserDetailsService;
import com.largehat.api.modules.security.domain.JwtUser;
import com.largehat.api.modules.system.dto.SysDeptSmallDTO;
import com.largehat.api.modules.system.dto.SysJobSmallDTO;
import com.largehat.api.modules.system.dto.SysUserDTO;
import com.largehat.api.modules.system.service.SysUserService;
import com.largehat.common.core.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Lion
 * @date 2018-11-22
 */
@Service
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = UserDetailsService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

    @Autowired
    private SysUserService userService;

    @Autowired
    private JwtPermissionServiceImpl permissionService;

    @Override
    public UserDetails loadUserByUsername(String username){
        SysUserDTO user = userService.findByName(username);
        if (user == null) {
            throw new BadRequestException("账号不存在");
        } else {
            return createJwtUser(user);
        }
    }

    public UserDetails createJwtUser(SysUserDTO user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAvatar(),
                user.getEmail(),
                user.getPhone(),
                Optional.ofNullable(user.getDept()).map(SysDeptSmallDTO::getName).orElse(null),
                Optional.ofNullable(user.getJob()).map(SysJobSmallDTO::getName).orElse(null),
                permissionService.mapToGrantedAuthorities(user),
                user.getEnabled(),
                user.getCreateTime(),
                user.getLastPasswordResetTime()
        );
    }
}
