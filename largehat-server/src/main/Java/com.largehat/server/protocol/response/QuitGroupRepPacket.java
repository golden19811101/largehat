package com.largehat.server.protocol.response;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;

/**
 * <B>退出群组管理</B>
 */
@Data
public class QuitGroupRepPacket extends ImPacket {

    private boolean success;

    private String groupId;

}
