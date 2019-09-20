package com.largehat.admin.modules.im.repository;


import com.largehat.admin.modules.im.domain.ImTagGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author
* @date 2019-09-18
*/
public interface ImTagGroupRepository extends JpaRepository<ImTagGroup, Integer>, JpaSpecificationExecutor {
}