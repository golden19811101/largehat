package com.largehat.admin.modules.im.controller;


import com.largehat.api.modules.im.domain.ImMessage;
import com.largehat.api.modules.im.dto.ImMessageQueryCriteria;
import com.largehat.api.modules.im.service.ImMessageService;
import com.largehat.common.core.annotation.Log;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author
* @date 2019-09-18
*/
@RestController
@RequestMapping("api")
public class ImMessageController {

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private ImMessageService imMessageService;

    @Log("查询ImMessage")
    @GetMapping(value = "/imMessage")
    @PreAuthorize("hasAnyRole('ADMIN','IMMESSAGE_ALL','IMMESSAGE_SELECT')")
    public ResponseEntity getImMessages(ImMessageQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imMessageService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImMessage")
    @PostMapping(value = "/imMessage")
    @PreAuthorize("hasAnyRole('ADMIN','IMMESSAGE_ALL','IMMESSAGE_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImMessage resources){
        return new ResponseEntity(imMessageService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImMessage")
    @PutMapping(value = "/imMessage")
    @PreAuthorize("hasAnyRole('ADMIN','IMMESSAGE_ALL','IMMESSAGE_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImMessage resources){
        imMessageService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImMessage")
    @DeleteMapping(value = "/imMessage/{messageId}")
    @PreAuthorize("hasAnyRole('ADMIN','IMMESSAGE_ALL','IMMESSAGE_DELETE')")
    public ResponseEntity delete(@PathVariable Long messageId){
        imMessageService.delete(messageId);
        return new ResponseEntity(HttpStatus.OK);
    }
}