package com.largehat.admin.modules.system.service.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
* @author Lion
* @date 2019-6-4 14:49:34
*/
@Data
@NoArgsConstructor
public class JobQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query
    private Boolean enabled;

    @Query(propName = "id", joinName = "dept")
    private Long deptId;

    @Query(propName = "id", joinName = "dept", type = Query.Type.IN)
    private Set<Long> deptIds;
}