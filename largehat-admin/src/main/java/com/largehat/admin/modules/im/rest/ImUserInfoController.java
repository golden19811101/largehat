package com.largehat.admin.modules.im.rest;


import com.largehat.admin.modules.im.domain.ImUserInfo;
import com.largehat.admin.modules.im.service.ImUserInfoService;
import com.largehat.admin.modules.im.service.dto.ImUserInfoQueryCriteria;
import com.largehat.common.core.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ImUserInfoController {

    @Autowired
    private ImUserInfoService imUserInfoService;

    @Log("查询ImUserInfo")
    @GetMapping(value = "/imUserInfo")
    @PreAuthorize("hasAnyRole('ADMIN','IMUSERINFO_ALL','IMUSERINFO_SELECT')")
    public ResponseEntity getImUserInfos(ImUserInfoQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imUserInfoService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImUserInfo")
    @PostMapping(value = "/imUserInfo")
    @PreAuthorize("hasAnyRole('ADMIN','IMUSERINFO_ALL','IMUSERINFO_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImUserInfo resources){
        return new ResponseEntity(imUserInfoService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImUserInfo")
    @PutMapping(value = "/imUserInfo")
    @PreAuthorize("hasAnyRole('ADMIN','IMUSERINFO_ALL','IMUSERINFO_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImUserInfo resources){
        imUserInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImUserInfo")
    @DeleteMapping(value = "/imUserInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','IMUSERINFO_ALL','IMUSERINFO_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        imUserInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}