package com.largehat.server.handler.manager;

import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.service.handler.IMHandler;
import com.largehat.server.handler.*;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class HandlerManager {
    private static final Map<Integer, Constructor<? extends IMHandler>> _handlers = new HashMap<>();

    public static void register(Command cmd, Class<? extends IMHandler> handler) {
        try {
            Constructor<? extends IMHandler> constructor = handler.getConstructor(Command.class, MessageProto.Message.class, ChannelHandlerContext.class);
            //Constructor<? extends IMHandler> constructor =  handler.newInstance(cmd, msg, ctx);
            _handlers.put(cmd.getNumber(), constructor);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static IMHandler getHandler(Command cmd,  MessageProto.Message msg, ChannelHandlerContext ctx) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<? extends IMHandler> constructor = _handlers.get(cmd.getNumber());
        if(constructor == null) {
            log.error("handler not exist, Message Number: {}", cmd.getNumber());
            return null;
        }
        return constructor.newInstance(cmd, msg, ctx);
    }

    /**
     * <B>注册处理器</B>
     */
    public static void initHandlers() {
        //鉴权处理器
        HandlerManager.register(Command.COMMAND_AUTH_REQ,  ImAuthHandler.class);
        //登录处理器
        HandlerManager.register(Command.COMMAND_LOGIN_REQ, ImLoginHandler.class);
        //消息处理器
        HandlerManager.register(Command.COMMAND_CHAT_REQ, ImMessageHandler.class);
        //加入群组处理器
        HandlerManager.register(Command.COMMAND_JOIN_GROUP_REQ, ImJoinGroupHandler.class);
        //退出群组处理器
        HandlerManager.register(Command.COMMAND_EXIT_GROUP_NOTIFY_RESP, ImExitGroupHandler.class);
        //撤销消息处理器
        HandlerManager.register(Command.COMMAND_CANCEL_MSG_REQ, ImJoinGroupHandler.class);
    }
}
