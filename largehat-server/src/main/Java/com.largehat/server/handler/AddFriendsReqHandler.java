package com.largehat.server.handler;


import com.largehat.server.protocol.request.CreateGroupReqPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;


/**
 * <B>添加好友逻辑处理器</B>
 */
@Slf4j
@ChannelHandler.Sharable
public class AddFriendsReqHandler extends SimpleChannelInboundHandler<CreateGroupReqPacket> {


    public static AddFriendsReqHandler INSTANCE = null;

    //单例模式
    public static AddFriendsReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AddFriendsReqHandler();
        }
        return INSTANCE;
    }


    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupReqPacket msg) throws Exception {



    }

}
