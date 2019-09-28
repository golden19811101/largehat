package com.largehat.server.comsumer;


import com.largehat.api.modules.im.service.ImUserInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class ServerComsumer {

    @Reference(version = "${api.service.version}", check = true)
    private ImUserInfoService imUserInfoService;

    public ImUserInfoService getImUserInfoService() {
        return imUserInfoService;
    }

    public void setImUserInfoService(ImUserInfoService imUserInfoService) {
        this.imUserInfoService = imUserInfoService;
    }
}
