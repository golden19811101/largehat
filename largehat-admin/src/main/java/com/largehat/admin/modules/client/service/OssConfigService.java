package com.largehat.admin.modules.client.service;

import com.largehat.admin.modules.client.domain.OssConfig;
import com.largehat.admin.modules.client.service.dto.OssConfigDTO;
import com.largehat.admin.modules.client.service.dto.OssConfigQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author kafe
* @date 2019-09-12
*/
@CacheConfig(cacheNames = "oss")
public interface OssConfigService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    OssConfigDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    OssConfigDTO create(OssConfig resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(OssConfig resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * queryAll
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(OssConfigQueryCriteria criteria, Pageable pageable);
}