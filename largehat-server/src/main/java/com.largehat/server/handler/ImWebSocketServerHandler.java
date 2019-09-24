package com.largehat.server.handler;

import com.largehat.common.im.constant.Protocol;
import com.largehat.common.im.entity.ImStatus;
import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.exception.ImException;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.utils.ChannelUtils;
import com.largehat.server.base.SpringContext;
import com.largehat.server.dispatch.CmdTask;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
public class ImWebSocketServerHandler  extends SimpleChannelInboundHandler<MessageProto.Message> {


    private static ImWebSocketServerHandler INSTANCE = null;

    //单例模式
    public static ImWebSocketServerHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImWebSocketServerHandler();
        }
        return INSTANCE;
    }

    /**
     * <B>刚开始的时候添加session</B>
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (!ChannelUtils.addChannelSession(ctx.channel(), new IoSession(ctx.channel()))) {
            ctx.channel().close();
            log.error("Duplicate session,IP=[{}]",ChannelUtils.getIp(ctx.channel()));
        }
    }

    /**
     * <B>逻辑处理</B>
     * @param ctx
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProto.Message message) throws Exception {
        log.info("============接收到数据包大小============>" + message.toByteArray().length + "个字节");
        //判断协议是否正确
        if(message.getVersion() != Protocol.VERSION){
            throw new ImException(ImStatus.C10013.getText());
        } else {
            if (message.getCommand() == null) {
                throw new ImException(ImStatus.C10014.getText());
            } else {
                final Channel channel = ctx.channel();
                IoSession session = ChannelUtils.getSessionBy(channel);
                //新开一个线程去处理
                CmdTask cmdTask = CmdTask.valueOf(session.getDispatchKey(), message, session, ctx);
                SpringContext.getMessageDispatcher().addMessageTask(cmdTask);
            }
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
        log.error("发生异常，关闭对应的连接", cause);
        Channel channel = ctx.channel();
        if(cause instanceof IOException && channel.isActive()){
            log.error("simpleclient" + channel.remoteAddress() + "异常");
            //SpringContext.getUserService().userLogout(channel, SessionCloseReason.NORMAL);
            ctx.close();
        }
    }


}
