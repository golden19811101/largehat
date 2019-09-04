package com.largehat.common.im.packets;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lion
 */
public class UserMessageData implements Serializable {

	private static final long serialVersionUID = -1367597924020299919L;
	private String userid;//用户id;
	private Map<String, List<ChatBody>> friends = new HashMap<>();//好友消息;
	private Map<String, List<ChatBody>> groups = new HashMap<>();//群组消息;

	public UserMessageData() {
	}

	public UserMessageData(String userid) {
		this.userid = userid;
	}

	public Map<String, List<ChatBody>> getFriends() {
		return friends;
	}

	public void setFriends(Map<String, List<ChatBody>> friends) {
		this.friends = friends;
	}

	public Map<String, List<ChatBody>> getGroups() {
		return groups;
	}

	public void setGroups(Map<String, List<ChatBody>> groups) {
		this.groups = groups;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
