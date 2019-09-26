package com.largehat.api.modules.system.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
* @author Lion
* @date 2019-6-4 14:49:34
*/
@Data
@NoArgsConstructor
public class OssConfigQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String paramKey;

    @Query
    private Boolean status;


}