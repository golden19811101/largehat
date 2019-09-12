// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: User.proto

package com.largehat.common.im.packets;

public final class UserProto {
  private UserProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface UserOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.largehat.common.im.packets.User)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *用户ID
     * </pre>
     *
     * <code>optional int32 userId = 1;</code>
     */
    int getUserId();

    /**
     * <pre>
     *用户昵称
     * </pre>
     *
     * <code>optional string nickName = 2;</code>
     */
    String getNickName();
    /**
     * <pre>
     *用户昵称
     * </pre>
     *
     * <code>optional string nickName = 2;</code>
     */
    com.google.protobuf.ByteString
        getNickNameBytes();

    /**
     * <pre>
     *头像
     * </pre>
     *
     * <code>optional string avatar = 3;</code>
     */
    String getAvatar();
    /**
     * <pre>
     *头像
     * </pre>
     *
     * <code>optional string avatar = 3;</code>
     */
    com.google.protobuf.ByteString
        getAvatarBytes();

    /**
     * <pre>
     *归属组织机构
     * </pre>
     *
     * <code>optional int32 orgId = 5;</code>
     */
    int getOrgId();
  }
  /**
   * Protobuf type {@code com.largehat.common.im.packets.User}
   */
  public  static final class User extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.largehat.common.im.packets.User)
      UserOrBuilder {
    // Use User.newBuilder() to construct.
    private User(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private User() {
      userId_ = 0;
      nickName_ = "";
      avatar_ = "";
      orgId_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private User(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              userId_ = input.readInt32();
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              nickName_ = s;
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              avatar_ = s;
              break;
            }
            case 40: {

              orgId_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return UserProto.internal_static_com_largehat_common_im_packets_User_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return UserProto.internal_static_com_largehat_common_im_packets_User_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              User.class, Builder.class);
    }

    public static final int USERID_FIELD_NUMBER = 1;
    private int userId_;
    /**
     * <pre>
     *用户ID
     * </pre>
     *
     * <code>optional int32 userId = 1;</code>
     */
    public int getUserId() {
      return userId_;
    }

    public static final int NICKNAME_FIELD_NUMBER = 2;
    private volatile Object nickName_;
    /**
     * <pre>
     *用户昵称
     * </pre>
     *
     * <code>optional string nickName = 2;</code>
     */
    public String getNickName() {
      Object ref = nickName_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        nickName_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *用户昵称
     * </pre>
     *
     * <code>optional string nickName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNickNameBytes() {
      Object ref = nickName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        nickName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int AVATAR_FIELD_NUMBER = 3;
    private volatile Object avatar_;
    /**
     * <pre>
     *头像
     * </pre>
     *
     * <code>optional string avatar = 3;</code>
     */
    public String getAvatar() {
      Object ref = avatar_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        avatar_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *头像
     * </pre>
     *
     * <code>optional string avatar = 3;</code>
     */
    public com.google.protobuf.ByteString
        getAvatarBytes() {
      Object ref = avatar_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        avatar_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ORGID_FIELD_NUMBER = 5;
    private int orgId_;
    /**
     * <pre>
     *归属组织机构
     * </pre>
     *
     * <code>optional int32 orgId = 5;</code>
     */
    public int getOrgId() {
      return orgId_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (userId_ != 0) {
        output.writeInt32(1, userId_);
      }
      if (!getNickNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, nickName_);
      }
      if (!getAvatarBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, avatar_);
      }
      if (orgId_ != 0) {
        output.writeInt32(5, orgId_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (userId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, userId_);
      }
      if (!getNickNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, nickName_);
      }
      if (!getAvatarBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, avatar_);
      }
      if (orgId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, orgId_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof User)) {
        return super.equals(obj);
      }
      User other = (User) obj;

      boolean result = true;
      result = result && (getUserId()
          == other.getUserId());
      result = result && getNickName()
          .equals(other.getNickName());
      result = result && getAvatar()
          .equals(other.getAvatar());
      result = result && (getOrgId()
          == other.getOrgId());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + USERID_FIELD_NUMBER;
      hash = (53 * hash) + getUserId();
      hash = (37 * hash) + NICKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getNickName().hashCode();
      hash = (37 * hash) + AVATAR_FIELD_NUMBER;
      hash = (53 * hash) + getAvatar().hashCode();
      hash = (37 * hash) + ORGID_FIELD_NUMBER;
      hash = (53 * hash) + getOrgId();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static User parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static User parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static User parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static User parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static User parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static User parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static User parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static User parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static User parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static User parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(User prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.largehat.common.im.packets.User}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.largehat.common.im.packets.User)
        UserOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return UserProto.internal_static_com_largehat_common_im_packets_User_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return UserProto.internal_static_com_largehat_common_im_packets_User_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                User.class, Builder.class);
      }

      // Construct using com.largehat.common.im.packets.UserProto.User.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        userId_ = 0;

        nickName_ = "";

        avatar_ = "";

        orgId_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return UserProto.internal_static_com_largehat_common_im_packets_User_descriptor;
      }

      public User getDefaultInstanceForType() {
        return User.getDefaultInstance();
      }

      public User build() {
        User result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public User buildPartial() {
        User result = new User(this);
        result.userId_ = userId_;
        result.nickName_ = nickName_;
        result.avatar_ = avatar_;
        result.orgId_ = orgId_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof User) {
          return mergeFrom((User)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(User other) {
        if (other == User.getDefaultInstance()) return this;
        if (other.getUserId() != 0) {
          setUserId(other.getUserId());
        }
        if (!other.getNickName().isEmpty()) {
          nickName_ = other.nickName_;
          onChanged();
        }
        if (!other.getAvatar().isEmpty()) {
          avatar_ = other.avatar_;
          onChanged();
        }
        if (other.getOrgId() != 0) {
          setOrgId(other.getOrgId());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        User parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (User) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int userId_ ;
      /**
       * <pre>
       *用户ID
       * </pre>
       *
       * <code>optional int32 userId = 1;</code>
       */
      public int getUserId() {
        return userId_;
      }
      /**
       * <pre>
       *用户ID
       * </pre>
       *
       * <code>optional int32 userId = 1;</code>
       */
      public Builder setUserId(int value) {
        
        userId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *用户ID
       * </pre>
       *
       * <code>optional int32 userId = 1;</code>
       */
      public Builder clearUserId() {
        
        userId_ = 0;
        onChanged();
        return this;
      }

      private Object nickName_ = "";
      /**
       * <pre>
       *用户昵称
       * </pre>
       *
       * <code>optional string nickName = 2;</code>
       */
      public String getNickName() {
        Object ref = nickName_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          nickName_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       *用户昵称
       * </pre>
       *
       * <code>optional string nickName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getNickNameBytes() {
        Object ref = nickName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          nickName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *用户昵称
       * </pre>
       *
       * <code>optional string nickName = 2;</code>
       */
      public Builder setNickName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        nickName_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *用户昵称
       * </pre>
       *
       * <code>optional string nickName = 2;</code>
       */
      public Builder clearNickName() {
        
        nickName_ = getDefaultInstance().getNickName();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *用户昵称
       * </pre>
       *
       * <code>optional string nickName = 2;</code>
       */
      public Builder setNickNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        nickName_ = value;
        onChanged();
        return this;
      }

      private Object avatar_ = "";
      /**
       * <pre>
       *头像
       * </pre>
       *
       * <code>optional string avatar = 3;</code>
       */
      public String getAvatar() {
        Object ref = avatar_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          avatar_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       *头像
       * </pre>
       *
       * <code>optional string avatar = 3;</code>
       */
      public com.google.protobuf.ByteString
          getAvatarBytes() {
        Object ref = avatar_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          avatar_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *头像
       * </pre>
       *
       * <code>optional string avatar = 3;</code>
       */
      public Builder setAvatar(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        avatar_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *头像
       * </pre>
       *
       * <code>optional string avatar = 3;</code>
       */
      public Builder clearAvatar() {
        
        avatar_ = getDefaultInstance().getAvatar();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *头像
       * </pre>
       *
       * <code>optional string avatar = 3;</code>
       */
      public Builder setAvatarBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        avatar_ = value;
        onChanged();
        return this;
      }

      private int orgId_ ;
      /**
       * <pre>
       *归属组织机构
       * </pre>
       *
       * <code>optional int32 orgId = 5;</code>
       */
      public int getOrgId() {
        return orgId_;
      }
      /**
       * <pre>
       *归属组织机构
       * </pre>
       *
       * <code>optional int32 orgId = 5;</code>
       */
      public Builder setOrgId(int value) {
        
        orgId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *归属组织机构
       * </pre>
       *
       * <code>optional int32 orgId = 5;</code>
       */
      public Builder clearOrgId() {
        
        orgId_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:com.largehat.common.im.packets.User)
    }

    // @@protoc_insertion_point(class_scope:com.largehat.common.im.packets.User)
    private static final User DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new User();
    }

    public static User getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<User>
        PARSER = new com.google.protobuf.AbstractParser<User>() {
      public User parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new User(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<User> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<User> getParserForType() {
      return PARSER;
    }

    public User getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_largehat_common_im_packets_User_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_largehat_common_im_packets_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\nUser.proto\022\036com.largehat.common.im.pac" +
      "kets\"G\n\004User\022\016\n\006userId\030\001 \001(\005\022\020\n\010nickName" +
      "\030\002 \001(\t\022\016\n\006avatar\030\003 \001(\t\022\r\n\005orgId\030\005 \001(\005B-\n" +
      "\036com.largehat.common.im.packetsB\tUserPro" +
      "toH\001b\006proto3"
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
    internal_static_com_largehat_common_im_packets_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_largehat_common_im_packets_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_largehat_common_im_packets_User_descriptor,
        new String[] { "UserId", "NickName", "Avatar", "OrgId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}