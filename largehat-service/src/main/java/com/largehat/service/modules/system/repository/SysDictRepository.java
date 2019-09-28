package com.largehat.service.modules.system.repository;


import com.largehat.api.modules.system.domain.SysDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author Lion
* @date 2019-04-10
*/
public interface SysDictRepository extends JpaRepository<SysDict, Long>, JpaSpecificationExecutor {
}