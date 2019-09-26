package com.largehat.api.modules.system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author Lion
* @date 2019-03-29
*/
@Data
@NoArgsConstructor
public class OssConfigDTO implements Serializable {

    /**
     * ID
     */
    private Long id;
    /**
     *  key
     */
    private String paramKey;
    /**
     * value
     */
    private String paramValue;
    /**
     * 状态
     */
    private Boolean status;

    /**
     * 是否激活 0 ：否   1，是
     */
    private Boolean isActivate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期
     */
    private Timestamp createTime;

    public OssConfigDTO(String paramKey, Boolean status) {
        this.paramKey = paramKey;
        this.status = status;
    }
}