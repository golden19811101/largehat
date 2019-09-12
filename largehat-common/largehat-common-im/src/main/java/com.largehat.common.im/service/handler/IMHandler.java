package com.largehat.common.im.service.handler;

import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.utils.Worker;
import io.netty.channel.ChannelHandlerContext;


/**
 * <B>所有处理的基类</B>
 */
public abstract class IMHandler {
    protected Command _cmd;
    protected MessageProto.Message _msg;
    protected ChannelHandlerContext _ctx;

    protected IMHandler( Command cmd, MessageProto.Message msg, ChannelHandlerContext ctx) {
        _cmd = cmd;
        _msg = msg;
        _ctx = ctx;
    }

    protected abstract void excute(Worker worker) throws Exception;
}
