package com.largehat.server.handler;


import com.largehat.common.im.service.uuid.LongIdGenerator;
import com.largehat.common.im.utils.SessionUtil;
import com.largehat.server.protocol.request.CreateGroupReqPacket;
import com.largehat.server.protocol.response.CreateGroupRepPack;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**
 * <B>创建群聊请求逻辑处理器</B>
 */
@Slf4j
@ChannelHandler.Sharable
public class CreateGroupReqHandler extends SimpleChannelInboundHandler<CreateGroupReqPacket> {

    public static CreateGroupReqHandler INSTANCE = null;

    //单例模式
    public static CreateGroupReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CreateGroupReqHandler();
        }
        return INSTANCE;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupReqPacket msg) throws Exception {

        List<String> userIdList = msg.getUserIdList();
        List<String> userNameList = new ArrayList<>();
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
        for (Channel channel : channelGroup) {
            System.out.println(channel.toString());
        }

        // 筛选出在线的用户
        for (String userId : userIdList) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }

        // 创建群聊响应
        CreateGroupRepPack createGroupRepPack = new CreateGroupRepPack();
        createGroupRepPack.setSuccess(true);
        createGroupRepPack.setGroupId(LongIdGenerator.getRandomId());
        createGroupRepPack.setUserNameList(userNameList);

        // 给每个客户端发送拉群通知
        channelGroup.writeAndFlush(createGroupRepPack);
        log.info("群创建成功，id 为[" + createGroupRepPack.getGroupId() + "]，");
        log.info("群成员:" + createGroupRepPack.getUserNameList());

        // 保存群组相关的信息
        SessionUtil.bindChannelGroup(createGroupRepPack.getGroupId(), channelGroup);
    }
}
