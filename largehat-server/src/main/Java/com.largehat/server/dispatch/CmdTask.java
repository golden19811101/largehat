package com.largehat.server.dispatch;


import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.server.handler.manager.HandlerManager;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 玩家请求消息任务
 * 
 * @author kingston
 *
 */
@Slf4j
public class CmdTask extends DispatchTask {

	private static Logger logger = LoggerFactory.getLogger(CmdTask.class);

	private String userId;
	private IoSession session;
	private MessageProto.Message message;
	private ChannelHandlerContext ctx;

	public static CmdTask valueOf(int distributeKey, MessageProto.Message message, IoSession session, ChannelHandlerContext ctx) {
		CmdTask msgTask = new CmdTask();
		msgTask.dispatchKey = distributeKey;
		msgTask.session = session;
		msgTask.message  = message;
		msgTask.ctx  = ctx;
		return msgTask;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public void run() {
		try {
			HandlerManager.getInstance().exec(message, session, ctx);
			log.info("开始执行了！");
		}catch(Exception e) {
			logger.error("业务处理出现异常", e);
		}
	}

}
