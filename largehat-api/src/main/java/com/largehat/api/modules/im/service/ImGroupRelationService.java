package com.largehat.api.modules.im.service;



import com.largehat.api.modules.im.domain.ImGroupRelation;
import com.largehat.api.modules.im.dto.ImGroupRelationDTO;
import com.largehat.api.modules.im.dto.ImGroupRelationQueryCriteria;
import org.springframework.data.domain.Pageable;



/**
* @author
* @date 2019-09-18
*/
public interface ImGroupRelationService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImGroupRelationQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImGroupRelationQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    ImGroupRelationDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    ImGroupRelationDTO create(ImGroupRelation resources);

    /**
     * update
     * @param resources
     */
    void update(ImGroupRelation resources);

    /**
     * delete
     * @param id
     */
    void delete(Integer id);
}