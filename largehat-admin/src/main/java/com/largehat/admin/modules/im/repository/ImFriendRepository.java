package com.largehat.admin.modules.im.repository;



import com.largehat.api.modules.im.domain.ImFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author
* @date 2019-09-18
*/
public interface ImFriendRepository extends JpaRepository<ImFriend, Integer>, JpaSpecificationExecutor {
}