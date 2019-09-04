package com.largehat.common.im.packets;

public final class Chat {
  private Chat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\nchat.proto*f\n\nDeviceType\022\026\n\022DEVICE_TYP" +
      "E_UNKNOW\020\000\022\022\n\016DEVICE_TYPE_PC\020\001\022\027\n\023DEVICE" +
      "_TYPE_ANDROID\020\002\022\023\n\017DEVICE_TYPE_IOS\020\003*\376\003\n" +
      "\007Command\022\022\n\016COMMAND_UNKNOW\020\000\022\031\n\025COMMAND_" +
      "HANDSHAKE_REQ\020\001\022\032\n\026COMMAND_HANDSHAKE_RES" +
      "P\020\002\022\024\n\020COMMAND_AUTH_REQ\020\003\022\025\n\021COMMAND_AUT" +
      "H_RESP\020\004\022\025\n\021COMMAND_LOGIN_REQ\020\005\022\026\n\022COMMA" +
      "ND_LOGIN_RESP\020\006\022\032\n\026COMMAND_JOIN_GROUP_RE" +
      "Q\020\007\022\033\n\027COMMAND_JOIN_GROUP_RESP\020\010\022\"\n\036COMM" +
      "AND_JOIN_GROUP_NOTIFY_RESP\020\t\022\"\n\036COMMAND_",
      "EXIT_GROUP_NOTIFY_RESP\020\n\022\024\n\020COMMAND_CHAT" +
      "_REQ\020\013\022\025\n\021COMMAND_CHAT_RESP\020\014\022\031\n\025COMMAND" +
      "_HEARTBEAT_REQ\020\r\022\025\n\021COMMAND_CLOSE_REQ\020\016\022" +
      "\032\n\026COMMAND_CANCEL_MSG_REQ\020\017\022\033\n\027COMMAND_C" +
      "ANCEL_MSG_RESP\020\020\022\030\n\024COMMAND_GET_USER_REQ" +
      "\020\021\022\031\n\025COMMAND_GET_USER_RESP\020\022*\320\001\n\017JoinGr" +
      "oupResult\022\034\n\030JOIN_GROUP_RESULT_UNKNOW\020\000\022" +
      "\030\n\024JOIN_GROUP_RESULT_OK\020\001\022\037\n\033JOIN_GROUP_" +
      "RESULT_NOT_EXIST\020\002\022 \n\034JOIN_GROUP_RESULT_" +
      "GROUP_FULL\020\003\022!\n\035JOIN_GROUP_RESULT_IN_BAC",
      "KLIST\020\004\022\037\n\033JOIN_GROUP_RESULT_TAKEOUTED\020\005" +
      "*M\n\010ChatType\022\024\n\020CHAT_TYPE_UNKNOW\020\000\022\024\n\020CH" +
      "AT_TYPE_PUBLIC\020\001\022\025\n\021CHAT_TYPE_PRIVATE\020\002*" +
      "}\n\007MsgType\022\021\n\rMSG_TYPE_TEXT\020\000\022\020\n\014MSG_TYP" +
      "E_IMG\020\001\022\022\n\016MSG_TYPE_VOICE\020\002\022\022\n\016MSG_TYPE_" +
      "VIDEO\020\003\022\022\n\016MSG_TYPE_MUSIC\020\004\022\021\n\rMSG_TYPE_" +
      "NEWS\020\005B\"\n\036com.largehat.common.im.packets" +
      "P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
