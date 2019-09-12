package com.largehat.server.handler;


import com.largehat.common.im.entity.ImStatus;
import com.largehat.common.im.entity.Protocol;
import com.largehat.common.im.exception.ImException;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.service.handler.IMHandler;
import com.largehat.server.handler.manager.HandlerManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ImServerHandler extends SimpleChannelInboundHandler<MessageProto.Message> {

    private static ImServerHandler INSTANCE = null;

    //单例模式
    public static ImServerHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImServerHandler();
        }
        return INSTANCE;
    }

    /**
     * <B>逻辑处理</B>
     * @param ctx
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProto.Message message) throws Exception {
        log.info("============接收到数据包大小============>" + message.toByteArray().length + "个字节");
        //判断协议是否正确
        IMHandler handler;
        if(message.getVersion() != Protocol.VERSION){
            throw new ImException(ImStatus.C10013.getText());
        } else {
            if (message.getCommand() == null) {
                throw new ImException(ImStatus.C10014.getText());
            } else {
                handler = HandlerManager.getHandler(message.getCommand(), message, ctx);
            }
            log.info("============handler============>" + handler.toString());
            //新开一个线程去处理
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
        log.error("发生异常，关闭对应的连接", cause);
    }

}
