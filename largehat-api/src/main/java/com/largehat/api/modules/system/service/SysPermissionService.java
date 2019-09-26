package com.largehat.api.modules.system.service;


import com.largehat.api.modules.system.domain.SysPermission;
import com.largehat.api.modules.system.dto.SysCommonQueryCriteria;
import com.largehat.api.modules.system.dto.SysPermissionDTO;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

/**
 * @author Lion
 * @date 2018-12-08
 */
public interface SysPermissionService {

    /**
     * get
     * @param id
     * @return
     */
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
    void update(SysPermission resources);

    /**
     * delete
     * @param id
     */
    void delete(Long id);

    /**
     * permission tree
     * @return
     */
    Object getPermissionTree(List<SysPermission> permissions);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<SysPermission> findByPid(long pid);

    /**
     * build Tree
     * @param permissionDTOS
     * @return
     */
    Object buildTree(List<SysPermissionDTO> permissionDTOS);

    /**
     * queryAll
     * @param criteria
     * @return
     */
    List<SysPermissionDTO> queryAll(SysCommonQueryCriteria criteria);
}
