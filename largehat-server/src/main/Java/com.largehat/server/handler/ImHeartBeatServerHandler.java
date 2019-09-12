package com.largehat.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * <B>处理心跳机制</B>
 */
@Slf4j
public class ImHeartBeatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info("已经5分钟没有收到消息了");
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.READER_IDLE || state == IdleState.WRITER_IDLE ||  state == IdleState.ALL_IDLE) {
                // 在规定时间内没有收到客户端的读数据, 主动断开连接
                ctx.disconnect();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }


    /**
     * <B>出现异常断开连接</B>
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}

