package com.largehat.common.im.packets.response;

import com.largehat.common.im.packets.Message;
import com.largehat.common.im.packets.User;

/**
 * 版本: [1.0]
 * 功能说明: 退出群组通知消息体
 * 作者: Lion
 */
public class ExitGroupNotifyRespBody extends Message {
	
	private static final long serialVersionUID = 3680734574052114902L;
	private User user;
	private String group;
	
	public User getUser() {
		return user;
	}
	public ExitGroupNotifyRespBody setUser(User user) {
		this.user = user;
		return this;
	}

	public String getGroup() {
		return group;
	}
	public ExitGroupNotifyRespBody setGroup(String group) {
		this.group = group;
		return this;
	}
}
