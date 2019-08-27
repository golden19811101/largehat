package com.largehat.admin.modules.quartz.task;

import com.largehat.admin.modules.monitor.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Zheng Jie
 * @date 2018-12-25
 */
@Component
public class VisitsTask {

    @Autowired
    private VisitsService visitsService;

    public void run(){
        visitsService.save();
    }
}
