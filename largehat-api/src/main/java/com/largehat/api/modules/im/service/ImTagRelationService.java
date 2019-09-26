package com.largehat.api.modules.im.service;



import com.largehat.api.modules.im.domain.ImTagRelation;
import com.largehat.api.modules.im.dto.ImTagRelationDTO;
import com.largehat.api.modules.im.dto.ImTagRelationQueryCriteria;
import org.springframework.data.domain.Pageable;



/**
* @author
* @date 2019-09-18
*/
public interface ImTagRelationService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImTagRelationQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImTagRelationQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    ImTagRelationDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    ImTagRelationDTO create(ImTagRelation resources);

    /**
     * update
     * @param resources
     */
    void update(ImTagRelation resources);

    /**
     * delete
     * @param id
     */
    void delete(Integer id);
}