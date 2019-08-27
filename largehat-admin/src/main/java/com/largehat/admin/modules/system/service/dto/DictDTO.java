package com.largehat.admin.modules.system.service.dto;

import com.largehat.common.core.annotation.Query;
import lombok.Data;

import java.io.Serializable;

/**
* @author Lion
* @date 2019-04-10
*/
@Data
public class DictDTO implements Serializable {

    private Long id;

    /**
     * 字典名称
     */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    /**
     * 描述
     */
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;
}
