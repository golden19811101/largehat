package com.largehat.admin.modules.im.service;


import com.largehat.admin.modules.im.domain.ImGroup;
import com.largehat.admin.modules.im.service.dto.ImGroupDTO;
import com.largehat.admin.modules.im.service.dto.ImGroupQueryCriteria;
import org.springframework.data.domain.Pageable;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author
* @date 2019-09-18
*/
//@CacheConfig(cacheNames = "imGroup")
public interface ImGroupService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ImGroupQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ImGroupQueryCriteria criteria);

    /**
     * findById
     * @param groupId
     * @return
     */
    //@Cacheable(key = "#p0")
    ImGroupDTO findById(Integer groupId);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ImGroupDTO create(ImGroup resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(ImGroup resources);

    /**
     * delete
     * @param groupId
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer groupId);
}