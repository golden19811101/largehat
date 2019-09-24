package com.largehat.common.im.service.codec.tcp;


import com.google.protobuf.Message;
import com.largehat.common.im.constant.Protocol;
import com.largehat.common.im.entity.ImPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 版本: [1.0]
 * 功能说明:
 */
public class TcpServerEncoder extends MessageToByteEncoder<Message> {

//    @Override
//    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
//        byte[] bytes = msg.toByteArray();// 将对象转换为byte
//        int ptoNum = ParseMap.msg2ptoNum.get(msg);
//        int length = bytes.length;
//
//        /* 加密消息体
//        ThreeDES des = ctx.channel().attr(ClientAttr.ENCRYPT).get();
//        byte[] encryptByte = des.encrypt(bytes);
//        int length = encryptByte.length;*/
//
//        ByteBuf buf = Unpooled.buffer(8 + length);
//        buf.writeInt(length);
//        buf.writeInt(ptoNum);
//        buf.writeBytes(bytes);
//        out.writeBytes(buf);
//    }


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {

    }


    public static ByteBuffer encode(TcpPacket tcpPacket, ChannelHandlerContext channelContext) {
        int bodyLen = 0;
        byte[] body = tcpPacket.getBody();
        if (body != null) {
            bodyLen = body.length;
        }
        boolean isCompress = true;
        boolean is4ByteLength = true;
        boolean isEncrypt = true;
        //boolean isHasSynSeq = tcpPacket.getSynSeq() > 0;
        //协议版本号
        byte version = Protocol.VERSION;

        //协议标志位mask
        byte maskByte = ImPacket.encodeEncrypt(version, isEncrypt);
        maskByte = ImPacket.encodeCompress(maskByte, isCompress);
        //maskByte = ImPacket.encodeHasSynSeq(maskByte, isHasSynSeq);
        maskByte = ImPacket.encode4ByteLength(maskByte, is4ByteLength);
        byte cmdByte = 0x00;
        //消息类型;
        if (tcpPacket.getCommand() != null) {
            cmdByte = (byte) (cmdByte | tcpPacket.getCommand().getNumber());
        }

        tcpPacket.setVersion(version);
        tcpPacket.setMask(maskByte);

        //byteBuffer的总长度是 = 1byte协议版本号+1byte消息标志位+4byte同步序列号(如果是同步发送则都4byte同步序列号,否则无4byte序列号)+1byte命令码+4byte消息的长度+消息体
        int allLen = 1 + 1;
//        if (isHasSynSeq) {
//            allLen += 4;
//        }
        allLen += 1 + 4 + bodyLen;
        ByteBuffer buffer = ByteBuffer.allocate(allLen);
        //设置字节序
        ByteOrder byteOrder = null;
        //ByteOrder byteOrder = tioConfig == null ? ByteOrder.BIG_ENDIAN : tioConfig.getByteOrder();
        buffer.order(byteOrder);
        buffer.put(tcpPacket.getVersion());
        buffer.put(tcpPacket.getMask());
        //同步发送设置4byte，同步序列号;
        //if (isHasSynSeq) {
        //buffer.putInt(tcpPacket.getSynSeq());
        //}
        buffer.put(cmdByte);
        buffer.putInt(bodyLen);
        buffer.put(body);
        return buffer;
    }
}
