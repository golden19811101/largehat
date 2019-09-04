package com.largehat.server.protocol.response;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;

/**
 * <B>服务端发送至客户端的消息数据包</B>
 */
@Data
public class MessageRepPacket extends ImPacket {

    /**
     * 消息来源用户
     */
    private String fromUserId;

    private String fromUserName;

    private String message;

}
