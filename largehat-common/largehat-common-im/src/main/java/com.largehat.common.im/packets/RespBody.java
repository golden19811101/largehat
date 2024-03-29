package com.largehat.common.im.packets;


import com.largehat.common.im.constant.Status;
import com.largehat.common.im.packets.command.Command;
import com.largehat.common.im.utils.JsonKit;

import java.io.Serializable;

/**
 * 版本: [1.0]
 * 功能说明: 
 * 作者: Lion
 */
public class RespBody implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer code;//响应状态码;
	
	private String msg;//响应状态信息提示;
	
	private Command command;//响应cmd命令码;
	
	private Object data;//响应数据;

	public RespBody(){}
	public RespBody(Command command){
		this.command = command;
	}
	public RespBody(Command command, Object data){
		this(command);
		this.data = data;
	}
	public RespBody(Command command , Status status){
		this(command);
		this.code = status.getCode();
		this.msg = status.getMsg();
	}
	public RespBody(Status status){
		this.code = status.getCode();
		this.msg = status.getMsg();
	}
	public Integer getCode() {
		return code;
	}

	public RespBody setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public RespBody setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Command getCommand() {
		return command;
	}

	public RespBody setCommand(Command command) {
		this.command = command;
		return this;
	}
	public Object getData() {
		return data;
	}
	public RespBody setData(Object data) {
		this.data = data;
		return this;
	}
	@Override
	public String toString() {
		return JsonKit.toJSONEnumNoUsingName(this);
	}
	
	public byte[] toByte(){
		return JsonKit.toJSONBytesEnumNoUsingName(this);
	}
	
	public void clear(){};
}
