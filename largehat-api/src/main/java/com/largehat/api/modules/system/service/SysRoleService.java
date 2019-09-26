package com.largehat.api.modules.system.service;


import com.largehat.api.modules.system.domain.SysMenu;
import com.largehat.api.modules.system.domain.SysRole;
import com.largehat.api.modules.system.dto.SysCommonQueryCriteria;
import com.largehat.api.modules.system.dto.SysRoleDTO;
import com.largehat.api.modules.system.dto.SysRoleSmallDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 * @author Lion
 * @date 2018-12-03
 */
public interface SysRoleService {

    /**
     * get
     * @param id
     * @return
     */
    SysRoleDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    SysRoleDTO create(SysRole resources);

    /**
     * update
     * @param resources
     */
    void update(SysRole resources);

    /**
     * delete
     * @param id
     */
    void delete(Long id);

    /**
     * key的名称如有修改，请同步修改 UserServiceImpl 中的 update 方法
     * findByUsers_Id
     * @param id
     * @return
     */
    List<SysRoleSmallDTO> findByUsers_Id(Long id);



    Integer findByRoles(Set<SysRole> roles);

    /**
     * updatePermission
     * @param resources
     * @param roleDTO
     */
    void updatePermission(SysRole resources, SysRoleDTO roleDTO);

    /**
     * updateMenu
     * @param resources
     * @param roleDTO
     */
    void updateMenu(SysRole resources, SysRoleDTO roleDTO);



    void untiedMenu(SysMenu menu);

    /**
     * queryAll
     * @param pageable
     * @return
     */
    Object queryAll(Pageable pageable);

    /**
     * queryAll
     * @param pageable
     * @param criteria
     * @return
     */
    Object queryAll(SysCommonQueryCriteria criteria, Pageable pageable);
}
