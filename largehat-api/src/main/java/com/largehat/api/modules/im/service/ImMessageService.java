package com.largehat.api.modules.im.service;



import com.largehat.api.modules.im.domain.ImMessage;
import com.largehat.api.modules.im.dto.ImMessageDTO;
import com.largehat.api.modules.im.dto.ImMessageQueryCriteria;
import org.springframework.data.domain.Pageable;



/**
* @author
* @date 2019-09-18
*/
public interface ImMessageService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImMessageQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImMessageQueryCriteria criteria);

    /**
     * findById
     * @param messageId
     * @return
     */
    ImMessageDTO findById(Long messageId);

    /**
     * create
     * @param resources
     * @return
     */
    ImMessageDTO create(ImMessage resources);

    /**
     * update
     * @param resources
     */
    void update(ImMessage resources);

    /**
     * delete
     * @param messageId
     */
    void delete(Long messageId);
}