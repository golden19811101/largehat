package com.largehat.api.modules.system.service;

import com.largehat.api.modules.system.domain.SysDictDetail;
import com.largehat.api.modules.system.dto.SysDictDetailDTO;
import com.largehat.api.modules.system.dto.SysDictDetailQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
* @author Lion
* @date 2019-04-10
*/
public interface SysDictDetailService {

    /**
     * findById
     * @param id
     * @return
     */
    SysDictDetailDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    SysDictDetailDTO create(SysDictDetail resources);

    /**
     * update
     * @param resources
     */
    void update(SysDictDetail resources);

    /**
     * delete
     * @param id
     */
    void delete(Long id);



    Map queryAll(SysDictDetailQueryCriteria criteria, Pageable pageable);
}