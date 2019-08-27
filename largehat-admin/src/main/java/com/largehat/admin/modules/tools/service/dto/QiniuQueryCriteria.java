package com.largehat.admin.modules.tools.service.dto;

import com.largehat.web.annotation.Query;
import lombok.Data;

/**
 * @author Zheng Jie
 * @date 2019-6-4 09:54:37
 */
@Data
public class QiniuQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String key;
}
