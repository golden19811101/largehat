package com.largehat.common.im.bootstrap;


/**
 * <B>服务器的启动</B>
 */
public interface IServerService {
    //获取服务Id
    public String getServiceId();
    //初始化
    public boolean initialize();
    //初始化数据信息
    public void initData();

    //启动服务
    public boolean startService() throws Exception;
    //停止服务
    public boolean stopService() throws Exception;

    public void release();
    public byte getState();
    public boolean isRunning();

}
