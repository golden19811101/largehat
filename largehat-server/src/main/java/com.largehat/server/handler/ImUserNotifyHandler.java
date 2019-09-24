package com.largehat.server.handler;


import com.largehat.common.im.entity.session.IoSession;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.service.handler.IMHandler;
import com.largehat.common.im.utils.ProToBufBuild;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;


/**
 * <B>处理登录请求</B>
 */
@Slf4j
public class ImUserNotifyHandler extends IMHandler {

    public ImUserNotifyHandler(MessageProto.Message msg, IoSession session, ChannelHandlerContext ctx) {
        super(msg, session, ctx);
    }

    @Override
    public void excute() throws Exception {
        if (this._msg.getCommand() != Command.COMMAND_USER_NOTIFY_REQ || this._msg.getUserNoticeReq() == null) {
            return;
        }


        MessageProto.ResBody body = ProToBufBuild.buidResBody(0, "接受到你的消息了");
        this._ctx.channel().writeAndFlush(MessageProto.Message.newBuilder().setCommand(this._msg.getCommand()).setSynSeq(this._msg.getSynSeq()).setVersion(1).setCancelMsgRes(body));
    }

}
