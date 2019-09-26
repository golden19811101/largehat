package com.largehat.admin.modules.system.repository;


import com.largehat.api.modules.system.domain.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
* @author Lion
* @date 2019-03-25
*/
public interface SysDeptRepository extends JpaRepository<SysDept, Long>, JpaSpecificationExecutor {

    /**
     * findByPid
     * @param id
     * @return
     */
    List<SysDept> findByPid(Long id);

    @Query(value = "select name from sys_dept where id = ?1",nativeQuery = true)
    String findNameById(Long id);

    Set<SysDept> findByRoles_Id(Long id);
}