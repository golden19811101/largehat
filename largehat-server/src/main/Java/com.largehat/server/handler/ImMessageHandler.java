package com.largehat.server.handler;


import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.service.handler.IMHandler;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * <B>处理消息等请求</B>
 */
@Slf4j
public class ImMessageHandler extends IMHandler {

    public ImMessageHandler(MessageProto.Message msg, IoSession session, ChannelHandlerContext ctx) {
        super(msg, session, ctx);
    }

    @Override
    public void excute() throws Exception {
//        if (this._msg.getCommand() != Command.COMMAND_AUTH_REQ || this._msg.getMessageReq() == null) {
//            return;
//        }


    }



}
