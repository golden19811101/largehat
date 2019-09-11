package com.largehat.common.im.service.codec.tcp;


import com.largehat.common.im.entity.ImPacket;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.protocol.IConvertProtocolPacket;
import io.netty.channel.ChannelHandlerContext;

/**
 * TCP协议消息转化包
 *
 */
public class TcpConvertPacket implements IConvertProtocolPacket {

    /**
     * 转TCP协议响应包;
     */
    @Override
    public ImPacket RespPacket(byte[] body, Command command, ChannelHandlerContext channelContext) {
        //Object sessionContext = channelContext.get();
//        if (sessionContext instanceof TcpSessionContext) {//转TCP协议响应包;
//            TcpPacket tcpPacket = new TcpPacket(command, body);
//            TcpServerEncoder.encode(tcpPacket, channelContext.getTioConfig(), channelContext);
//            tcpPacket.setCommand(command);
//            return tcpPacket;
//        }
        return null;
    }

    /**
     * 转TCP协议请求包;
     */
    @Override
    public ImPacket ReqPacket(byte[] body, Command command, ChannelHandlerContext channelContext) {
//        Object sessionContext = channelContext.get();
//        if (sessionContext instanceof TcpSessionContext) {//转TCP协议请求包;
//            TcpPacket tcpPacket = new TcpPacket(command, body);
//            TcpServerEncoder.encode(tcpPacket, channelContext.getTioConfig(), channelContext);
//            tcpPacket.setCommand(command);
//            return tcpPacket;
//        }
        return null;
    }

}
