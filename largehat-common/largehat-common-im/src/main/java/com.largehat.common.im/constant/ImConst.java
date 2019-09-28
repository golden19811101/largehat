package com.largehat.common.im.constant;

/**
 * @author Lion
 */
public interface ImConst {
	public static final String AUTH_KEY = "authKey";
	
	public static final int SERVER_PORT = 8888;
	
	public static final String CHARSET = "utf-8";
	
	public static final String TO = "to";
	
	public static final String CHANNEL = "channel";
	
	public static final String PACKET = "packet";
	
	public static final String STATUS = "status";
	
	public static final String HTTP_REQUEST = "httpRequest";

	public static final String CHAT_QUEUE = "chat_queue";
	
	public static final String STORE = "store";
	
	public static final String PUSH = "push";
	
	public static final String CHAT = "chat";

    /*************************************************************************添加缓存标识定义Start*********************************************************************************/
	//组织机构信息
	public static final String ORG = "org";
	//组织机构鉴权信息
    public static final String ORG_AUTH = "org_auth";
    //用户tonken信息
    public static final String TONKEN = "tonken";
    //群组信息
    public static final String GROUP = "group";
    //用户信息
    public static final String USER = "user";
	//朋友信息
	public static final String FRIEND = "friend";
    //消息信息
	public static final String MESSAGE = "message";
    //通知
	public static final String NOTICE = "notice";
	//请求信息
	public static final String REQUEST = "request";
    //离线通知
	public static final String OFFLINE_NOTICE = "offline_notice";
    //离线消息
	public static final String OFFLINE_MESSAGE = "offline_message";
	//离线请求
	public static final String OFFLINE_REQUEST = "offline_request";
    //特殊符号列表
    public static final String ORG_SPECIAL = "org_special";
    //群组特殊符号
    public static final String GROUP_SPECIAL = "group_special";
    //群组禁言列表
    public static final String GROUP_PROHIBIT = "group_prohibit";
    //群组黑名单列表
    public static final String GROUP_BLACK= "group_bliack";
    //群组管理员列表
    public static final String GROUP_MANAGE= "group_manage";
    //用户黑名单列表
    public static final String USER_BLACK= "user_black";

    /*********************************************************************添加缓存标识定义End***************************************************************************************/

	public static final String TERMINAL = "terminal";
	
	public static final String INFO = "info";
	
	public static final String FRIENDS = "friends";
	
	public static final String ONLINE = "online";
	
	public static final String OFFLINE = "offline";
	
	public static final String ON = "on";
	
	public static final String OFF = "off";
	
	public static final String IM = "IM";
	
	public static final String CONVERTER = "converter";

	public static final String BASE_ASYNC_CHAT_MESSAGE_PROCESSOR = "base_async_chat_message_processor";
	
}
