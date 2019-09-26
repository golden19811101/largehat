package com.largehat.api.modules.im.service;


import com.largehat.api.modules.im.domain.ImOrg;
import com.largehat.api.modules.im.dto.ImOrgDTO;
import com.largehat.api.modules.im.dto.ImOrgQueryCriteria;
import org.springframework.data.domain.Pageable;



/**
* @author
* @date 2019-09-18
*/
public interface ImOrgService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImOrgQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImOrgQueryCriteria criteria);

    /**
     * findById
     * @param orgId
     * @return
     */
    ImOrgDTO findById(Integer orgId);

    /**
     * create
     * @param resources
     * @return
     */
    ImOrgDTO create(ImOrg resources);

    /**
     * update
     * @param resources
     */
    void update(ImOrg resources);

    /**
     * delete
     * @param orgId
     */
    void delete(Integer orgId);
}