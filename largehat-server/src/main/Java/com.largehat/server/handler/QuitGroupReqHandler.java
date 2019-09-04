package com.largehat.server.handler;


import com.largehat.common.im.utils.SessionUtil;
import com.largehat.server.protocol.request.QuitGroupReqPacket;
import com.largehat.server.protocol.response.QuitGroupRepPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;


/**
 * <B>退出群组逻辑处理器</B>
 */
@ChannelHandler.Sharable
public class QuitGroupReqHandler extends SimpleChannelInboundHandler<QuitGroupReqPacket> {

    public static QuitGroupReqHandler INSTANCE = null;

    //单例模式
    public static QuitGroupReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuitGroupReqHandler();
        }
        return INSTANCE;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupReqPacket msg) throws Exception {
        // 获取群组对应的 channelGroup，然后将当期用户的 channel 移除
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.remove(ctx.channel());

        // 构造退出群组的响应数据包发送给客户端
        QuitGroupRepPacket quitGroupRepPacket = new QuitGroupRepPacket();
        quitGroupRepPacket.setGroupId(groupId);
        quitGroupRepPacket.setSuccess(true);
        ctx.channel().writeAndFlush(quitGroupRepPacket);
    }
}
