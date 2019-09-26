package com.largehat.api.modules.im.service;


import com.largehat.api.modules.im.domain.ImUserInfo;
import com.largehat.api.modules.im.dto.ImUserInfoDTO;
import com.largehat.api.modules.im.dto.ImUserInfoQueryCriteria;
import org.springframework.data.domain.Pageable;


/**
* @author
* @date 2019-09-18
*/
public interface ImUserInfoService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImUserInfoQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImUserInfoQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    ImUserInfoDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    ImUserInfoDTO create(ImUserInfo resources);

    /**
     * update
     * @param resources
     */
    void update(ImUserInfo resources);

    /**
     * delete
     * @param id
     */
    void delete(Integer id);
}