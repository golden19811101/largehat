package com.largehat.service.modules.system.service;


import com.largehat.service.modules.system.mapper.SysRoleMapper;
import com.largehat.service.modules.system.mapper.SysRoleSmallMapper;
import com.largehat.service.modules.system.repository.SysRoleRepository;
import com.largehat.api.modules.system.domain.SysMenu;
import com.largehat.api.modules.system.domain.SysRole;
import com.largehat.api.modules.system.dto.SysCommonQueryCriteria;
import com.largehat.api.modules.system.dto.SysRoleDTO;
import com.largehat.api.modules.system.dto.SysRoleSmallDTO;
import com.largehat.api.modules.system.service.SysRoleService;
import com.largehat.common.core.exception.EntityExistException;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Lion
 * @date 2018-12-03
 */
@Service
@org.apache.dubbo.config.annotation.Service(
        interfaceClass = SysRoleService.class,
        timeout = 30000,
        version = "${api.service.version}")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository roleRepository;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleSmallMapper roleSmallMapper;

    @Override
    public Object queryAll(Pageable pageable) {
        return roleMapper.toDto(roleRepository.findAll(pageable).getContent());
    }

    @Override
    public Object queryAll(SysCommonQueryCriteria criteria, Pageable pageable) {
        Page<SysRole> page = roleRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(roleMapper::toDto));
    }

    @Override
    public SysRoleDTO findById(long id) {
        Optional<SysRole> role = roleRepository.findById(id);
        ValidationUtil.isNull(role,"Role","id",id);
        return roleMapper.toDto(role.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRoleDTO create(SysRole resources) {
        if(roleRepository.findByName(resources.getName()) != null){
            throw new EntityExistException(SysRole.class,"username",resources.getName());
        }
        return roleMapper.toDto(roleRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRole resources) {

        Optional<SysRole> optionalRole = roleRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalRole,"Role","id",resources.getId());

        SysRole role = optionalRole.get();

        SysRole role1 = roleRepository.findByName(resources.getName());

        if(role1 != null && !role1.getId().equals(role.getId())){
            throw new EntityExistException(SysRole.class,"username",resources.getName());
        }

        role.setName(resources.getName());
        role.setRemark(resources.getRemark());
        role.setDataScope(resources.getDataScope());
        role.setDepts(resources.getDepts());
        role.setLevel(resources.getLevel());
        roleRepository.save(role);
    }

    @Override
    public void updatePermission(SysRole resources, SysRoleDTO roleDTO) {
        SysRole role = roleMapper.toEntity(roleDTO);
        role.setPermissions(resources.getPermissions());
        roleRepository.save(role);
    }

    @Override
    public void updateMenu(SysRole resources, SysRoleDTO roleDTO) {
        SysRole role = roleMapper.toEntity(roleDTO);
        role.setMenus(resources.getMenus());
        roleRepository.save(role);
    }

    @Override
    public void untiedMenu(SysMenu menu) {
        Set<SysRole> roles = roleRepository.findByMenus_Id(menu.getId());
        for (SysRole role : roles) {
            menu.getRoles().remove(role);
            role.getMenus().remove(menu);
            roleRepository.save(role);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<SysRoleSmallDTO> findByUsers_Id(Long id) {
        return roleSmallMapper.toDto(roleRepository.findByUsers_Id(id).stream().collect(Collectors.toList()));
    }

    @Override
    public Integer findByRoles(Set<SysRole> roles) {
        Set<SysRoleDTO> roleDTOS = new HashSet<>();
        for (SysRole role : roles) {
            roleDTOS.add(findById(role.getId()));
        }
        return Collections.min(roleDTOS.stream().map(SysRoleDTO::getLevel).collect(Collectors.toList()));
    }
}
