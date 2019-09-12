package com.largehat.server.handler;


import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.service.handler.IMHandler;
import com.largehat.common.im.utils.Worker;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;


/**
 * <B>处理登录请求</B>
 */
@Slf4j
public class ImLoginHandler extends IMHandler {


    protected ImLoginHandler(Command cmd, MessageProto.Message msg, ChannelHandlerContext ctx) {
        super(cmd, msg, ctx);
    }

    @Override
    protected void excute(Worker worker) throws Exception {


    }

}
