package com.largehat.server.protocol.response;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;


@Data
public class LogoutRepPacket extends ImPacket {

    private boolean success;

}
