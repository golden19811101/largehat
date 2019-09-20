package com.largehat.admin.modules.im.service;


import com.largehat.admin.modules.im.domain.ImMessage;
import com.largehat.admin.modules.im.service.dto.ImMessageDTO;
import com.largehat.admin.modules.im.service.dto.ImMessageQueryCriteria;
import org.springframework.data.domain.Pageable;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author
* @date 2019-09-18
*/
//@CacheConfig(cacheNames = "imMessage")
public interface ImMessageService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ImMessageQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ImMessageQueryCriteria criteria);

    /**
     * findById
     * @param messageId
     * @return
     */
    //@Cacheable(key = "#p0")
    ImMessageDTO findById(Long messageId);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ImMessageDTO create(ImMessage resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(ImMessage resources);

    /**
     * delete
     * @param messageId
     */
    //@CacheEvict(allEntries = true)
    void delete(Long messageId);
}