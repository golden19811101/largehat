package com.largehat.server.handler;


import com.largehat.common.im.service.session.Session;
import com.largehat.common.im.utils.SessionUtil;
import com.largehat.server.protocol.request.GroupMembersReqPacket;
import com.largehat.server.protocol.response.GroupMembersRepPacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;



/**
 * <B>创建群聊用户逻辑处理器</B>
 */
@Slf4j
@ChannelHandler.Sharable
public class GroupMembersReqHandler extends SimpleChannelInboundHandler<GroupMembersReqPacket> {

    public static GroupMembersReqHandler INSTANCE = null;

    //单例模式
    public static GroupMembersReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GroupMembersReqHandler();
        }
        return INSTANCE;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMembersReqPacket msg) throws Exception {
        // 获取群的 ChannelGroup
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        // 遍历群成员的 channel，对应的 session，构造群成员的信息
        List<Session> sessionList = new ArrayList<>();
        for (Channel channel : channelGroup) {
            Session session = SessionUtil.getSession(channel);
            sessionList.add(session);
        }

        // 构造获取群成员列表响应客户端
        GroupMembersRepPacket listGroupMembersResponsePacket = new GroupMembersRepPacket();
        listGroupMembersResponsePacket.setGroupId(groupId);
        listGroupMembersResponsePacket.setSessionList(sessionList);
        ctx.channel().writeAndFlush(listGroupMembersResponsePacket);
    }
}
