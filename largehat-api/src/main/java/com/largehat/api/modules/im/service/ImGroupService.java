package com.largehat.api.modules.im.service;



import com.largehat.api.modules.im.domain.ImGroup;
import com.largehat.api.modules.im.dto.ImGroupDTO;
import com.largehat.api.modules.im.dto.ImGroupQueryCriteria;
import org.springframework.data.domain.Pageable;



/**
* @author
* @date 2019-09-18
*/
public interface ImGroupService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImGroupQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImGroupQueryCriteria criteria);

    /**
     * findById
     * @param groupId
     * @return
     */
    ImGroupDTO findById(Integer groupId);

    /**
     * create
     * @param resources
     * @return
     */
    ImGroupDTO create(ImGroup resources);

    /**
     * update
     * @param resources
     */
    void update(ImGroup resources);

    /**
     * delete
     * @param groupId
     */
    void delete(Integer groupId);
}