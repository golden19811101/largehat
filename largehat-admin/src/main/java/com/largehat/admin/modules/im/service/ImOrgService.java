package com.largehat.admin.modules.im.service;


import com.largehat.admin.modules.im.domain.ImOrg;
import com.largehat.admin.modules.im.service.dto.ImOrgDTO;
import com.largehat.admin.modules.im.service.dto.ImOrgQueryCriteria;
import org.springframework.data.domain.Pageable;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author
* @date 2019-09-18
*/
//@CacheConfig(cacheNames = "imOrg")
public interface ImOrgService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ImOrgQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ImOrgQueryCriteria criteria);

    /**
     * findById
     * @param orgId
     * @return
     */
    //@Cacheable(key = "#p0")
    ImOrgDTO findById(Integer orgId);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ImOrgDTO create(ImOrg resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(ImOrg resources);

    /**
     * delete
     * @param orgId
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer orgId);
}