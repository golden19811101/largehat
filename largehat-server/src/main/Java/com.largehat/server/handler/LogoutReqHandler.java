package com.largehat.server.handler;



import com.largehat.common.im.utils.SessionUtil;
import com.largehat.server.protocol.request.LogoutReqPacket;
import com.largehat.server.protocol.response.LogoutRepPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * <B>退出请求逻辑处理器</B>
 */
@ChannelHandler.Sharable
public class LogoutReqHandler extends SimpleChannelInboundHandler<LogoutReqPacket> {

    public static LogoutReqHandler INSTANCE = null;

    //单例模式
    public static LogoutReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogoutReqHandler();
        }
        return INSTANCE;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutReqPacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());

        LogoutRepPacket logoutRepPacket = new LogoutRepPacket();
        logoutRepPacket.setSuccess(true);
        ctx.channel().writeAndFlush(logoutRepPacket);
    }
}
