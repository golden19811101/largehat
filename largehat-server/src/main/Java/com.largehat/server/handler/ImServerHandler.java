package com.largehat.server.handler;


import com.largehat.common.im.packets.MessageProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ImServerHandler extends SimpleChannelInboundHandler<MessageProto.Message> {

    private static ImServerHandler INSTANCE = null;

    //单例模式
    public static ImServerHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImServerHandler();
        }
        return INSTANCE;
    }

    /**
     * <B>逻辑处理</B>
     * @param ctx
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProto.Message message) {
        //判断协议是否正确
//        switch (taskProtocol.getPackType()) {
//            case LOGIN:
//                log.info("接收到一个登录类型的pack:[{}]", taskProtocol.getLoginPack().getUsername() + " : " + taskProtocol.getLoginPack().getPassword());
//                break;
//            case CREATE_TASK:
//                log.info("接收到一个创建任务类型的pack:[{}]", taskProtocol.getCreateTaskPack().getTaskId() + " : " + taskProtocol.getCreateTaskPack().getTaskName());
//                break;
//            case DELETE_TASK:
//                log.info("接收到一个删除任务类型的pack:[{}]", Arrays.toString(taskProtocol.getDeleteTaskPack().getTaskIdList().toArray()));
//                break;
//            default:
//                log.error("接收到一个未知类型的pack:[{}]", taskProtocol.getPackType());
//                break;
//        }

//        if(taskProtocol.getVersion() != Protocol.VERSION){
//            throw new ImException(ImStatus.C10013.getText());
//        } else {
//            UserProto.User user  = UserProto.User.newBuilder().setUserid(1231313213).setSex(1).setOrgId("1111111").setAvatar("1232132131").build();
//            BaseResProto.AuthRes authRes = BaseResProto.AuthRes.newBuilder().setTonken("1232131321321313213213213").setUser(user).build();
//            ctx.writeAndFlush(authRes);
//        }
        //获取不同的服务来处理
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
        log.error("发生异常，关闭对应的连接", cause);
    }

}
