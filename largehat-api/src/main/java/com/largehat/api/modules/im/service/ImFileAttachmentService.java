package com.largehat.api.modules.im.service;




import com.largehat.api.modules.im.domain.ImFileAttachment;
import com.largehat.api.modules.im.dto.ImFileAttachmentDTO;
import com.largehat.api.modules.im.dto.ImFileAttachmentQueryCriteria;
import org.springframework.data.domain.Pageable;



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