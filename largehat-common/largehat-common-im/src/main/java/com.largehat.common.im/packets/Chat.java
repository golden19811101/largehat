// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Chat.proto

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
      "\n\nChat.proto*f\n\nDeviceType\022\026\n\022DEVICE_TYP" +
      "E_UNKNOW\020\000\022\022\n\016DEVICE_TYPE_PC\020\001\022\027\n\023DEVICE" +
      "_TYPE_ANDROID\020\002\022\023\n\017DEVICE_TYPE_IOS\020\003*b\n\t" +
      "GroupType\022\025\n\021GROUP_TYPE_UNKNOW\020\000\022\024\n\020GROU" +
      "P_TYPE_FIXED\020\001\022\023\n\017GROUP_TYPE_TEMP\020\002\022\023\n\017G" +
      "ROUP_TYPE_CHAT\020\003*\242\006\n\007Command\022\022\n\016COMMAND_" +
      "UNKNOW\020\000\022\031\n\025COMMAND_HANDSHAKE_REQ\020\001\022\032\n\026C" +
      "OMMAND_HANDSHAKE_RESP\020\002\022\024\n\020COMMAND_AUTH_" +
      "REQ\020\003\022\025\n\021COMMAND_AUTH_RESP\020\004\022\025\n\021COMMAND_" +
      "LOGIN_REQ\020\005\022\026\n\022COMMAND_LOGIN_RESP\020\006\022\032\n\026C",
      "OMMAND_JOIN_GROUP_REQ\020\007\022\033\n\027COMMAND_JOIN_" +
      "GROUP_RESP\020\010\022\032\n\026COMMAND_EXIT_GROUP_REQ\020\n" +
      "\022\033\n\027COMMAND_EXIT_GROUP_RESP\020\013\022\034\n\030COMMAND" +
      "_GROUP_NOTIFY_REQ\020\014\022\035\n\031COMMAND_GROUP_NOT" +
      "IFY_RESP\020\r\022\033\n\027COMMAND_USER_NOTIFY_REQ\020\016\022" +
      "\034\n\030COMMAND_USER_NOTIFY_RESP\020\017\022\024\n\020COMMAND" +
      "_CHAT_REQ\020\020\022\025\n\021COMMAND_CHAT_RESP\020\021\022\031\n\025CO" +
      "MMAND_HEARTBEAT_REQ\020\022\022\025\n\021COMMAND_CLOSE_R" +
      "EQ\020\023\022\032\n\026COMMAND_CANCEL_MSG_REQ\020\024\022\033\n\027COMM" +
      "AND_CANCEL_MSG_RESP\020\025\022\033\n\027COMMAND_ADD_FRI",
      "ENDS_REQ\020\026\022\034\n\030COMMAND_ADD_FRIENDS_RESP\020\027" +
      "\022\031\n\025COMMAND_ADD_BLACK_REQ\020\030\022\032\n\026COMMAND_A" +
      "DD_BLACK_RESP\020\031\022\036\n\032COMMAND_CANCEL_FRIEND" +
      "S_REQ\020\032\022\037\n\033COMMAND_CANCEL_FRIENDS_RESP\020\033" +
      "\022\034\n\030COMMAND_CANCEL_BLACK_REQ\020\034\022\035\n\031COMMAN" +
      "D_CANCEL_BLACK_RESP\020\035*\320\001\n\017JoinGroupResul" +
      "t\022\030\n\024JOIN_GROUP_RESULT_OK\020\000\022\034\n\030JOIN_GROU" +
      "P_RESULT_UNKNOW\020\001\022\037\n\033JOIN_GROUP_RESULT_N" +
      "OT_EXIST\020\002\022 \n\034JOIN_GROUP_RESULT_GROUP_FU" +
      "LL\020\003\022!\n\035JOIN_GROUP_RESULT_IN_BACKLIST\020\004\022",
      "\037\n\033JOIN_GROUP_RESULT_TAKEOUTED\020\005*I\n\017Exit" +
      "GroupResult\022\030\n\024EXIT_GROUP_RESULT_OK\020\000\022\034\n" +
      "\030EXIT_GROUP_RESULT_UNKNOW\020\001*M\n\010ChatType\022" +
      "\024\n\020CHAT_TYPE_UNKNOW\020\000\022\024\n\020CHAT_TYPE_PUBLI" +
      "C\020\001\022\025\n\021CHAT_TYPE_PRIVATE\020\002*/\n\022SessionClo" +
      "seReason\022\n\n\006NORMAL\020\000\022\r\n\tOVER_TIME\020\001*}\n\007M" +
      "sgType\022\021\n\rMSG_TYPE_TEXT\020\000\022\020\n\014MSG_TYPE_IM" +
      "G\020\001\022\022\n\016MSG_TYPE_VOICE\020\002\022\022\n\016MSG_TYPE_VIDE" +
      "O\020\003\022\022\n\016MSG_TYPE_MUSIC\020\004\022\021\n\rMSG_TYPE_NEWS" +
      "\020\005*\243\001\n\017GroupNoticeType\022\032\n\026GROUP_NOTICE_T",
      "YPE_JOIN\020\000\022\032\n\026GROUP_NOTICE_TYPE_EXIT\020\001\022\033" +
      "\n\027GROUP_NOTICE_TYPE_SHARE\020\002\022\031\n\025GROUP_NOT" +
      "ICE_TYPE_BET\020\003\022 \n\034GROUP_NOTICE_TYPE_REDP" +
      "ACKAGE\020\004*\242\001\n\016UserNoticeType\022\033\n\027USER_NOTI" +
      "CE_TYPE_ONLINE\020\000\022\034\n\030USER_NOTICE_TYPE_OFF" +
      "LINE\020\001\022\032\n\026USER_NOTICE_TYPE_SHARE\020\002\022\030\n\024US" +
      "ER_NOTICE_TYPE_BET\020\003\022\037\n\033USER_NOTICE_TYPE" +
      "_REDPACKAGE\020\004*H\n\rAgreementType\022\031\n\025AGREEM" +
      "ENT_TYPE_SOCKET\020\000\022\034\n\030AGREEMENT_TYPE_WEBS" +
      "OCKET\020\001B\"\n\036com.largehat.common.im.packet",
      "sP\001b\006proto3"
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
