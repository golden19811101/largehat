package com.largehat.api.modules.im.service;



import com.largehat.api.modules.im.domain.ImTagGroup;
import com.largehat.api.modules.im.dto.ImTagGroupDTO;
import com.largehat.api.modules.im.dto.ImTagGroupQueryCriteria;
import org.springframework.data.domain.Pageable;


/**
* @author
* @date 2019-09-18
*/
public interface ImTagGroupService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImTagGroupQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImTagGroupQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    ImTagGroupDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    ImTagGroupDTO create(ImTagGroup resources);

    /**
     * update
     * @param resources
     */
    void update(ImTagGroup resources);

    /**
     * delete
     * @param id
     */
    void delete(Integer id);
}