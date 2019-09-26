package com.largehat.admin.modules.quartz.task;


import com.largehat.api.modules.monitor.service.SysVisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lion
 * @date 2018-12-25
 */
@Component
public class VisitsTask {

    @Autowired
    private SysVisitsService visitsService;

    public void run(){
        visitsService.save();
    }
}
