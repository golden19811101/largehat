package com.largehat.common.im.service;


/**
 * <B>服务器的启动</B>
 */
public interface IServerService {

    public String getServiceId();
    public boolean initialize();

    public boolean startService() throws Exception;
    public boolean stopService() throws Exception;

    public void release();
    public byte getState();
    public boolean isRunning();

}
