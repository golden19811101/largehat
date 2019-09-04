package com.largehat.server.protocol.response;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;

import java.util.List;

/**
 * 创建群组响应数据包
 */
@Data
public class CreateGroupRepPack extends ImPacket {

    private boolean success;

    /**
     * 群组ID
     */
    private String groupId;

    /**
     * 群组内成员的名称列表，生产环境，还有更多字段，比如成员的基本信息
     */
    private List<String> userNameList;
}
