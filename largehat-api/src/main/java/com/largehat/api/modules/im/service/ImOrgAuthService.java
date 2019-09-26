package com.largehat.api.modules.im.service;



import com.largehat.api.modules.im.domain.ImOrgAuth;
import com.largehat.api.modules.im.dto.ImOrgAuthDTO;
import com.largehat.api.modules.im.dto.ImOrgAuthQueryCriteria;
import org.springframework.data.domain.Pageable;



/**
* @author
* @date 2019-09-18
*/
public interface ImOrgAuthService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImOrgAuthQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImOrgAuthQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    ImOrgAuthDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    ImOrgAuthDTO create(ImOrgAuth resources);

    /**
     * update
     * @param resources
     */
    void update(ImOrgAuth resources);

    /**
     * delete
     * @param id
     */
    void delete(Integer id);
}