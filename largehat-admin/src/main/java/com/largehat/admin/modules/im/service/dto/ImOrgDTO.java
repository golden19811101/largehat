package com.largehat.admin.modules.im.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImOrgDTO implements Serializable {

    // 组织机构id 
    private Integer orgId;

    // 组织机构编码
    private String orgCode;

    // 组织机构名称
    private String orgName;

    // 0，自有组织  1，社会组织
    private Integer orgType;

    // 组织图标
    private String iconUrl;

    // 0,  正常  1，失效  2，冻结
    private Integer status;

    // 创建时间
    private Timestamp createTime;

    // 创建人
    private String createBy;

    // 备注
    private String note;
}