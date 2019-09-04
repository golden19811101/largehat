package com.largehat.server.protocol.response;


import com.largehat.common.im.entity.ImPacket;
import com.largehat.common.im.service.session.Session;
import lombok.Data;

/**
 *
 */
@Data
public class GroupMessageRepPacket extends ImPacket {

    private String fromGroupId;

    private Session fromUser;

    private String message;

}
