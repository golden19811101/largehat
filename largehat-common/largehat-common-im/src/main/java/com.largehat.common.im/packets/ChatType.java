// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.largehat.common.im.packets;

/**
 * <pre>
 **
 * 聊天类型
 * </pre>
 *
 * Protobuf enum {@code ChatType}
 */
public enum ChatType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   *未知
   * </pre>
   *
   * <code>CHAT_TYPE_UNKNOW = 0;</code>
   */
  CHAT_TYPE_UNKNOW(0),
  /**
   * <pre>
   *公聊
   * </pre>
   *
   * <code>CHAT_TYPE_PUBLIC = 1;</code>
   */
  CHAT_TYPE_PUBLIC(1),
  /**
   * <pre>
   *私聊
   * </pre>
   *
   * <code>CHAT_TYPE_PRIVATE = 2;</code>
   */
  CHAT_TYPE_PRIVATE(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   *未知
   * </pre>
   *
   * <code>CHAT_TYPE_UNKNOW = 0;</code>
   */
  public static final int CHAT_TYPE_UNKNOW_VALUE = 0;
  /**
   * <pre>
   *公聊
   * </pre>
   *
   * <code>CHAT_TYPE_PUBLIC = 1;</code>
   */
  public static final int CHAT_TYPE_PUBLIC_VALUE = 1;
  /**
   * <pre>
   *私聊
   * </pre>
   *
   * <code>CHAT_TYPE_PRIVATE = 2;</code>
   */
  public static final int CHAT_TYPE_PRIVATE_VALUE = 2;


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
  public static ChatType valueOf(int value) {
    return forNumber(value);
  }

  public static ChatType forNumber(int value) {
    switch (value) {
      case 0: return CHAT_TYPE_UNKNOW;
      case 1: return CHAT_TYPE_PUBLIC;
      case 2: return CHAT_TYPE_PRIVATE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ChatType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ChatType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ChatType>() {
          public ChatType findValueByNumber(int number) {
            return ChatType.forNumber(number);
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
        .getEnumTypes().get(3);
  }

  private static final ChatType[] VALUES = values();

  public static ChatType valueOf(
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

  private ChatType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:ChatType)
}

