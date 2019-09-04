package com.largehat.server.config;


public class ImConfig {

    /**
     * 默认绑定的IP地址
     */
    protected String bindIp = null;
    /**
     * 监听端口
     */
    protected Integer bindPort = 80;
    /**
     * 心跳包发送时长heartbeatTimeout/2
     */
    protected long heartbeatTimeout = 0;
    /**
     * 是否开启持久化;
     */
    protected String isStore = "off";
    /**
     * 是否开启集群;
     */
    protected String isCluster = "off";
    /**
     *  默认的接收数据的buffer size
     */
    protected long readBufferSize = 1024 * 2;









}
