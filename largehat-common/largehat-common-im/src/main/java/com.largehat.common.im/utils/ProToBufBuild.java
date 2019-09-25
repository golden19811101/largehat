package com.largehat.common.im.utils;


import com.largehat.common.im.packets.GroupProto;
import com.largehat.common.im.packets.MessageProto;
import com.largehat.common.im.packets.UserProto;

/**
 * <B>ProtoBuf转换类</B>
 */
public class ProToBufBuild {

    /**
     * 获取ptb实例
     * @return
     */
    public static final MessageProto.Message ProToBufInstance(){
        return MessageProto.Message.getDefaultInstance();
    }

    /**
     * <B>封装User对象</B>
     * @param orgId
     * @param avatar
     * @param nickName
     * @param userId
     * @return
     */
    public static final UserProto.User buildUser(Integer orgId, String avatar, String nickName, Integer userId){
        return UserProto.User.newBuilder().setOrgId(orgId).setOrgId(orgId).setNickName(nickName).setUserId(userId).build();
    }

    /**
     * <B>封装群组对象</B>
     * @param groupId
     * @param groupName
     * @param avatar
     * @param groupType
     * @param orgId
     * @param maxNum
     * @return
     */
    public static final GroupProto.Group buildGroup(Integer groupId, String groupName, String avatar, Integer groupType, Integer orgId, Integer maxNum){
        return GroupProto.Group.newBuilder().setGroupId(groupId).setGroupName(groupName).setAvatar(avatar).setGroupTypeValue(groupType).setOrgId(orgId).setMaxNum(maxNum).build();
    }

    /**
     * <B>封装回包对象</B>
     * @param code
     * @param msg
     * @return
     */
    public static final MessageProto.BodyRes buidBodyRes(Integer code, String msg) {
        return MessageProto.BodyRes.newBuilder().setCode(code).setMsg(msg).build();
    }

    /**
     * <B>封装鉴权信息返回</B>
     * @param tonken
     * @return
     */
    public static final MessageProto.AuthRes buidAuthRes(String tonken) {
        return  MessageProto.AuthRes.newBuilder().setTonken(tonken).build();
    }

    /**
     * <B>封装登录返回信息</B>
     * @param tonken
     * @param user
     * @return
     */
    public static final MessageProto.LoginRes buidLoginRes(String tonken, UserProto.User user) {
        return  MessageProto.LoginRes.newBuilder().setTonken(tonken).setUser(user).build();
    }

    /**
     * <B>添加鉴权请求</B>
     * @param authCode
     * @param userId
     * @param passwd
     * @param orgId
     * @return
     */
    public static final MessageProto.AuthReq buidAuthReq(String authCode, String userId, String passwd, Integer orgId) {
        return  MessageProto.AuthReq.newBuilder().setAuthCode(authCode).setUserId(userId).setPasswd(passwd).setOrgId(orgId).build();
    }

    /**
     * <B>登录请求</B>
     * @param tonken
     * @param userId
     * @param deviceType
     * @param deviceId
     * @return
     */
    public static final MessageProto.LoginReq buidLoginReq(String tonken, String userId, Integer deviceType, String deviceId) {
        //return  MessageProto.LoginReq.newBuilder().setTonken(tonken).setUserId(userId).setDeviceTypeValue(deviceType).setDeviceId(deviceId).build();
        return null;
    }

    /**
     * <B>发送消息</B>
     * @param messageId
     * @param from
     * @param to
     * @param groupId
     * @param msgType
     * @param chatType
     * @param content
     * @param sendTime
     * @return
     */
    public static final MessageProto.MessageReq buidMessageReq(String messageId, UserProto.User from, String to, Integer groupId, Integer msgType, Integer chatType, String content, Integer sendTime) {
//        return  MessageProto.MessageReq.newBuilder().
//                setMessageId(messageId).setFrom(from).setTo(to).setGroupId(groupId).
//                setMsgTypeValue(msgType).setChatTypeValue(chatType).setContent(content).setSendTime(sendTime).build();

        return  null;
    }

    /**
     * <B>加入群组封装</B>
     * @param userId
     * @param groupId
     * @param note
     * @return
     */
//    public static final MessageProto.JoinGroupReq buidJoinGroupReq(String userId, String groupId, String note) {
//        return  MessageProto.JoinGroupReq.newBuilder().
//                setUserId(userId).setGroupId(groupId).setNote(note).build();
//    }


    /**
     * <B>退出群组</B>
     * @param userId
     * @param groupId
     * @param note
     * @return
     */
//    public static final MessageProto.ExitGroupReq buidExitGroupReq(String userId, String groupId, String note) {
//        return  MessageProto.ExitGroupReq.newBuilder().
//                setUserId(userId).setGroupId(groupId).setNote(note).build();
//    }

    /**
     * <B>消息撤销</B>
     * @param userId
     * @param groupId
     * @param messageId
     * @return
     */
    public static final MessageProto.CancelMsgReq buidCancelMsgReq(String userId, String groupId, String messageId) {
        return  MessageProto.CancelMsgReq.newBuilder().setUserId(userId).setGroupId(groupId).setMessageId(messageId).build();
    }

    /**
     * <B>群组通知</B>
     * @param user
     * @param groupId
     * @param groupNoticeType
     * @return
     */
    public static final MessageProto.GroupNoticeReq buidGroupNotice(UserProto.User user, String groupId, Integer groupNoticeType) {
        return  MessageProto.GroupNoticeReq.newBuilder().setUser(user).setGroupId(groupId).setGroupNoticeTypeValue(groupNoticeType).build();
    }

    /**
     * <B>用户通知</B>
     * @param user
     * @param userId
     * @param userNoticeType
     * @return
     */
    public static final MessageProto.UserNoticeReq buidUserNotice(UserProto.User user, String userId, Integer userNoticeType) {
        return  MessageProto.UserNoticeReq.newBuilder().setUser(user).setNoticeUserId(userId).setUserNoticeTypeValue(userNoticeType).build();
    }

}
