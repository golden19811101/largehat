package com.largehat.server.config;


import com.largehat.common.im.config.Config;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ImConfiguration extends Config {

    /**
     * IP地址
     */
    @Value("${im.config.bindIp}")
    protected String bindIp = null;

    /**
     * 监听端口
     */
    @Value("${im.config.bindPort}")
    protected Integer bindPort = 6789;

    /**
     * 心跳包发送时长
     */
    @Value("${im.config.heartbeatTimeout}")
    protected long heartbeatTimeout = 0;

    /**
     * 是否开启持久化;
     */
    @Value("${im.config.isStore}")
    protected String isStore = "off";

    /**
     * 是否开启集群;
     */
    @Value("${im.config.isCluster}")
    protected String isCluster = "off";

    /**
     *  默认的接收数据的buffer size
     */
    @Value("${im.config.readBufferSize}")
    protected long readBufferSize = 1024 * 2;
}
