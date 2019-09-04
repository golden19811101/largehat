package com.largehat.server.protocol.response;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;



@Data
public class JoinGroupRepPacket extends ImPacket {

    private boolean success;

    private String groupId;

    private String reason;

}
