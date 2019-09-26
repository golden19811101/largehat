package com.largehat.api.modules.system.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;

/**
 * 公共查询类
 */
@Data
public class SysCommonQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;
}
