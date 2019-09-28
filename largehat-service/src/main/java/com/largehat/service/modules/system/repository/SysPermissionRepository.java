package com.largehat.service.modules.system.repository;


import com.largehat.api.modules.system.domain.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Lion
 * @date 2018-12-03
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    SysPermission findByName(String name);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<SysPermission> findByPid(long pid);
}
