package com.largehat.server.handler;


import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.service.handler.IMHandler;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;


/**
 * <B>处理群组通知请求</B>
 */
@Slf4j
public class ImGroupNotifyHandler extends IMHandler {

    public ImGroupNotifyHandler(MessageProto.Message msg, IoSession session, ChannelHandlerContext ctx) {
        super(msg, session, ctx);
    }

    @Override
    public void excute() throws Exception {
        if (this._msg.getCommand() != Command.COMMAND_GROUP_NOTIFY_REQ || this._msg.getUserNoticeReq() == null) {
            return;
        }



    }

}
