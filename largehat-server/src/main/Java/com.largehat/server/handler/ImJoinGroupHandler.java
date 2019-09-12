package com.largehat.server.handler;

import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.service.handler.IMHandler;
import com.largehat.common.im.utils.Worker;
import io.netty.channel.ChannelHandlerContext;

/**
 * <B>处理群组等请求</B>
 */
public class ImJoinGroupHandler extends IMHandler {


    protected ImJoinGroupHandler(Command cmd, MessageProto.Message msg, ChannelHandlerContext ctx) {
        super(cmd, msg, ctx);
    }

    @Override
    protected void excute(Worker worker) throws Exception {

    }
}
