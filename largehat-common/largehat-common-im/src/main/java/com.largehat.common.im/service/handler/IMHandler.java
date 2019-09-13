package com.largehat.common.im.service.handler;

import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import io.netty.channel.ChannelHandlerContext;


/**
 * <B>所有处理的基类</B>
 */
public abstract class IMHandler {
    protected MessageProto.Message _msg;
    protected IoSession _session;
    protected ChannelHandlerContext _ctx;

    protected IMHandler(MessageProto.Message msg, IoSession session, ChannelHandlerContext ctx) {
        _session = session;
        _msg = msg;
        _ctx = ctx;
    }

    protected abstract void excute() throws Exception;
}
