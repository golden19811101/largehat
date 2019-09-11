package com.largehat.server.handler.manager;

import com.google.protobuf.Message;
import com.largehat.common.im.service.handler.IMHandler;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;



@Slf4j
public class HandlerManager {
    private static final Logger logger = LoggerFactory.getLogger(HandlerManager.class);

    private static final Map<Integer, Constructor<? extends IMHandler>> _handlers = new HashMap<>();

    public static void register(Class<? extends Message> msg, Class<? extends IMHandler> handler) {
//        BaseReqProto.BaseReq req = ( BaseReqProto.BaseReq)msg;
//
//        int command = ((BaseReqProto.BaseReq)msg).getCommand().getNumber();
//        try {
//            Constructor<? extends IMHandler> constructor = handler.getConstructor(String.class, long.class, Message.class, ChannelHandlerContext.class);
//            _handlers.put(command, constructor);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static IMHandler getHandler(int msgNum, String userId, long netId, Message msg, ChannelHandlerContext ctx) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<? extends IMHandler> constructor = _handlers.get(msgNum);
        if(constructor == null) {
            logger.error("handler not exist, Message Number: {}", msgNum);
            return null;
        }
        return constructor.newInstance(userId, netId, msg, ctx);
    }

    public static void initHandlers() {
        //HandlerManager.register(Internal.Greet.class, GreetHandler.class);
        //HandlerManager.register(Chat.CPrivateChat.class, CPrivateChatHandler.class);


    }
}
