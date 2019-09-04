package com.largehat.server.protocol.request;


import com.largehat.common.im.entity.ImPacket;
import lombok.Data;

import java.util.List;

/**
 * <B>创建群组请求数据包</B>
 */
@Data
public class CreateGroupReqPacket extends ImPacket {

    private List<String> userIdList;

}
