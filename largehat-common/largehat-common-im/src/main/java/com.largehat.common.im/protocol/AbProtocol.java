package com.largehat.common.im.protocol;


import java.nio.ByteBuffer;

/**
 * @author Lion
 */
public abstract class AbProtocol implements IProtocol {
	/**
	 * 协议包转化器;
	 */
	private IConvertProtocolPacket converter;
	
	public AbProtocol(){
		this.converter = converter();
	}

	/**
	 * 根据buffer判断是否属于指定协议
	 * @return
	 * @throws Throwable
	 */
	//public abstract boolean isProtocolByBuffer(ByteBuffer buffer,ChannelContext channelContext) throws Throwable;

//	public boolean isProtocol(ByteBuffer buffer,ChannelContext channelContext) throws Throwable {
//		ByteBuffer copyByteBuffer = null;
//		if(buffer != null && channelContext.getAttribute() == null){
//			copyByteBuffer = ByteBuffer.wrap(buffer.array());
//		}
//		return isProtocolByBuffer(copyByteBuffer, channelContext);
//	}

	public IConvertProtocolPacket getConverter() {
		return converter;
	}
}
