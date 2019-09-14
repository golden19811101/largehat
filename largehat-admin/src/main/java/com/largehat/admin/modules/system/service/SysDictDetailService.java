package com.largehat.admin.modules.system.service;

import com.largehat.admin.modules.system.domain.SysDictDetail;
import com.largehat.admin.modules.system.service.dto.SysDictDetailDTO;
import com.largehat.admin.modules.system.service.dto.SysDictDetailQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
* @author Lion
* @date 2019-04-10
*/
@CacheConfig(cacheNames = "dictDetail")
public interface SysDictDetailService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SysDictDetailDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    SysDictDetailDTO create(SysDictDetail resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(SysDictDetail resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    @Cacheable(keyGenerator = "keyGenerator")
    Map queryAll(SysDictDetailQueryCriteria criteria, Pageable pageable);
}