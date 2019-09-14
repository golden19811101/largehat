package com.largehat.admin.modules.system.repository;

import com.largehat.admin.modules.system.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

/**
 * @author Lion
 * @date 2018-12-03
 */
public interface SysRoleRepository extends JpaRepository<SysRole, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    SysRole findByName(String name);

    Set<SysRole> findByUsers_Id(Long id);

    Set<SysRole> findByMenus_Id(Long id);
}
