package com.largehat.admin.modules.system.service.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;

import java.util.Set;

/**
* @author Lion
* @date 2019-03-25
*/
@Data
public class SysDeptQueryCriteria {

    @Query(type = Query.Type.IN, propName="id")
    private Set<Long> ids;

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query
    private Boolean enabled;

    @Query
    private Long pid;
}