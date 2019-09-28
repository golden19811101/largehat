package com.largehat.admin.modules.system.controller;


import com.largehat.api.modules.security.service.DataScopeService;
import com.largehat.api.modules.system.domain.SysDept;
import com.largehat.api.modules.system.dto.SysDeptDTO;
import com.largehat.api.modules.system.dto.SysDeptQueryCriteria;
import com.largehat.api.modules.system.service.SysDeptService;
import com.largehat.common.core.annotation.Log;
import com.largehat.common.core.exception.BadRequestException;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @author Lion
* @date 2019-03-25
*/
@RestController
@RequestMapping("api")
public class SysDeptController {

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private SysDeptService deptService;

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private DataScopeService  dataScopeService;

    private static final String ENTITY_NAME = "dept";

    @Log("查询部门")
    @GetMapping(value = "/dept")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_SELECT','DEPT_ALL','DEPT_SELECT')")
    public ResponseEntity getDepts(SysDeptQueryCriteria criteria){
        // 数据权限
        criteria.setIds(dataScopeService.getDeptIds());
        List<SysDeptDTO> deptDTOS = deptService.queryAll(criteria);
        return new ResponseEntity(deptService.buildTree(deptDTOS),HttpStatus.OK);
    }

    @Log("新增部门")
    @PostMapping(value = "/dept")
    @PreAuthorize("hasAnyRole('ADMIN','DEPT_ALL','DEPT_CREATE')")
    public ResponseEntity create(@Validated @RequestBody SysDept resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(deptService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改部门")
    @PutMapping(value = "/dept")
    @PreAuthorize("hasAnyRole('ADMIN','DEPT_ALL','DEPT_EDIT')")
    public ResponseEntity update(@Validated(SysDept.Update.class) @RequestBody SysDept resources){
        deptService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除部门")
    @DeleteMapping(value = "/dept/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DEPT_ALL','DEPT_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        deptService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}