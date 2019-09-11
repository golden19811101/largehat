package com.largehat.client;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @Description: 客户端业务逻辑实现
 */
@Slf4j
public class ImClientHandler extends ChannelInboundHandlerAdapter {

	private int fcount = 1;

	private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	private AtomicInteger atomicInteger = new AtomicInteger(1);
	/**
	 * 建立连接时
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("建立连接时：" + new Date());
		executor.scheduleAtFixedRate(() -> {
//			BaseReqProto.AuthReq authReq = BaseReqProto.AuthReq.newBuilder().setOrgid(100).setAuthcode("1111111").setUserid("1000000").setPasswd("1234567").build();
//			BaseReqProto.BaseReq req = BaseReqProto.BaseReq.newBuilder().setVersion(1).setCommand(Command.COMMAND_AUTH_REQ).setAuthReq(authReq).build();
//
//			log.info("字节数组长度:" +  req.toByteArray().length);
//			ctx.writeAndFlush(req);

			// 产生的pack类型
////			int packType = new Random().nextInt(3);
////			switch (TaskProtobufWrapper.PackType.forNumber(packType)) {
////				case LOGIN:
////					TaskProtobufWrapper.LoginPack loginPack = TaskProtobufWrapper.LoginPack.newBuilder().setUsername("张三[" + atomicInteger.getAndIncrement() + "]").setPassword("123456").build();
////					ctx.writeAndFlush(TaskProtobufWrapper.TaskProtocol.newBuilder().setPackType(TaskProtobufWrapper.PackType.LOGIN).setLoginPack(loginPack).build());
////					break;
////				case CREATE_TASK:
////					TaskProtobufWrapper.CreateTaskPack createTaskPack = TaskProtobufWrapper.CreateTaskPack.newBuilder().setCreateTime(System.currentTimeMillis()).setTaskId("100" + atomicInteger.get()).setTaskName("任务编号" + atomicInteger.get()).build();
////					ctx.writeAndFlush(TaskProtobufWrapper.TaskProtocol.newBuilder().setPackType(TaskProtobufWrapper.PackType.CREATE_TASK).setCreateTaskPack(createTaskPack).build());
////					break;
////				case DELETE_TASK:
////					TaskProtobufWrapper.DeleteTaskPack deleteTaskPack = TaskProtobufWrapper.DeleteTaskPack.newBuilder().addTaskId("1001").addTaskId("1002").build();
////					ctx.writeAndFlush(TaskProtobufWrapper.TaskProtocol.newBuilder().setPackType(TaskProtobufWrapper.PackType.DELETE_TASK).setDeleteTaskPack(deleteTaskPack).build());
////					break;
//				default:
//					log.error("产生一个未知的包类型:[{}]", packType);
//					break;
//			}
		}, 0, 1, TimeUnit.SECONDS);
	}


//	/**
//	 * 关闭连接时
//	 */
//	@Override
//	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//		System.out.println("关闭连接时：" + new Date());
//		final EventLoop eventLoop = ctx.channel().eventLoop();
//		//NettyClient.nettyClient.doConnect(new Bootstrap(), eventLoop);
//		super.channelInactive(ctx);
//	}
//
//	/**
//	 * 心跳请求处理 每4秒发送一次心跳请求;
//	 *
//	 */
//	@Override
//	public void userEventTriggered(ChannelHandlerContext ctx, Object obj) throws Exception {
//		System.out.println("循环请求的时间：" + new Date() + "，次数" + fcount);
//		if (obj instanceof IdleStateEvent) {
//			IdleStateEvent event = (IdleStateEvent) obj;
//			if (IdleState.WRITER_IDLE.equals(event.state())) { // 如果写通道处于空闲状态,就发送心跳命令
//
//
//			}
//		}
//	}
//
//	/**
//	 * 业务逻辑处理
//	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
		//手动写请求数据
//			BaseReqProto.AuthReq authReq = BaseReqProto.AuthReq.newBuilder().setOrgid(100).setAuthcode("1111111").setUserid("1000000").setPasswd("1234567").build();
//			BaseReqProto.BaseReq req = BaseReqProto.BaseReq.newBuilder().setCommand(Command.COMMAND_AUTH_REQ).setAuthReq(authReq).build();
//			ctx.writeAndFlush(req);
			System.out.println("成功发送给服务端!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

}
