package com.largehat.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


/**
 * <B>空闲检查处理逻辑处理器</B>
 */
@Slf4j
public class ImIdleStateHandler extends IdleStateHandler {

    /**
     * 60秒检查一次。通常服务器空闲检测时间要比客户端心跳检测时间2倍还多一些
     */
    private static final int READER_IDLE_TIME = 60;

    private static ImIdleStateHandler INSTANCE = null;

    //单例模式
    public static ImIdleStateHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImIdleStateHandler();
        }
        return INSTANCE;
    }

    public ImIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        log.debug(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
        //可以增加提示信息然后再断开
        ctx.channel().close();
    }
}
