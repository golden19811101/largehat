package com.largehat.admin.modules.im.controller;


import com.largehat.api.modules.im.domain.ImGroup;
import com.largehat.api.modules.im.dto.ImGroupQueryCriteria;
import com.largehat.api.modules.im.service.ImGroupService;
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
public class ImGroupController {

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private ImGroupService imGroupService;

    @Log("查询ImGroup")
    @GetMapping(value = "/imGroup")
    @PreAuthorize("hasAnyRole('ADMIN','IMGROUP_ALL','IMGROUP_SELECT')")
    public ResponseEntity getImGroups(ImGroupQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imGroupService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImGroup")
    @PostMapping(value = "/imGroup")
    @PreAuthorize("hasAnyRole('ADMIN','IMGROUP_ALL','IMGROUP_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImGroup resources){
        return new ResponseEntity(imGroupService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImGroup")
    @PutMapping(value = "/imGroup")
    @PreAuthorize("hasAnyRole('ADMIN','IMGROUP_ALL','IMGROUP_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImGroup resources){
        imGroupService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImGroup")
    @DeleteMapping(value = "/imGroup/{groupId}")
    @PreAuthorize("hasAnyRole('ADMIN','IMGROUP_ALL','IMGROUP_DELETE')")
    public ResponseEntity delete(@PathVariable Integer groupId){
        imGroupService.delete(groupId);
        return new ResponseEntity(HttpStatus.OK);
    }
}