package com.largehat.client;


import com.largehat.common.im.packets.Message;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
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
			MessageProto.GroupNoticeReq groupNoticeReq = MessageProto.GroupNoticeReq.newBuilder().setGroupId("1111111").setGroupNoticeTypeValue(1)
					.setNoticeContent("{test: 一堆中文中文案件发生立即分解落实到飞机撒发生建安费经理开始打发时间了阿萨德飞洒发斯蒂芬是否" +
							"舒服撒发生啦开发撒酒疯撒娇发送卡了房间爱上几分技术打法就是大房间卡萨飞机撒酒疯山东矿机按时发顺丰士大夫士大夫撒飞洒发撒飞洒发沙发舒服撒飞洒发萨芬撒飞洒" +
							"爱的疯狂就类似的飞机速度快拉法卡时间飞机撒飞机撒杰弗里斯建安费举案说法经历了解放军拉斯加福利卡是否健康了" +
							"按时付款了的萨芬就是大家快来发送即可拉法基阿双方家里卡死了加快分解拉萨附近路口见拉法基拉时间开房间卡士大夫" +
							"撒开飞机撒娇了弗利萨解放军拉双方了解撒垃圾分类举案说法垃圾啊垃圾分类静安寺龙卷风的几率是打飞机啊数据库房间卡萨积分}").build();
			MessageProto.Message req = MessageProto.Message.newBuilder().setVersion(1).setCommand(Command.COMMAND_GROUP_NOTIFY_REQ).setGroupNoticeReq(groupNoticeReq).build();

			log.info("字节数组长度:" +  req.toByteArray().length);


			byte[] b = req.toByteArray();
			log.info("字节数组内容:" +  b);
			ctx.writeAndFlush(req);

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
			log.info("收到服务端的消息:" + msg.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

}
