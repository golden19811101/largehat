package com.largehat.admin.modules.im.repository;



import com.largehat.api.modules.im.domain.ImTagRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author
* @date 2019-09-18
*/
public interface ImTagRelationRepository extends JpaRepository<ImTagRelation, Integer>, JpaSpecificationExecutor {
}