package com.largehat.server.server;


import com.largehat.server.config.ImConfiguration;
import com.largehat.server.filter.ImServerFilter;
import com.largehat.server.handler.manager.HandlerManager;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <B>服务器启动</B>
 */
@Slf4j
@Component
public class ImServer {

    /**
     * <B>启动服务器</B>
     */
    public static void startServer(ImConfiguration configuration) {
        //主线程池, EventLoopGroup 包含一个或者多个 EventLoop
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //备线程池, EventLoopGroup 包含一个或者多个 EventLoop
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //过滤器
        ImServerFilter filter = new ImServerFilter();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup);
            b.channel(NioServerSocketChannel.class)
            .option(ChannelOption.SO_BACKLOG, 1024)
            // 连接超时
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000)
            .handler(new LoggingHandler(LogLevel.TRACE));
            b.childHandler(filter);
            Channel ch = b.bind(configuration.getBindPort()).addListener(new ChannelFutureListener() {
                        @Override
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                            if (channelFuture.isSuccess()) {
                                //HandlerManager.initHandlers();
                            } else {
                                log.info("处理器启动失败!");
                            }
                        }
                    }
            ).sync().channel();
            ch.closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //优雅的退出程序
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }



    public void stopServer() throws Exception {
        //bossGroup.shutdownGracefully();
        //workerGroup.shutdownGracefully();;
    }

}
