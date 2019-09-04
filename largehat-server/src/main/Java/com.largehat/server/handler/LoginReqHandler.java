package com.largehat.server.handler;


import com.largehat.common.im.service.session.Session;
import com.largehat.common.im.service.uuid.LongIdGenerator;
import com.largehat.common.im.utils.SessionUtil;
import com.largehat.server.protocol.request.LoginReqPacket;
import com.largehat.server.protocol.response.LoginRepPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;


/**
 * <B>登录请求逻辑处理器</B>
 */
@ChannelHandler.Sharable
public class LoginReqHandler extends SimpleChannelInboundHandler<LoginReqPacket> {


    public static LoginReqHandler INSTANCE = null;

    //单例模式
    public static LoginReqHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginReqHandler();
        }
        return INSTANCE;
    }



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginReqPacket msg) throws Exception {
        // 处理登录请求数据包
        LoginRepPacket loginRepPacket = new LoginRepPacket();
        //loginRepPacket.setVersion(msg.getVersion());
        loginRepPacket.setUsername(msg.getUsername());

        // 登录校验
        if (valid(msg)) {
            loginRepPacket.setSuccess(true);
            // 随机生成userId，生产环境需要注册账号并生成userId，然后存储在数据库中
            String userId = LongIdGenerator.getRandomId();
            loginRepPacket.setUserId(userId);
            System.out.println("[" + msg.getUsername() + "]登录成功");
            // 缓存用户会话信息和连接的映射关系
            SessionUtil.bindSession(new Session(userId, msg.getUsername()), ctx.channel());
        } else {
            loginRepPacket.setSuccess(false);
            loginRepPacket.setReason("账号密码校验失败");
            System.out.println(new Date() + ":登录失败!");
        }

        // 登录响应
        ctx.channel().writeAndFlush(loginRepPacket);
    }

    private boolean valid(LoginReqPacket loginReqPacket) {
        return true;
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 清除用户会话信息和连接的映射关系
        SessionUtil.unBindSession(ctx.channel());
    }
}
