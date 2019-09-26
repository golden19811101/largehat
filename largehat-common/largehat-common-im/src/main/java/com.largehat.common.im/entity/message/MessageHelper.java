package com.largehat.common.im.entity.message;


import com.largehat.common.im.listener.ImBindListener;
import com.largehat.common.im.packets.ChatBody;
import com.largehat.common.im.packets.Group;
import com.largehat.common.im.packets.User;
import com.largehat.common.im.packets.UserMessageData;

import java.util.List;


/**
 * @author Lion
 */
public interface MessageHelper {
	/**
	 * 获取im群组、人员绑定监听器;
	 * @return
	 */
	public ImBindListener getBindListener();
	/**
	 * 判断用户是否在线
	 * @param userId
	 * @return
	 */
	public boolean isOnline(String userId, String orgId);
	/**
	 * 获取群组所有成员信息(根据type区分在线还是离线)
	 * @param groupId
	 * @param orgId
	 * @param type(0:所有在线用户,1:所有离线用户,2:所有用户[在线+离线])
	 * @return
	 */
	public Group getGroupUsers(String groupId, String orgId, Integer type);
	/**
	 * 获取群组所有成员信息（在线+离线)
	 * @param userId
	 * @param orgId
	 * @param type(0:所有在线用户,1:所有离线用户,2:所有用户[在线+离线])
	 * @return
	 */
	public List<Group> getAllGroupUsers(String userId, String orgId, Integer type);
	/**
	 * 获取好友分组所有成员信息
	 * @param userId
	 * @param friendGroupId
	 * @param type(0:所有在线用户,1:所有离线用户,2:所有用户[在线+离线])
	 * @return
	 */
	public Group getFriendUsers(String userId, String orgId, String friendGroupId, Integer type);
	/**
	 * 获取好友分组所有成员信息
	 * @param userId
	 * @param type(0:所有在线用户,1:所有离线用户,2:所有用户[在线+离线])
	 * @return
	 */
	public List<Group> getAllFriendUsers(String userId, String orgId,  Integer type);
	/**
	 * 根据在线类型获取用户信息;
	 * @param userId
	 * @param type(0:所有在线用户,1:所有离线用户,2:所有用户[在线+离线])
	 * @return
	 */
	public User getUserByType(String userId, String orgId, Integer type);
	/**
	 * 添加群组成员
	 * @param userId
	 * @param groupId
	 */
	public void addGroupUser(String userId, String orgId, String groupId);
	/**
	 * 获取群组所有成员;
	 * @param groupId
	 * @return
	 */
	public List<String> getGroupUsers(String groupId, String orgId);
	/**
	 * 获取用户拥有的群组;
	 * @param userId
	 * @return
	 */
	public List<String> getGroups(String userId, String orgId);
	/**
	 * 消息持久化写入
	 * @param timelineTable
	 * @param timelineId
	 * @param chatBody
	 */
	public void writeMessage(String timelineTable, String timelineId,  ChatBody chatBody);
	/**
	 * 移除群组用户
	 * @param userId
	 * @param groupId
	 */
	public void removeGroupUser(String userId, String groupId);
	/**
	 * 获取与指定用户离线消息;
	 * @param userId
	 * @param fromUserId
	 * @return
	 */
	public UserMessageData getFriendsOfflineMessage(String userId, String orgId, String fromUserId);
	/**
	 * 获取与所有用户离线消息;
	 * @param userId
	 * @return
	 */
	public UserMessageData getFriendsOfflineMessage(String userId, String orgId);
	/**
	 * 获取用户指定群组离线消息;
	 * @param userId
	 * @param orgId
	 * @param groupId
	 * @return
	 */
	public UserMessageData getGroupOfflineMessage(String userId, String orgId, String groupId);
	/**
	 * 获取与指定用户历史消息;
	 * @param userId
	 * @param fromUserId
	 * @param beginTime 消息区间开始时间
	 * @param endTime 消息区间结束时间
	 * @param offset 分页偏移量
	 * @param count 数量
	 * @return
	 */
	public UserMessageData getFriendHistoryMessage(String userId, String fromUserId, Double beginTime, Double endTime, Integer offset, Integer count);

	/**
	 * 获取与指定群组历史消息;
	 * @param userId
	 * @param groupid
	 * @param beginTime 消息区间开始时间
	 * @param endTime 消息区间结束时间
	 * @param offset 分页偏移量
	 * @param count 数量
	 * @return
	 */
	public UserMessageData getGroupHistoryMessage(String userId, String groupid, Double beginTime, Double endTime, Integer offset, Integer count);
}
