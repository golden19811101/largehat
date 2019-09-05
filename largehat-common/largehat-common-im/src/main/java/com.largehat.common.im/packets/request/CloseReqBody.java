package com.largehat.common.im.packets.request;

import com.largehat.common.im.packets.Message;

/**
 * @author Lion
 */
public class CloseReqBody extends Message {

	private static final long serialVersionUID = 771895783302296339L;
	public CloseReqBody(){};
	public CloseReqBody(String userid){
		this.userid = userid;
	}
	private String userid;//用户id;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
