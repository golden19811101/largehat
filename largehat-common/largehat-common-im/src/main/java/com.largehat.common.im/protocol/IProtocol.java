package com.largehat.common.im.protocol;


import com.largehat.common.im.entity.ImPacket;
import io.netty.channel.ChannelHandlerContext;

/**
 * 判断协议接口
 * @author Lion
 *
 */
public interface IProtocol {
	/**
	 * 协议名称
	 * @return 如:http、ws、tcp等
	 */
	public  String name();

	/**
	 * 判断是否属于指定协议
	 * @param imPacket
	 * @param channelContext
	 * @return
	 * @throws Throwable
	 */
	public  boolean isProtocol(ImPacket imPacket, ChannelHandlerContext channelContext)throws Throwable;

	/**
	 * 获取该协议包转化器
	 * @return
	 */
	public  IConvertProtocolPacket converter();
}
