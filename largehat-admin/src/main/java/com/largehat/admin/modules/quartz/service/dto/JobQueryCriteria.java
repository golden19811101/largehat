package com.largehat.admin.modules.quartz.service.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;

/**
 * @author Lion
 * @date 2019-6-4 10:33:02
 */
@Data
public class JobQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String jobName;

    @Query
    private Boolean isSuccess;
}
