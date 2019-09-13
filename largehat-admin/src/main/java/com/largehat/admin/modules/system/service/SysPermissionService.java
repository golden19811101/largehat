package com.largehat.admin.modules.system.service;

import com.largehat.admin.modules.system.domain.SysPermission;
import com.largehat.admin.modules.system.service.dto.SysCommonQueryCriteria;
import com.largehat.admin.modules.system.service.dto.SysPermissionDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author Lion
 * @date 2018-12-08
 */
@CacheConfig(cacheNames = "permission")
public interface SysPermissionService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SysPermissionDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    SysPermissionDTO create(SysPermission resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(SysPermission resources);

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
    Object getPermissionTree(List<SysPermission> permissions);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'pid:'+#p0")
    List<SysPermission> findByPid(long pid);

    /**
     * build Tree
     * @param permissionDTOS
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    Object buildTree(List<SysPermissionDTO> permissionDTOS);

    /**
     * queryAll
     * @param criteria
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    List<SysPermissionDTO> queryAll(SysCommonQueryCriteria criteria);
}
