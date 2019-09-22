package com.largehat.admin.modules.im.repository;


import com.largehat.admin.modules.im.domain.ImOrg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author
* @date 2019-09-18
*/
public interface ImOrgRepository extends JpaRepository<ImOrg, Integer>, JpaSpecificationExecutor {
}