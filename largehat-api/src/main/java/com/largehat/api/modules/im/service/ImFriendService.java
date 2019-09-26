package com.largehat.api.modules.im.service;





import com.largehat.api.modules.im.domain.ImFriend;
import com.largehat.api.modules.im.dto.ImFriendDTO;
import com.largehat.api.modules.im.dto.ImFriendQueryCriteria;
import org.springframework.data.domain.Pageable;


/**
* @author
* @date 2019-09-18
*/
public interface ImFriendService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    Object queryAll(ImFriendQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    public Object queryAll(ImFriendQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    ImFriendDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    ImFriendDTO create(ImFriend resources);

    /**
     * update
     * @param resources
     */
    void update(ImFriend resources);

    /**
     * delete
     * @param id
     */
    void delete(Integer id);
}