package com.largehat.api.modules.system.service;


import com.largehat.api.modules.system.domain.SysDict;
import com.largehat.api.modules.system.dto.SysDictDTO;
import org.springframework.data.domain.Pageable;

/**
* @author Lion
* @date 2019-04-10
*/
public interface SysDictService {

    /**
     * 查询
     * @param dict
     * @param pageable
     * @return
     */
    Object queryAll(SysDictDTO dict, Pageable pageable);

    /**
     * findById
     * @param id
     * @return
     */
    SysDictDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    SysDictDTO create(SysDict resources);

    /**
     * update
     * @param resources
     */
    void update(SysDict resources);

    /**
     * delete
     * @param id
     */
    void delete(Long id);
}