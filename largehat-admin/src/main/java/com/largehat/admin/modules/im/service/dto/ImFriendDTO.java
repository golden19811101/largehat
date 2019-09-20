package com.largehat.admin.modules.im.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImFriendDTO implements Serializable {

    // 主键
    private Integer id;

    // 朋友ID
    private Integer friendId;

    // 用户ID
    private Integer userId;

    // 添加好友时间
    private Timestamp addTime;
}