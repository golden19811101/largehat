package com.largehat.server.protocol.response;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;

/**
 *  <B>登录响应数据包</B>
 */
@Data
public class LoginRepPacket extends ImPacket {

    private String userId;

    private String username;

    private boolean success;

    private String reason;

}
