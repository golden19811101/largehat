package com.largehat.server.handler;


import com.google.protobuf.Message;
import com.largehat.common.im.service.handler.IMHandler;
import com.largehat.common.im.utils.Worker;
import io.netty.channel.ChannelHandlerContext;


public class ImMessageHandler extends IMHandler {


    protected ImMessageHandler(String userid, long netid, Message msg, ChannelHandlerContext ctx) {
        super(userid, netid, msg, ctx);
    }

    @Override
    protected void excute(Worker worker) throws Exception {

    }
}
