package com.largehat.common.im.packets.request;

import com.largehat.common.im.packets.Message;

/**
 * 版本: [1.0]
 * 功能说明: 
 * 作者: Lion
 */
public class AuthReqBody extends Message {
	
	private static final long serialVersionUID = -5687459633884615894L;
	private String token;//token验证;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
