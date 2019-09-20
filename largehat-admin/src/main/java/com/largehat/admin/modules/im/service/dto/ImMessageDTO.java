package com.largehat.admin.modules.im.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


/**
* @author
* @date 2019-09-18
*/
@Data
public class ImMessageDTO implements Serializable {

    // 消息ID
    private Long messageId;

    // 发送人
    private String sendUser;

    // 接收人
    private String receiveUser;

    // 群组ID
    private Integer groupId;

    // 是否已读 0, 已读 1, 未读取
    private Integer isRead;

    // 状态 0,待发送 1, 已接受待查看  2，已查看
    private Integer status;

    // 消息类型0, 文本  1,图片 2,语音 3,视频 4,音乐 5,图文
    private Integer messageType;

    // 0, 未知 1,公聊 2,私聊
    private Integer chatType;

    // 设备标识UUID
    private String deviceId;

    // 设备类型 0,未知 1,PC  2,android 3,ios
    private Integer deviceType;

    // 消息内容
    private String content;

    // 创建时间
    private Timestamp createTime;

    // 创建人
    private String createBy;

    // 修改时间
    private Timestamp modifyTime;

    // 修改人
    private String modifyBy;
}