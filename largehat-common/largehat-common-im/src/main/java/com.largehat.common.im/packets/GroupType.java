// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Chat.proto

package com.largehat.common.im.packets;

/**
 * <pre>
 *群组类型
 * </pre>
 *
 * Protobuf enum {@code GroupType}
 */
public enum GroupType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>GROUP_TYPE_UNKNOW = 0;</code>
   */
  GROUP_TYPE_UNKNOW(0),
  /**
   * <pre>
   *固定群
   * </pre>
   *
   * <code>GROUP_TYPE_FIXED = 1;</code>
   */
  GROUP_TYPE_FIXED(1),
  /**
   * <pre>
   *临时群
   * </pre>
   *
   * <code>GROUP_TYPE_TEMP = 2;</code>
   */
  GROUP_TYPE_TEMP(2),
  /**
   * <pre>
   *聊天室
   * </pre>
   *
   * <code>GROUP_TYPE_CHAT = 3;</code>
   */
  GROUP_TYPE_CHAT(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>GROUP_TYPE_UNKNOW = 0;</code>
   */
  public static final int GROUP_TYPE_UNKNOW_VALUE = 0;
  /**
   * <pre>
   *固定群
   * </pre>
   *
   * <code>GROUP_TYPE_FIXED = 1;</code>
   */
  public static final int GROUP_TYPE_FIXED_VALUE = 1;
  /**
   * <pre>
   *临时群
   * </pre>
   *
   * <code>GROUP_TYPE_TEMP = 2;</code>
   */
  public static final int GROUP_TYPE_TEMP_VALUE = 2;
  /**
   * <pre>
   *聊天室
   * </pre>
   *
   * <code>GROUP_TYPE_CHAT = 3;</code>
   */
  public static final int GROUP_TYPE_CHAT_VALUE = 3;


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
  public static GroupType valueOf(int value) {
    return forNumber(value);
  }

  public static GroupType forNumber(int value) {
    switch (value) {
      case 0: return GROUP_TYPE_UNKNOW;
      case 1: return GROUP_TYPE_FIXED;
      case 2: return GROUP_TYPE_TEMP;
      case 3: return GROUP_TYPE_CHAT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<GroupType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      GroupType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<GroupType>() {
          public GroupType findValueByNumber(int number) {
            return GroupType.forNumber(number);
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

  private static final GroupType[] VALUES = values();

  public static GroupType valueOf(
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

  private GroupType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:GroupType)
}

