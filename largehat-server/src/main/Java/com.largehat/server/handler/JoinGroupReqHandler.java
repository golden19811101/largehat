package com.largehat.server.handler;



import com.largehat.common.im.utils.SessionUtil;
import com.largehat.server.protocol.request.JoinGroupReqPacket;
import com.largehat.server.protocol.response.JoinGroupRepPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;



@ChannelHandler.Sharable
public class JoinGroupReqHandler extends SimpleChannelInboundHandler<JoinGroupReqPacket> {


    public static JoinGroupReqHandler INSTANCE = null;

    //单例模式
    public static JoinGroupReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JoinGroupReqHandler();
        }
        return INSTANCE;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupReqPacket msg) throws Exception {

        // 获取群对应的 channelGroup ，然后将当前用户的 channel 添加进去
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        // 这里要再梳理一下逻辑：创建群组的时候已经添加了所有成员的连接，这里又添加连接，是不是重复了？
        channelGroup.add(ctx.channel());

        // 构造加群响应发送给客户端
        JoinGroupRepPacket joinGroupRepPacket = new JoinGroupRepPacket();
        joinGroupRepPacket.setSuccess(true);
        joinGroupRepPacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(joinGroupRepPacket);
    }
}
