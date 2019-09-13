package com.largehat.server.handler;

import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.service.handler.IMHandler;
import io.netty.channel.ChannelHandlerContext;


/**
 * <B>消息处理器</B>
 */
public class ImCancelMessageHandler extends IMHandler {

    public ImCancelMessageHandler(MessageProto.Message msg, IoSession session, ChannelHandlerContext ctx) {
        super(msg, session, ctx);
    }

    @Override
    public void excute() throws Exception {


    }

}
