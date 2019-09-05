package com.largehat.common.im.protocol;


import com.largehat.common.im.entity.ImPacket;
import com.largehat.common.im.packets.command.Command;
import io.netty.channel.ChannelHandlerContext;

/**
 * 转换不同协议消息包;
 *
 * @author Lion
 */
public interface IConvertProtocolPacket {
	/**
	 * 转化请求包
	 *
	 * @param body
	 * @param command
	 * @param channelContext
	 * @return
	 */
	public ImPacket ReqPacket(byte[] body, Command command, ChannelHandlerContext channelContext);


	/**
	 * 转化响应包
	 *
	 * @param body
	 * @param command
	 * @param channelContext
	 * @return
	 */
	public ImPacket RespPacket(byte[] body, Command command, ChannelHandlerContext channelContext);
}
