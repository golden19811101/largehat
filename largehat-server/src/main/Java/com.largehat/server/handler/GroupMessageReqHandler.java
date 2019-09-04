package com.largehat.server.handler;


import com.largehat.common.im.utils.SessionUtil;
import com.largehat.server.protocol.request.GroupMessageReqPacket;
import com.largehat.server.protocol.response.GroupMessageRepPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;


/**
 * <B>群消息处理器</B>
 */
@ChannelHandler.Sharable
public class GroupMessageReqHandler extends SimpleChannelInboundHandler<GroupMessageReqPacket> {


    public static GroupMessageReqHandler INSTANCE = null;

    //单例模式
    public static GroupMessageReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GroupMessageReqHandler();
        }
        return INSTANCE;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageReqPacket msg) throws Exception {
        // 构造群聊消息的响应数据包
        String groupId = msg.getToGroupId();
        String message = msg.getMessage();

        GroupMessageRepPacket groupMessageRepPacket = new GroupMessageRepPacket();
        groupMessageRepPacket.setFromGroupId(groupId);
        groupMessageRepPacket.setFromUser(SessionUtil.getSession(ctx.channel()));

        groupMessageRepPacket.setMessage(message);
        // 拿到群聊对应的 ChannelGroup，写到每个客户端
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.writeAndFlush(groupMessageRepPacket);
    }
}
