package com.largehat.admin.modules.system.service.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;

/**
* @author Lion
* @date 2019-04-10
*/
@Data
public class SysDictDetailQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name",joinName = "dict")
    private String dictName;
}