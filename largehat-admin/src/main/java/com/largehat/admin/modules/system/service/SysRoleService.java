package com.largehat.admin.modules.system.service;

import com.largehat.admin.modules.system.domain.SysMenu;
import com.largehat.admin.modules.system.domain.SysRole;
import com.largehat.admin.modules.system.service.dto.SysCommonQueryCriteria;
import com.largehat.admin.modules.system.service.dto.SysRoleDTO;
import com.largehat.admin.modules.system.service.dto.SysRoleSmallDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 * @author Lion
 * @date 2018-12-03
 */
@CacheConfig(cacheNames = "role")
public interface SysRoleService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SysRoleDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    SysRoleDTO create(SysRole resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(SysRole resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * key的名称如有修改，请同步修改 UserServiceImpl 中的 update 方法
     * findByUsers_Id
     * @param id
     * @return
     */
    @Cacheable(key = "'findByUsers_Id:' + #p0")
    List<SysRoleSmallDTO> findByUsers_Id(Long id);

    @Cacheable(keyGenerator = "keyGenerator")
    Integer findByRoles(Set<SysRole> roles);

    /**
     * updatePermission
     * @param resources
     * @param roleDTO
     */
    @CacheEvict(allEntries = true)
    void updatePermission(SysRole resources, SysRoleDTO roleDTO);

    /**
     * updateMenu
     * @param resources
     * @param roleDTO
     */
    @CacheEvict(allEntries = true)
    void updateMenu(SysRole resources, SysRoleDTO roleDTO);

    @CacheEvict(allEntries = true)
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
