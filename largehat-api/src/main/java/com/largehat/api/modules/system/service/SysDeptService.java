package com.largehat.api.modules.system.service;


import com.largehat.api.modules.system.domain.SysDept;
import com.largehat.api.modules.system.dto.SysDeptDTO;
import com.largehat.api.modules.system.dto.SysDeptQueryCriteria;

import java.util.List;
import java.util.Set;

/**
* @author Lion
* @date 2019-03-25
*/
public interface SysDeptService {

    /**
     * queryAll
     * @param criteria
     * @return
     */
    List<SysDeptDTO> queryAll(SysDeptQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    SysDeptDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    SysDeptDTO create(SysDept resources);

    /**
     * update
     * @param resources
     */
    void update(SysDept resources);

    /**
     * delete
     * @param id
     */
    void delete(Long id);

    /**
     * buildTree
     * @param deptDTOS
     * @return
     */
    Object buildTree(List<SysDeptDTO> deptDTOS);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<SysDept> findByPid(long pid);



    Set<SysDept> findByRoleIds(Long id);
}