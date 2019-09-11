package com.largehat.common.im.bootstrap;


import java.util.HashMap;
import java.util.Map;

public class ServerServiceManager {

    private static ServerServiceManager instance;
    public static final String SERVICE_ID_ROOT = "SERVICE_ROOT";
    private final Map<String, IServerService> serviceMap = new HashMap<>();

    public static ServerServiceManager getInstance() {
        if (instance == null) {
            instance = new ServerServiceManager();
        }
        return instance;
    }

    public final void registerService(String serviceId, IServerService service)
    {
        serviceMap.put(serviceId, service);
    }

    public final IServerService getService(String serviceId)
    {
        return serviceMap.get(serviceId);
    }

    public final IServerService removeService(String serviceId)
    {
        return serviceMap.remove(serviceId);
    }

}
