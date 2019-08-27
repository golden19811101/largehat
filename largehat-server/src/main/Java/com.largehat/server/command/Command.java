package com.largehat.server.command;


/**
 * <B>自定义命令类型</B>
 */
public enum Command {

    COMMAND_UNKNOW(0),

    /**
     * <B>握手请求</B>
     */
    COMMAND_HANDSHAKE_REQ(1),

    /**
     * <B>握手响应</B>
     */
    COMMAND_HANDSHAKE_RESP(2),

    /**
     * <B>鉴权请求</B>
     */
    COMMAND_AUTH_REQ(3),

    /**
     * <B>鉴权响应</B>
     */
    COMMAND_AUTH_RESP(4),

    /**
     * <B>登录请求</B>
     */
    COMMAND_LOGIN_REQ(5),

    /**
     * <B>登录的响应</B>
     */
    COMMAND_LOGIN_RESP(6),

    /**
     *<B>申请进入群组</B>
     */
    COMMAND_JOIN_GROUP_REQ(7),

    /**
     *<B>申请进入群组响应</B>
     */
    COMMAND_JOIN_GROUP_RESP(8),

    /**
     *<B>进入群组通知</B>
     */
    COMMAND_JOIN_GROUP_NOTIFY_RESP(9),

    /**
     *<B>退出群组通知</B>
     */
    COMMAND_EXIT_GROUP_NOTIFY_RESP(10),

    /**
     *<B>聊天请求</B>
     */
    COMMAND_CHAT_REQ(11),

    /**
     *<B> 聊天响应</B>
     */
    COMMAND_CHAT_RESP(12),

    /**
     *<B>心跳请求</B>
     */
    COMMAND_HEARTBEAT_REQ(13),

    /**
     *<B>关闭请求</B>
     */
    COMMAND_CLOSE_REQ(14),

    /**
     * <B>发出撤消消息指令</B>
     */
    COMMAND_CANCEL_MSG_REQ(15),

    /**
     * <B>收到撤消消息指令</B>
     */
    COMMAND_CANCEL_MSG_RESP(16),

    /**
     * <B>获取用户信息</B>
     */
    COMMAND_GET_USER_REQ(17),

    /**
     * <B>获取用户信息响应</B>
     */
    COMMAND_GET_USER_RESP(18),

    /**
     * <B> 获取聊天消息</B>
     */
    COMMAND_GET_MESSAGE_REQ(19),

    /**
     * <B>获取聊天消息响应</B>
     */
    COMMAND_GET_MESSAGE_RESP(20);

    public final int getNumber() {
        return cmdCode;
    }

    public static Command valueOf(int value) {
        return forNumber(value);
    }

    public static Command forNumber(int value) {
        for(Command command : Command.values()){
            if(command.getNumber() == value){
                return command;
            }
        }
        return null;
    }

    private int cmdCode;
    private String resMessage;

    private Command(int cmdCode) {
        this.cmdCode = cmdCode;
    }


    Command(int cmdCode, String resMessage) {
        this.cmdCode = cmdCode;
        this.resMessage = resMessage;
    }

}
