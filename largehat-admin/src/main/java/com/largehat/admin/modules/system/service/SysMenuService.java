package com.largehat.admin.modules.system.service;

import com.largehat.admin.modules.system.domain.SysMenu;
import com.largehat.admin.modules.system.service.dto.SysCommonQueryCriteria;
import com.largehat.admin.modules.system.service.dto.SysMenuDTO;
import com.largehat.admin.modules.system.service.dto.SysRoleSmallDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;
import java.util.Map;

/**
 * @author Lion
 * @date 2018-12-17
 */
@CacheConfig(cacheNames = "menu")
public interface SysMenuService {

    /**
     * queryAll
     * @param criteria
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    List<SysMenuDTO> queryAll(SysCommonQueryCriteria criteria);

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SysMenuDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    SysMenuDTO create(SysMenu resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(SysMenu resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * permission tree
     * @return
     */
    @Cacheable(key = "'tree'")
    Object getMenuTree(List<SysMenu> menus);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'pid:'+#p0")
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
