package com.largehat.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 引导Netty客户端
 *
 * @author
 * @date 2019-04-20
 */
public class Client {

    private static final int MAX_RETRY = 5;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 11111;

    public void start() {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                // 指定线程模型
                .group(workerGroup)
                // 指定 I/O 类型为 NIO
                .channel(NioSocketChannel.class)
                // I/O 处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                    }
                });

        this.connect(bootstrap, MAX_RETRY);
    }

    /**
     * 连接远程节点
     *
     * @param bootstrap 启动器
     * @param retry     剩余重试次数
     */
    private void connect(Bootstrap bootstrap, int retry) {
        bootstrap
                .connect(HOST, PORT)
                .addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
                        System.out.println("连接成功");
                        startConsoleThread(future.channel());
                    } else {
                        // 第几次重连
                        int order = MAX_RETRY - retry + 1;
                        // 本次重连的间隔
                        int delay = 1 << order;
                        System.out.println(new Date() + ":连接失败，第" + order + "次重连");
                        bootstrap.config().group().schedule(() -> connect(bootstrap, retry - 1), delay, TimeUnit.SECONDS);
                    }
                });
    }

    /**
     * 开启控制台线程，进行指令操作
     *
     * @param channel 连接
     */
    private void startConsoleThread(Channel channel) {
//        new Thread(() -> {
//            ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
//            while (!Thread.interrupted()) {
//                Scanner scanner = new Scanner(System.in);
//                consoleCommandManager.exec(scanner, channel);
//            }
//        }).start();
    }

    public static void main(String[] args) {
        new Client().start();
    }

}
