package com.largehat.admin.modules.im.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImGroupDTO implements Serializable {

    // 群组ID
    private Integer groupId;

    // 群组名称
    private String groupName;

    // 群组头像
    private String groupAvatar;

    // 群组类型 0未知 1固定群 2临时群 3聊天室
    private Integer groupType;

    // 归属组织机构
    private String orgId;

    // 最大人数
    private Integer maxNum;

    // 状态 0 正常  1 失效  2冻结
    private Integer status;

    // 创建时间
    private Timestamp createTime;

    // 创建人
    private String createBy;

    // 修改时间
    private Timestamp modifyTime;

    // 修改人
    private String modifyBy;

    // 备注
    private String note;
}