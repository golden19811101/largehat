package com.largehat.server.base.cache;


import com.largehat.api.modules.im.dto.ImUserInfoDTO;
import com.largehat.api.modules.im.service.ImUserInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <B>启动时加载mysql数据保存到redis中</B>
 */

@Component
public class LoadRedisCache implements ApplicationRunner {

    @Reference(version = "${api.service.version}", check = true)
    private ImUserInfoService imUserInfoService;

    //开一个线程执行数据的加载
    @Async
    public void loadUserInfo() {
        try {
            long start = System.currentTimeMillis();
            Thread.sleep(1000);
            long end = System.currentTimeMillis();
            ImUserInfoDTO dto = imUserInfoService.findById(1);
            System.out.println(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.loadUserInfo();
    }
}
