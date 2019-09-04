package com.largehat.server.protocol.request;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;

/**
 * 登录请求数据包
 */
@Data
public class LoginReqPacket extends ImPacket {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
