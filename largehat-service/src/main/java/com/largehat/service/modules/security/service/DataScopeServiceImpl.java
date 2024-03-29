package com.largehat.service.modules.security.service;

import com.largehat.api.modules.security.service.DataScopeService;
import com.largehat.api.modules.system.domain.SysDept;
import com.largehat.api.modules.system.dto.SysRoleSmallDTO;
import com.largehat.api.modules.system.dto.SysUserDTO;
import com.largehat.api.modules.system.service.SysDeptService;
import com.largehat.api.modules.system.service.SysRoleService;
import com.largehat.api.modules.system.service.SysUserService;
import com.largehat.common.core.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = DataScopeService.class,
        timeout = 30000,
        version = "${api.service.version}")
@CacheConfig(cacheNames = "role")
public class DataScopeServiceImpl implements DataScopeService {

    private final String[] scopeType = {"全部","本级","自定义"};

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysDeptService deptService;

    @Override
    public Set<Long> getDeptIds() {
        SysUserDTO user = userService.findByName(SecurityUtils.getUsername());
        // 用于存储部门id
        Set<Long> deptIds = new HashSet<>();
        // 查询用户角色
        List<SysRoleSmallDTO> roleSet = roleService.findByUsers_Id(user.getId());
        for (SysRoleSmallDTO role : roleSet) {
            if (scopeType[0].equals(role.getDataScope())) {
                return new HashSet<>() ;
            }

            // 存储本级的数据权限
            if (scopeType[1].equals(role.getDataScope())) {
                deptIds.add(user.getDept().getId());
            }

            // 存储自定义的数据权限
            if (scopeType[2].equals(role.getDataScope())) {
                Set<SysDept> depts = deptService.findByRoleIds(role.getId());
                for (SysDept dept : depts) {
                    deptIds.add(dept.getId());
                    List<SysDept> deptChildren = deptService.findByPid(dept.getId());
                    if (deptChildren != null && deptChildren.size() != 0) {
                        deptIds.addAll(getDeptChildren(deptChildren));
                    }
                }
            }
        }
        return deptIds;
    }


    @Override
    public List<Long> getDeptChildren(List<SysDept> deptList) {
        List<Long> list = new ArrayList<>();
        deptList.forEach(dept -> {
                    if (dept!=null && dept.getEnabled()){
                        List<SysDept> depts = deptService.findByPid(dept.getId());
                        if(deptList!=null && deptList.size()!=0){
                            list.addAll(getDeptChildren(depts));
                        }
                        list.add(dept.getId());
                    }
                }
        );
        return list;
    }
}
