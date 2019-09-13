package com.largehat.server.handler;

import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.service.handler.IMHandler;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * <B>处理群组等请求</B>
 */
@Slf4j
public class ImExitGroupHandler extends IMHandler {

    public ImExitGroupHandler(MessageProto.Message msg, IoSession session, ChannelHandlerContext ctx) {
        super(msg, session, ctx);
    }

    @Override
    public void excute() throws Exception {


    }
}
