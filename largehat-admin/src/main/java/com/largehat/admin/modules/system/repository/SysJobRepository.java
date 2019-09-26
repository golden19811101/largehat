package com.largehat.admin.modules.system.repository;


import com.largehat.api.modules.system.domain.SysJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author Lion
* @date 2019-03-29
*/
public interface SysJobRepository extends JpaRepository<SysJob, Long>, JpaSpecificationExecutor {
}