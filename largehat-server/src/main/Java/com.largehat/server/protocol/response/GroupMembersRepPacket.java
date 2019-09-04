package com.largehat.server.protocol.response;


import com.largehat.common.im.entity.ImPacket;
import com.largehat.common.im.service.session.Session;
import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class GroupMembersRepPacket extends ImPacket {

    private String groupId;

    /**
     * 生产环境中，这里可能会构造另外一个对象来装载用户信息而非 Session
     */
    private List<Session> sessionList;

}
