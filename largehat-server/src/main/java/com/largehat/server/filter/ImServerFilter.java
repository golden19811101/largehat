package com.largehat.server.filter;


import com.largehat.common.im.packets.MessageProto;
import com.largehat.server.handler.ImServerHandler;
import com.largehat.server.handler.ImHeartBeatServerHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;



public class ImServerFilter extends ChannelInitializer<Channel> {


    @Override
    protected void initChannel(Channel channel) throws Exception {
        //入参说明: 读超时时间、写超时时间、所有类型的超时时间、时间格式
        channel.pipeline()
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageProto.Message.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())

                 //读超时时间、写超时时间、所有类型的超时时间、时间格式
                .addLast(new IdleStateHandler(0, 0, 60*5, TimeUnit.SECONDS))
                .addLast(new ImHeartBeatServerHandler())
                .addLast(ImServerHandler.getInstance());

    }
 }
