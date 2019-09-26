package com.largehat.api.modules.system.service;


import com.largehat.api.modules.system.domain.SysJob;
import com.largehat.api.modules.system.dto.SysJobDTO;
import com.largehat.api.modules.system.dto.SysJobQueryCriteria;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author Lion
* @date 2019-03-29
*/
public interface SysJobService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SysJobDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    SysJobDTO create(SysJob resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(SysJob resources);

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
    Object queryAll(SysJobQueryCriteria criteria, Pageable pageable);
}