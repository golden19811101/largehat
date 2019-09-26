package com.largehat.api.modules.system.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Lion
 * @date 2018-11-23
 */
@Data
public class SysUserQueryCriteria implements Serializable {

    @Query
    private Long id;

    @Query(propName = "id", type = Query.Type.IN, joinName = "dept")
    private Set<Long> deptIds;

    @Query(type = Query.Type.INNER_LIKE)
    private String username;

    @Query(type = Query.Type.INNER_LIKE)
    private String email;

    @Query
    private Boolean enabled;

    private Long deptId;
}
