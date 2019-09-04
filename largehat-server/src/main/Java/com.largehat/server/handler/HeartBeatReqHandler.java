package com.largehat.server.handler;


import com.largehat.server.protocol.request.HeartBeatReqPacket;
import com.largehat.server.protocol.response.HeartBeatRepPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * <B>心跳检测处理器</B>
 */
@ChannelHandler.Sharable
public class HeartBeatReqHandler extends SimpleChannelInboundHandler<HeartBeatReqPacket> {


    public static HeartBeatReqHandler INSTANCE = null;

    //单例模式
    public static HeartBeatReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HeartBeatReqHandler();
        }
        return INSTANCE;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatReqPacket msg) throws Exception {
        ctx.writeAndFlush(new HeartBeatRepPacket());
    }
}
