package com.largehat.common.im.entity.session;


import com.largehat.common.im.packets.SessionCloseReason;
import com.largehat.common.im.packets.User;
import com.largehat.common.im.utils.ChannelUtils;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * <B>定义session对象</B>
 */
@Slf4j
public class IoSession implements Serializable {

    /** distributeKey auto generator  */
    private AtomicInteger dispatchKeyGenerator = new AtomicInteger();

    /** 网络连接channel */
    private Channel channel;

    private User user;

    /** ip地址 */
    private String ipAddr;

    private boolean reconnected;

    /** 业务分发索引 */
    private int dispatchKey;

    /** 拓展用，保存一些个人数据  */
    private Map<String, Object> attrs = new HashMap<>();

    public IoSession() {

    }

    public IoSession(Channel channel) {
        this.channel = channel;
        this.ipAddr = ChannelUtils.getIp(channel);
        this.dispatchKey = dispatchKeyGenerator.getAndIncrement();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public int getDispatchKey() {
        return dispatchKey;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public boolean isReconnected() {
        return reconnected;
    }

    public void setReconnected(boolean reconnected) {
        this.reconnected = reconnected;
    }

    public User getUser() {
        return user;
    }

    public boolean isClose() {
        if (channel == null) {
            return true;
        }
        return !channel.isActive() ||
                !channel.isOpen();
    }

    /**
     * 关闭session
     * @param reason {@link SessionCloseReason}
     */
    public void close(SessionCloseReason reason) {
        try{
            if (this.channel == null) {
                return;
            }
            if (channel.isOpen()) {
                channel.close();
                log.info("close session[{}], reason is {}", getUser().getId(), reason);
            }else{
                log.info("session[{}] already close, reason is {}", getUser().getId(), reason);
            }
        }catch(Exception e){
        }
    }
}
