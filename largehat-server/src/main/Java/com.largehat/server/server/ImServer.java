package com.largehat.server.server;


import com.largehat.server.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * <B>服务器启动</B>
 */
public class ImServer {

    private static final int PORT = 11111;


    /**
     * <B>启动服务器</B>
     */
    public void startServer() {
        //主线程池, EventLoopGroup 包含一个或者多个 EventLoop
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //备线程池, EventLoopGroup 包含一个或者多个 EventLoop
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                // 指定线程模型，这里是主从线程模型
                .group(bossGroup, workerGroup)
                // 指定服务端的 Channel 的 I/O 模型
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel channel) throws Exception {
                        // 空闲检测
                        channel.pipeline().addLast(new ImIdleStateHandler());
                        // 鉴权
                        channel.pipeline().addLast(new ImIdleStateHandler());
                        // 处理粘包半包

                        // 数据包编解码器

                        //注册

                        // 登录
                        channel.pipeline().addLast(LoginReqHandler.getInstance());
                        // 退出登录
                        channel.pipeline().addLast(LogoutReqHandler.getInstance());
                        // 心跳检测
                        channel.pipeline().addLast(HeartBeatReqHandler.getInstance());
                        // 身份校验

                        // 单聊消息
                        channel.pipeline().addLast(MessageReqHandler.getInstance());
                        // 创建群聊
                        channel.pipeline().addLast(CreateGroupReqHandler.getInstance());
                        // 加入群组
                        channel.pipeline().addLast(JoinGroupReqHandler.getInstance());
                        // 退出群组
                        channel.pipeline().addLast(QuitGroupReqHandler.getInstance());
                        // 获取群成员
                        channel.pipeline().addLast(GroupMembersReqHandler.getInstance());
                        // 群消息
                        channel.pipeline().addLast(GroupMessageReqHandler.getInstance());
                    }
                });
        serverBootstrap.bind(PORT).addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                System.out.println("端口绑定成功 port = " + PORT);
            } else {
                System.out.println("端口绑定失败");
            }
        });
    }


    public static void main(String[] args) {
        new ImServer().startServer();
    }
}
