// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Chat.proto

package com.largehat.common.im.packets;

/**
 * <pre>
 *退出群组的结果
 * </pre>
 *
 * Protobuf enum {@code ExitGroupResult}
 */
public enum ExitGroupResult
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   *退出群组成功
   * </pre>
   *
   * <code>EXIT_GROUP_RESULT_OK = 0;</code>
   */
  EXIT_GROUP_RESULT_OK(0),
  /**
   * <pre>
   *退出群组失败，原因为其它
   * </pre>
   *
   * <code>EXIT_GROUP_RESULT_UNKNOW = 1;</code>
   */
  EXIT_GROUP_RESULT_UNKNOW(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   *退出群组成功
   * </pre>
   *
   * <code>EXIT_GROUP_RESULT_OK = 0;</code>
   */
  public static final int EXIT_GROUP_RESULT_OK_VALUE = 0;
  /**
   * <pre>
   *退出群组失败，原因为其它
   * </pre>
   *
   * <code>EXIT_GROUP_RESULT_UNKNOW = 1;</code>
   */
  public static final int EXIT_GROUP_RESULT_UNKNOW_VALUE = 1;


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
  public static ExitGroupResult valueOf(int value) {
    return forNumber(value);
  }

  public static ExitGroupResult forNumber(int value) {
    switch (value) {
      case 0: return EXIT_GROUP_RESULT_OK;
      case 1: return EXIT_GROUP_RESULT_UNKNOW;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ExitGroupResult>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ExitGroupResult> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ExitGroupResult>() {
          public ExitGroupResult findValueByNumber(int number) {
            return ExitGroupResult.forNumber(number);
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
        .getEnumTypes().get(4);
  }

  private static final ExitGroupResult[] VALUES = values();

  public static ExitGroupResult valueOf(
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

  private ExitGroupResult(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:ExitGroupResult)
}

