package com.largehat.service.modules.system.repository;


import com.largehat.api.modules.system.domain.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author Lion
 * @date 2018-12-17
 */
public interface SysMenuRepository extends JpaRepository<SysMenu, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    SysMenu findByName(String name);
    /**
     * findByPid
     * @param pid
     * @return
     */
    List<SysMenu> findByPid(long pid);

    LinkedHashSet<SysMenu> findByRoles_IdOrderBySortAsc(Long id);
}
