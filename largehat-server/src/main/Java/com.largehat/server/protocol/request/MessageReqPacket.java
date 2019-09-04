package com.largehat.server.protocol.request;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <B>客户端发送至服务端的消息数据包</B>
 */
@Data
@NoArgsConstructor
public class MessageReqPacket extends ImPacket {

    /**
     * 消息要发给哪个用户
     */
    private String toUserId;

    /**
     * 消息内容
     */
    private String message;

    public MessageReqPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

}
