package com.largehat.api.modules.system.service;


import com.largehat.api.modules.system.domain.SysMenu;
import com.largehat.api.modules.system.dto.SysCommonQueryCriteria;
import com.largehat.api.modules.system.dto.SysMenuDTO;
import com.largehat.api.modules.system.dto.SysRoleSmallDTO;

import java.util.List;
import java.util.Map;

/**
 * @author Lion
 * @date 2018-12-17
 */
public interface SysMenuService {

    /**
     * queryAll
     * @param criteria
     * @return
     */
    List<SysMenuDTO> queryAll(SysCommonQueryCriteria criteria);

    /**
     * get
     * @param id
     * @return
     */
    SysMenuDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    SysMenuDTO create(SysMenu resources);

    /**
     * update
     * @param resources
     */
    void update(SysMenu resources);

    /**
     * delete
     * @param id
     */
    void delete(Long id);

    /**
     * permission tree
     * @return
     */
    Object getMenuTree(List<SysMenu> menus);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<SysMenu> findByPid(long pid);

    /**
     * build Tree
     * @param menuDTOS
     * @return
     */
    Map buildTree(List<SysMenuDTO> menuDTOS);

    /**
     * findByRoles
     * @param roles
     * @return
     */
    List<SysMenuDTO> findByRoles(List<SysRoleSmallDTO> roles);

    /**
     * buildMenus
     * @param byRoles
     * @return
     */
    Object buildMenus(List<SysMenuDTO> byRoles);

    SysMenu findOne(Long id);
}
