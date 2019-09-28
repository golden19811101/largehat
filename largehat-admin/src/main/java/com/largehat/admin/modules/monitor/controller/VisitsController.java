package com.largehat.admin.modules.monitor.controller;


import com.largehat.api.modules.monitor.service.SysVisitsService;
import com.largehat.common.core.utils.RequestHolder;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lion
 * @date 2018-12-13
 */
@RestController
@RequestMapping("api")
public class VisitsController {

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private SysVisitsService visitsService;

    @PostMapping(value = "/visits")
    public ResponseEntity create(){
        visitsService.count(RequestHolder.getHttpServletRequest());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/visits")
    public ResponseEntity get(){
        return new ResponseEntity(visitsService.get(),HttpStatus.OK);
    }

    @GetMapping(value = "/visits/chartData")
    public ResponseEntity getChartData(){
        return new ResponseEntity(visitsService.getChartData(),HttpStatus.OK);
    }
}
