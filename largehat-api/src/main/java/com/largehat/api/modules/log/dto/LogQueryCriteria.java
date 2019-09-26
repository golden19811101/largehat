package com.largehat.api.modules.log.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;

/**
 * 日志查询类
 * @author Lion
 * @date 2019-6-4 09:23:07
 */
@Data
public class LogQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String username;

    @Query
    private String logType;

    @Query(type = Query.Type.INNER_LIKE)
    private String description;
}
