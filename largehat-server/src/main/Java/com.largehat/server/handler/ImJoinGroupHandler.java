package com.largehat.server.handler;

import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.service.handler.IMHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * <B>处理群组等请求</B>
 */
public class ImJoinGroupHandler extends IMHandler {

    public ImJoinGroupHandler(MessageProto.Message msg, IoSession session, ChannelHandlerContext ctx) {
        super(msg, session, ctx);
    }

    @Override
    public void excute() throws Exception {
        if (this._msg.getCommand() != Command.COMMAND_JOIN_GROUP_REQ || this._msg.getJoinGroupReq() == null) {
            return;
        }


    }
}
