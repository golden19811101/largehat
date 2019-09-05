package com.largehat.common.im.packets.response;


import com.largehat.common.im.entity.Status;
import com.largehat.common.im.packets.RespBody;
import com.largehat.common.im.packets.User;
import com.largehat.common.im.packets.command.Command;

/**
 * 版本: [1.0]
 * 功能说明: 
 * 作者: Lion
 */
public class LoginRespBody extends RespBody {
	
	private static final long serialVersionUID = 1L;
	
	private String token;
	private User user;

	public LoginRespBody(Command command , Status status){
		this(command,status,null);
	}

	public LoginRespBody(Command command , Status status , User user){
		super(command, status);
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public void clear() {
		setToken(null);
		setUser(null);
	}
}
