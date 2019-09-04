// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.largehat.common.im.packets.command;

import com.largehat.common.im.packets.Chat;

/**
 * Protobuf enum {@code Command}
 */
public enum Command
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>COMMAND_UNKNOW = 0;</code>
   */
  COMMAND_UNKNOW(0),
  /**
   * <pre>
   *握手请求
   * </pre>
   *
   * <code>COMMAND_HANDSHAKE_REQ = 1;</code>
   */
  COMMAND_HANDSHAKE_REQ(1),
  /**
   * <pre>
   *握手响应
   * </pre>
   *
   * <code>COMMAND_HANDSHAKE_RESP = 2;</code>
   */
  COMMAND_HANDSHAKE_RESP(2),
  /**
   * <pre>
   *鉴权请求
   * </pre>
   *
   * <code>COMMAND_AUTH_REQ = 3;</code>
   */
  COMMAND_AUTH_REQ(3),
  /**
   * <pre>
   * 鉴权响应
   * </pre>
   *
   * <code>COMMAND_AUTH_RESP = 4;</code>
   */
  COMMAND_AUTH_RESP(4),
  /**
   * <pre>
   *登录请求
   * </pre>
   *
   * <code>COMMAND_LOGIN_REQ = 5;</code>
   */
  COMMAND_LOGIN_REQ(5),
  /**
   * <pre>
   *登录响应
   * </pre>
   *
   * <code>COMMAND_LOGIN_RESP = 6;</code>
   */
  COMMAND_LOGIN_RESP(6),
  /**
   * <pre>
   *申请进入群组
   * </pre>
   *
   * <code>COMMAND_JOIN_GROUP_REQ = 7;</code>
   */
  COMMAND_JOIN_GROUP_REQ(7),
  /**
   * <pre>
   *申请进入群组响应
   * </pre>
   *
   * <code>COMMAND_JOIN_GROUP_RESP = 8;</code>
   */
  COMMAND_JOIN_GROUP_RESP(8),
  /**
   * <pre>
   *进入群组通知
   * </pre>
   *
   * <code>COMMAND_JOIN_GROUP_NOTIFY_RESP = 9;</code>
   */
  COMMAND_JOIN_GROUP_NOTIFY_RESP(9),
  /**
   * <pre>
   *退出群组通知
   * </pre>
   *
   * <code>COMMAND_EXIT_GROUP_NOTIFY_RESP = 10;</code>
   */
  COMMAND_EXIT_GROUP_NOTIFY_RESP(10),
  /**
   * <pre>
   *聊天请求
   * </pre>
   *
   * <code>COMMAND_CHAT_REQ = 11;</code>
   */
  COMMAND_CHAT_REQ(11),
  /**
   * <pre>
   *聊天响应
   * </pre>
   *
   * <code>COMMAND_CHAT_RESP = 12;</code>
   */
  COMMAND_CHAT_RESP(12),
  /**
   * <pre>
   *心跳请求
   * </pre>
   *
   * <code>COMMAND_HEARTBEAT_REQ = 13;</code>
   */
  COMMAND_HEARTBEAT_REQ(13),
  /**
   * <pre>
   *关闭请求
   * </pre>
   *
   * <code>COMMAND_CLOSE_REQ = 14;</code>
   */
  COMMAND_CLOSE_REQ(14),
  /**
   * <pre>
   *发出撤消消息指令(管理员可以撤消所有人的消息，自己可以撤消自己的消息)
   * </pre>
   *
   * <code>COMMAND_CANCEL_MSG_REQ = 15;</code>
   */
  COMMAND_CANCEL_MSG_REQ(15),
  /**
   * <pre>
   *收到撤消消息指令
   * </pre>
   *
   * <code>COMMAND_CANCEL_MSG_RESP = 16;</code>
   */
  COMMAND_CANCEL_MSG_RESP(16),
  /**
   * <pre>
   *获取用户信息;
   * </pre>
   *
   * <code>COMMAND_GET_USER_REQ = 17;</code>
   */
  COMMAND_GET_USER_REQ(17),
  /**
   * <pre>
   *获取用户信息响应;
   * </pre>
   *
   * <code>COMMAND_GET_USER_RESP = 18;</code>
   */
  COMMAND_GET_USER_RESP(18),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>COMMAND_UNKNOW = 0;</code>
   */
  public static final int COMMAND_UNKNOW_VALUE = 0;
  /**
   * <pre>
   *握手请求
   * </pre>
   *
   * <code>COMMAND_HANDSHAKE_REQ = 1;</code>
   */
  public static final int COMMAND_HANDSHAKE_REQ_VALUE = 1;
  /**
   * <pre>
   *握手响应
   * </pre>
   *
   * <code>COMMAND_HANDSHAKE_RESP = 2;</code>
   */
  public static final int COMMAND_HANDSHAKE_RESP_VALUE = 2;
  /**
   * <pre>
   *鉴权请求
   * </pre>
   *
   * <code>COMMAND_AUTH_REQ = 3;</code>
   */
  public static final int COMMAND_AUTH_REQ_VALUE = 3;
  /**
   * <pre>
   * 鉴权响应
   * </pre>
   *
   * <code>COMMAND_AUTH_RESP = 4;</code>
   */
  public static final int COMMAND_AUTH_RESP_VALUE = 4;
  /**
   * <pre>
   *登录请求
   * </pre>
   *
   * <code>COMMAND_LOGIN_REQ = 5;</code>
   */
  public static final int COMMAND_LOGIN_REQ_VALUE = 5;
  /**
   * <pre>
   *登录响应
   * </pre>
   *
   * <code>COMMAND_LOGIN_RESP = 6;</code>
   */
  public static final int COMMAND_LOGIN_RESP_VALUE = 6;
  /**
   * <pre>
   *申请进入群组
   * </pre>
   *
   * <code>COMMAND_JOIN_GROUP_REQ = 7;</code>
   */
  public static final int COMMAND_JOIN_GROUP_REQ_VALUE = 7;
  /**
   * <pre>
   *申请进入群组响应
   * </pre>
   *
   * <code>COMMAND_JOIN_GROUP_RESP = 8;</code>
   */
  public static final int COMMAND_JOIN_GROUP_RESP_VALUE = 8;
  /**
   * <pre>
   *进入群组通知
   * </pre>
   *
   * <code>COMMAND_JOIN_GROUP_NOTIFY_RESP = 9;</code>
   */
  public static final int COMMAND_JOIN_GROUP_NOTIFY_RESP_VALUE = 9;
  /**
   * <pre>
   *退出群组通知
   * </pre>
   *
   * <code>COMMAND_EXIT_GROUP_NOTIFY_RESP = 10;</code>
   */
  public static final int COMMAND_EXIT_GROUP_NOTIFY_RESP_VALUE = 10;
  /**
   * <pre>
   *聊天请求
   * </pre>
   *
   * <code>COMMAND_CHAT_REQ = 11;</code>
   */
  public static final int COMMAND_CHAT_REQ_VALUE = 11;
  /**
   * <pre>
   *聊天响应
   * </pre>
   *
   * <code>COMMAND_CHAT_RESP = 12;</code>
   */
  public static final int COMMAND_CHAT_RESP_VALUE = 12;
  /**
   * <pre>
   *心跳请求
   * </pre>
   *
   * <code>COMMAND_HEARTBEAT_REQ = 13;</code>
   */
  public static final int COMMAND_HEARTBEAT_REQ_VALUE = 13;
  /**
   * <pre>
   *关闭请求
   * </pre>
   *
   * <code>COMMAND_CLOSE_REQ = 14;</code>
   */
  public static final int COMMAND_CLOSE_REQ_VALUE = 14;
  /**
   * <pre>
   *发出撤消消息指令(管理员可以撤消所有人的消息，自己可以撤消自己的消息)
   * </pre>
   *
   * <code>COMMAND_CANCEL_MSG_REQ = 15;</code>
   */
  public static final int COMMAND_CANCEL_MSG_REQ_VALUE = 15;
  /**
   * <pre>
   *收到撤消消息指令
   * </pre>
   *
   * <code>COMMAND_CANCEL_MSG_RESP = 16;</code>
   */
  public static final int COMMAND_CANCEL_MSG_RESP_VALUE = 16;
  /**
   * <pre>
   *获取用户信息;
   * </pre>
   *
   * <code>COMMAND_GET_USER_REQ = 17;</code>
   */
  public static final int COMMAND_GET_USER_REQ_VALUE = 17;
  /**
   * <pre>
   *获取用户信息响应;
   * </pre>
   *
   * <code>COMMAND_GET_USER_RESP = 18;</code>
   */
  public static final int COMMAND_GET_USER_RESP_VALUE = 18;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @Deprecated
  public static Command valueOf(int value) {
    return forNumber(value);
  }

  public static Command forNumber(int value) {
    switch (value) {
      case 0: return COMMAND_UNKNOW;
      case 1: return COMMAND_HANDSHAKE_REQ;
      case 2: return COMMAND_HANDSHAKE_RESP;
      case 3: return COMMAND_AUTH_REQ;
      case 4: return COMMAND_AUTH_RESP;
      case 5: return COMMAND_LOGIN_REQ;
      case 6: return COMMAND_LOGIN_RESP;
      case 7: return COMMAND_JOIN_GROUP_REQ;
      case 8: return COMMAND_JOIN_GROUP_RESP;
      case 9: return COMMAND_JOIN_GROUP_NOTIFY_RESP;
      case 10: return COMMAND_EXIT_GROUP_NOTIFY_RESP;
      case 11: return COMMAND_CHAT_REQ;
      case 12: return COMMAND_CHAT_RESP;
      case 13: return COMMAND_HEARTBEAT_REQ;
      case 14: return COMMAND_CLOSE_REQ;
      case 15: return COMMAND_CANCEL_MSG_REQ;
      case 16: return COMMAND_CANCEL_MSG_RESP;
      case 17: return COMMAND_GET_USER_REQ;
      case 18: return COMMAND_GET_USER_RESP;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Command>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
          Command> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Command>() {
          public Command findValueByNumber(int number) {
            return Command.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return Chat.getDescriptor()
        .getEnumTypes().get(1);
  }

  private static final Command[] VALUES = values();

  public static Command valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Command(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Command)
}

