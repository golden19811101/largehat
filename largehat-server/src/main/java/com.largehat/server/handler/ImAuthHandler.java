package com.largehat.server.handler;


import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.service.handler.IMHandler;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;


/**
 * <B>处理鉴权请求</B>
 */
@Slf4j
public class ImAuthHandler extends IMHandler {

    public ImAuthHandler(MessageProto.Message msg, IoSession session, ChannelHandlerContext ctx) {
        super(msg, session, ctx);
    }

    @Override
    public void excute() throws Exception {
        log.info("====================鉴权处理开始===========================>");
        if (this._msg.getCommand() != Command.COMMAND_AUTH_REQ || this._msg.getAuthReq() == null) {
            return;
        }

        //判断鉴权是否正确



        //

        log.info("====================鉴权处理结束===========================>");
    }

}