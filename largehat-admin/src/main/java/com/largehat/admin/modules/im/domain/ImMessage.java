package com.largehat.admin.modules.im.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author
* @date 2019-09-18
*/
@Entity
@Data
@Table(name="im_message")
public class ImMessage implements Serializable {

    // 消息ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    // 发送人
    @Column(name = "send_user",nullable = false)
    private String sendUser;

    // 接收人
    @Column(name = "receive_user")
    private String receiveUser;

    // 群组ID
    @Column(name = "group_id")
    private Integer groupId;

    // 是否已读 0, 已读 1, 未读取
    @Column(name = "is_read",nullable = false)
    private Integer isRead;

    // 状态 0,待发送 1, 已接受待查看  2，已查看
    @Column(name = "status")
    private Integer status;

    // 消息类型0, 文本  1,图片 2,语音 3,视频 4,音乐 5,图文
    @Column(name = "message_type",nullable = false)
    private Integer messageType;

    // 0, 未知 1,公聊 2,私聊
    @Column(name = "chat_type",nullable = false)
    private Integer chatType;

    // 设备标识UUID
    @Column(name = "device_id")
    private String deviceId;

    // 设备类型 0,未知 1,PC  2,android 3,ios
    @Column(name = "device_type")
    private Integer deviceType;

    // 消息内容
    @Column(name = "content")
    private String content;

    // 创建时间
    @Column(name = "create_time")
    private Timestamp createTime;

    // 创建人
    @Column(name = "create_by")
    private String createBy;

    // 修改时间
    @Column(name = "modify_time")
    private Timestamp modifyTime;

    // 修改人
    @Column(name = "modify_by")
    private String modifyBy;

    public void copy(ImMessage source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}