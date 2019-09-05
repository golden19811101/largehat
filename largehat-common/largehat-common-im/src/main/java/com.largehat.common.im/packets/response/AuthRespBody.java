package com.largehat.common.im.packets.response;

import com.largehat.common.im.packets.Message;

/**
 * 版本: [1.0]
 * 功能说明: 
 * 作者: Lion
 */
public class AuthRespBody extends Message {
    
	private static final long serialVersionUID = -2985356076555121875L;
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
