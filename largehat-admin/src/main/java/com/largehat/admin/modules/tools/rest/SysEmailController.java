package com.largehat.admin.modules.tools.rest;

import lombok.extern.slf4j.Slf4j;
import com.largehat.common.core.annotation.Log;
import com.largehat.admin.modules.tools.domain.SysEmailConfig;
import com.largehat.admin.modules.tools.domain.vo.EmailVo;
import com.largehat.admin.modules.tools.service.SysEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 发送邮件
 * @date 2018/09/28 6:55:53
 */
@Slf4j
@RestController
@RequestMapping("api")
public class SysEmailController {

    @Autowired
    private SysEmailService emailService;

    @GetMapping(value = "/email")
    public ResponseEntity get(){
        return new ResponseEntity(emailService.find(),HttpStatus.OK);
    }

    @Log("配置邮件")
    @PutMapping(value = "/email")
    public ResponseEntity emailConfig(@Validated @RequestBody SysEmailConfig emailConfig){
        emailService.update(emailConfig,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("发送邮件")
    @PostMapping(value = "/email")
    public ResponseEntity send(@Validated @RequestBody EmailVo emailVo) throws Exception {
        log.warn("REST request to send Email : {}" +emailVo);
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }
}