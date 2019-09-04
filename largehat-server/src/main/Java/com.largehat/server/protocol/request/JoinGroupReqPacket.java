package com.largehat.server.protocol.request;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;



@Data
public class JoinGroupReqPacket extends ImPacket {

    private String groupId;


}
