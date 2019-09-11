package com.largehat.server.handler;


import com.google.protobuf.Message;
import com.largehat.common.im.service.handler.IMHandler;
import com.largehat.common.im.utils.Worker;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;


/**
 * <B>处理鉴权请求</B>
 */
@Slf4j
public class ImAuthHandler extends IMHandler {


    protected ImAuthHandler(String userid, long netid, Message msg, ChannelHandlerContext ctx) {
        super(userid, netid, msg, ctx);
    }

    @Override
    protected void excute(Worker worker) throws Exception {


    }

}
