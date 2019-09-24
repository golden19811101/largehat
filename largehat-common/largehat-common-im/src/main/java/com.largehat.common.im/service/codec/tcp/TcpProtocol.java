package com.largehat.common.im.service.codec.tcp;



import com.largehat.common.im.constant.Protocol;
import com.largehat.common.im.entity.ImPacket;
import com.largehat.common.im.entity.ImSessionContext;
import com.largehat.common.im.protocol.AbProtocol;
import com.largehat.common.im.protocol.IConvertProtocolPacket;
import com.largehat.common.im.utils.ImUtils;
import io.netty.channel.ChannelHandlerContext;

import java.nio.ByteBuffer;

/**
 * Tcp协议判断器
 *
 */
public class TcpProtocol extends AbProtocol {

    @Override
    public String name() {
        return Protocol.TCP;
    }

    @Override
    public boolean isProtocolByBuffer(ByteBuffer buffer, ChannelHandlerContext channelContext) throws Throwable {
//        ImSessionContext imSessionContext = (ImSessionContext) channelContext.get();
//        if (imSessionContext != null && imSessionContext instanceof TcpSessionContext) {
//            return true;
//        }
        if (buffer != null) {
            //获取第一个字节协议版本号;
            byte version = buffer.get();
            //TCP协议;
//            if (version == Protocol.VERSION) {
//                channelContext.setAttribute(new TcpSessionContext());
//                ImUtils.setClient(channelContext);
//                return true;
//            }
        }
        return false;
    }

    @Override
    public IConvertProtocolPacket converter() {
        return new TcpConvertPacket();
    }

    @Override
    public boolean isProtocol(ImPacket imPacket, ChannelHandlerContext channelContext) throws Throwable {
        if (imPacket == null) {
            return false;
        }
        if (imPacket instanceof TcpPacket) {
//            Object sessionContext = channelContext.get();
//            if (sessionContext == null) {
//                channelContext.setAttribute(new TcpSessionContext());
//            }
            return true;
        }
        return false;
    }
}
