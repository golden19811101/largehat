package com.largehat.server.helper.db;



import com.largehat.common.im.entity.message.MessageHelper;
import com.largehat.common.im.listener.ImBindListener;
import com.largehat.common.im.packets.ChatBody;
import com.largehat.common.im.packets.Group;
import com.largehat.common.im.packets.User;
import com.largehat.common.im.packets.UserMessageData;

import java.util.List;

/**
 * Mysql获取持久化+同步消息助手;
 * @author lion
 */
public class MysqlMessageHelper implements MessageHelper {


	@Override
	public ImBindListener getBindListener() {
		return null;
	}


	@Override
	public void writeMessage(String timelineTable, String timelineId, ChatBody chatBody) {
		
	}

	@Override
	public void removeGroupUser(String userid, String group_id) {
		
	}

	@Override
	public UserMessageData getFriendsOfflineMessage(String userid, String from_userid) {
		return null;
	}


	@Override
	public UserMessageData getFriendHistoryMessage(String userid, String from_userid,Double beginTime,Double endTime,Integer offset,Integer count) {
		return null;
	}

	@Override
	public UserMessageData getGroupHistoryMessage(String userid, String groupid,Double beginTime,Double endTime,Integer offset,Integer count) {
		return null;
	}


	@Override
	public boolean isOnline(String userId, String orgId) {
		return false;
	}

	@Override
	public Group getGroupUsers(String groupId, String orgId, Integer type) {
		return null;
	}

	@Override
	public List<Group> getAllGroupUsers(String userId, String orgId, Integer type) {
		return null;
	}

	@Override
	public Group getFriendUsers(String userId, String orgId, String friendGroupId, Integer type) {
		return null;
	}

	@Override
	public List<Group> getAllFriendUsers(String userId, String orgId, Integer type) {
		return null;
	}

	@Override
	public User getUserByType(String userId, String orgId, Integer type) {
		return null;
	}

	@Override
	public void addGroupUser(String userId, String orgId, String groupId) {

	}

	@Override
	public List<String> getGroupUsers(String groupId, String orgId) {
		return null;
	}

	@Override
	public List<String> getGroups(String userId, String orgId) {
		return null;
	}

	@Override
	public UserMessageData getFriendsOfflineMessage(String userId, String orgId, String fromUserId) {
		return null;
	}

	@Override
	public UserMessageData getGroupOfflineMessage(String userId, String orgId, String groupId) {
		return null;
	}
}
