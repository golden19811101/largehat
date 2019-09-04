package com.largehat.server.handler;


import com.largehat.common.im.service.session.Session;
import com.largehat.common.im.utils.SessionUtil;
import com.largehat.server.protocol.request.MessageReqPacket;
import com.largehat.server.protocol.response.MessageRepPacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * <B>消息转发请求逻辑处理器</B>
 */
@ChannelHandler.Sharable
public class MessageReqHandler extends SimpleChannelInboundHandler<MessageReqPacket> {

    public static MessageReqHandler INSTANCE = null;

    //单例模式
    public static MessageReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MessageReqHandler();
        }
        return INSTANCE;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageReqPacket msg) throws Exception {

        // 拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());

        // 构造信息
        MessageRepPacket messageRepPacket = new MessageRepPacket();
        messageRepPacket.setFromUserId(session.getUserId());
        messageRepPacket.setFromUserName(session.getUserName());
        messageRepPacket.setMessage(msg.getMessage());

        // 拿到消息接收方的 Channel
        Channel toUserChannel = SessionUtil.getChannel(msg.getToUserId());

        // 将消息发给消息接收方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageRepPacket);
        } else {
            System.out.println("[" + msg.getToUserId() + "]不在线，发送失败!");
        }
    }
}
