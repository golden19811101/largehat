package com.largehat.admin.modules.system.service;

import com.largehat.admin.modules.system.domain.SysDept;
import com.largehat.admin.modules.system.service.dto.SysDeptDTO;
import com.largehat.admin.modules.system.service.dto.SysDeptQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Set;

/**
* @author Lion
* @date 2019-03-25
*/
@CacheConfig(cacheNames = "dept")
public interface SysDeptService {

    /**
     * queryAll
     * @param criteria
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    List<SysDeptDTO> queryAll(SysDeptQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SysDeptDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    SysDeptDTO create(SysDept resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(SysDept resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * buildTree
     * @param deptDTOS
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    Object buildTree(List<SysDeptDTO> deptDTOS);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    List<SysDept> findByPid(long pid);

    Set<SysDept> findByRoleIds(Long id);
}