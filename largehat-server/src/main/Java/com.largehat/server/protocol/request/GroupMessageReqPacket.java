package com.largehat.server.protocol.request;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class GroupMessageReqPacket extends ImPacket {

    private String toGroupId;

    private String message;

    public GroupMessageReqPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

}
