package com.largehat.common.im.service.codec.tcp;


import com.largehat.common.im.entity.ImPacket;
import com.largehat.common.im.entity.ImStatus;
import com.largehat.common.im.entity.Protocol;
import com.largehat.common.im.packets.command.Command;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.List;


/**
 * 版本: [1.0]
 * 功能说明:
 */
public class TcpServerDecoder extends ByteToMessageDecoder {

    //1byte协议版本号+1byte消息标志位+4byte同步序列号+1byte命令码+4byte消息的长度+消息体的长度
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //解密信息
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //我们标记一下当前的readIndex的位置
        in.markReaderIndex();
        if (in.readableBytes() < 4) {
            logger.info("readableBytes length less than 4 bytes, ignored");
            //把readIndex重置到mark的地方
            in.resetReaderIndex();
            return;
        }

        int length = in.readInt();
        if (length < 0) {
            ctx.close();
            logger.error("message length less than 0, channel closed");
            return;
        }

        if (length > in.readableBytes() - 4) {
            //注意！编解码器加这种in.readInt()日志，在大并发的情况下很可能会抛数组越界异常！
            //logger.error("message received is incomplete,ptoNum:{}, length:{}, readable:{}", in.readInt(), length, in.readableBytes());
            //把readIndex重置到mark的地方
            in.resetReaderIndex();
            return;
        }

        int ptoNum = in.readInt();
        ByteBuf byteBuf = Unpooled.buffer(length);
        in.readBytes(byteBuf);

        try {
            /* 解密消息体
            ThreeDES des = ctx.channel().attr(ClientAttr.ENCRYPT).get();
            byte[] bareByte = des.decrypt(inByte);*/
            byte[] body= byteBuf.array();
            //Message msg = ParseMap.getMessage(ptoNum, body);
            //out.add(msg);
            logger.info("GateServer Received Message: content length {}, ptoNum: {}", length, ptoNum);
        } catch (Exception e) {
            logger.error(ctx.channel().remoteAddress() + ",decode failed.", e);
        }
    }


    public static TcpPacket decode(ByteBuffer buffer, ChannelHandlerContext channelContext) throws Exception {
        //校验协议头
        if (!isHeaderLength(buffer)) {
            return null;
        }
        //获取第一个字节协议版本号;
        byte version = buffer.get();
        if (version != Protocol.VERSION) {
            throw new Exception(ImStatus.C10013.getText());
        }
        //标志位
        byte maskByte = buffer.get();
        Integer synSeq = 0;
        //同步发送;
        if (ImPacket.decodeHasSynSeq(maskByte)) {
            synSeq = buffer.getInt();
        }
        //cmd命令码
        byte cmdByte = buffer.get();
        if (Command.forNumber(cmdByte) == null) {
            //throw new AioDecodeException(ImStatus.C10014.getText());
        }
        int bodyLen = buffer.getInt();
        //数据不正确，则抛出AioDecodeException异常
        if (bodyLen < 0) {
            //throw new AioDecodeException("bodyLength [" + bodyLen + "] is not right, remote:" + channelContext.getClientNode());
        }
        int readableLength = buffer.limit() - buffer.position();
        int validateBodyLen = readableLength - bodyLen;
        // 不够消息体长度(剩下的buffer组不了消息体)
        if (validateBodyLen < 0) {
            return null;
        }
        byte[] body = new byte[bodyLen];
        try {
            buffer.get(body, 0, bodyLen);
        } catch (Exception e) {

        }
        //logger.info("TCP解码成功...");
        //byteBuffer的总长度是 = 1byte协议版本号+1byte消息标志位+4byte同步序列号(如果是同步发送则多4byte同步序列号,否则无4byte序列号)+1byte命令码+4byte消息的长度+消息体的长度
        TcpPacket tcpPacket = new TcpPacket(Command.forNumber(cmdByte), body);
        tcpPacket.setVersion(version);
        tcpPacket.setMask(maskByte);
        //同步发送设置同步序列号
        if (synSeq > 0) {
            //tcpPacket.setSynSeq(synSeq);
            try {
                //channelContext.getTioConfig().getAioHandler().handler(tcpPacket, channelContext);
            } catch (Exception e) {
                //logger.error("同步发送解码调用handler异常!" + e);
            }
        }
        return tcpPacket;
    }

    /**
     * 判断是否符合协议头长度
     * @param buffer
     * @return
     */
    private static boolean isHeaderLength(ByteBuffer buffer) throws Exception {
        int readableLength = buffer.limit() - buffer.position();
        if (readableLength == 0) {
            return false;
        }
        //协议头索引;
        int index = buffer.position();
        try {
            //获取第一个字节协议版本号;
            buffer.get(index);
            index++;
            //标志位
            byte maskByte = buffer.get(index);
            //同步发送;
            if (ImPacket.decodeHasSynSeq(maskByte)) {
                index += 4;
            }
            index++;
            //cmd命令码
            buffer.get(index);
            index++;
            //消息体长度
            buffer.getInt(index);
            index += 4;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
