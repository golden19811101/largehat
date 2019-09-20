package com.largehat.admin.modules.im.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImGroupRelationDTO implements Serializable {

    private Integer id;

    // 群组id
    private Integer groupId;

    // 用户id
    private Integer userId;

    // 加入时间
    private Timestamp joinTime;
}