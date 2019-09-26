package com.largehat.admin.modules.system.repository;


import com.largehat.api.modules.system.domain.SysDictDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author Lion
* @date 2019-04-10
*/
public interface SysDictDetailRepository extends JpaRepository<SysDictDetail, Long>, JpaSpecificationExecutor {
}