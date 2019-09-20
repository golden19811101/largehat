package com.largehat.admin.modules.im.service;



import com.largehat.admin.modules.im.domain.ImFileAttachment;
import com.largehat.admin.modules.im.service.dto.ImFileAttachmentDTO;
import com.largehat.admin.modules.im.service.dto.ImFileAttachmentQueryCriteria;
import org.springframework.data.domain.Pageable;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author
* @date 2019-09-18
*/
//@CacheConfig(cacheNames = "imFileAttachment")
public interface ImFileAttachmentService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ImFileAttachmentQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ImFileAttachmentQueryCriteria criteria);

    /**
     * findById
     * @param fileId
     * @return
     */
    //@Cacheable(key = "#p0")
    ImFileAttachmentDTO findById(Integer fileId);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ImFileAttachmentDTO create(ImFileAttachment resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(ImFileAttachment resources);

    /**
     * delete
     * @param fileId
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer fileId);
}