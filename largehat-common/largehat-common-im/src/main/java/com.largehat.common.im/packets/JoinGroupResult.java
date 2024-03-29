// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Chat.proto

package com.largehat.common.im.packets;

/**
 * <pre>
 *加入群组申请的结果
 * </pre>
 *
 * Protobuf enum {@code JoinGroupResult}
 */
public enum JoinGroupResult
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   *允许进入
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_OK = 0;</code>
   */
  JOIN_GROUP_RESULT_OK(0),
  /**
   * <pre>
   *不允许进入，原因为其它
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_UNKNOW = 1;</code>
   */
  JOIN_GROUP_RESULT_UNKNOW(1),
  /**
   * <pre>
   *组不存在
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_NOT_EXIST = 2;</code>
   */
  JOIN_GROUP_RESULT_NOT_EXIST(2),
  /**
   * <pre>
   *组满
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_GROUP_FULL = 3;</code>
   */
  JOIN_GROUP_RESULT_GROUP_FULL(3),
  /**
   * <pre>
   *在黑名单中
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_IN_BACKLIST = 4;</code>
   */
  JOIN_GROUP_RESULT_IN_BACKLIST(4),
  /**
   * <pre>
   *被踢
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_TAKEOUTED = 5;</code>
   */
  JOIN_GROUP_RESULT_TAKEOUTED(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   *允许进入
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_OK = 0;</code>
   */
  public static final int JOIN_GROUP_RESULT_OK_VALUE = 0;
  /**
   * <pre>
   *不允许进入，原因为其它
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_UNKNOW = 1;</code>
   */
  public static final int JOIN_GROUP_RESULT_UNKNOW_VALUE = 1;
  /**
   * <pre>
   *组不存在
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_NOT_EXIST = 2;</code>
   */
  public static final int JOIN_GROUP_RESULT_NOT_EXIST_VALUE = 2;
  /**
   * <pre>
   *组满
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_GROUP_FULL = 3;</code>
   */
  public static final int JOIN_GROUP_RESULT_GROUP_FULL_VALUE = 3;
  /**
   * <pre>
   *在黑名单中
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_IN_BACKLIST = 4;</code>
   */
  public static final int JOIN_GROUP_RESULT_IN_BACKLIST_VALUE = 4;
  /**
   * <pre>
   *被踢
   * </pre>
   *
   * <code>JOIN_GROUP_RESULT_TAKEOUTED = 5;</code>
   */
  public static final int JOIN_GROUP_RESULT_TAKEOUTED_VALUE = 5;


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
  public static JoinGroupResult valueOf(int value) {
    return forNumber(value);
  }

  public static JoinGroupResult forNumber(int value) {
    switch (value) {
      case 0: return JOIN_GROUP_RESULT_OK;
      case 1: return JOIN_GROUP_RESULT_UNKNOW;
      case 2: return JOIN_GROUP_RESULT_NOT_EXIST;
      case 3: return JOIN_GROUP_RESULT_GROUP_FULL;
      case 4: return JOIN_GROUP_RESULT_IN_BACKLIST;
      case 5: return JOIN_GROUP_RESULT_TAKEOUTED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<JoinGroupResult>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      JoinGroupResult> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<JoinGroupResult>() {
          public JoinGroupResult findValueByNumber(int number) {
            return JoinGroupResult.forNumber(number);
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

  private static final JoinGroupResult[] VALUES = values();

  public static JoinGroupResult valueOf(
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

  private JoinGroupResult(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:JoinGroupResult)
}

