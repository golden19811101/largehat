package com.largehat.api.modules.im.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImOrgAuthDTO implements Serializable {

    // 主键
    private Integer id;

    // 组织机构编码
    private Integer orgId;

    // 鉴权码
    private String authCode;

    // 更新时间
    private Timestamp updateTime;

    // 更新人
    private String updateBy;
}