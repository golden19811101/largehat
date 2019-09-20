package com.largehat.admin.modules.im.rest;


import com.largehat.admin.modules.im.domain.ImFriend;
import com.largehat.admin.modules.im.service.ImFriendService;
import com.largehat.admin.modules.im.service.dto.ImFriendQueryCriteria;
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
public class ImFriendController {

    @Autowired
    private ImFriendService imFriendService;

    @Log("查询ImFriend")
    @GetMapping(value = "/imFriend")
    @PreAuthorize("hasAnyRole('ADMIN','IMFRIEND_ALL','IMFRIEND_SELECT')")
    public ResponseEntity getImFriends(ImFriendQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imFriendService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImFriend")
    @PostMapping(value = "/imFriend")
    @PreAuthorize("hasAnyRole('ADMIN','IMFRIEND_ALL','IMFRIEND_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImFriend resources){
        return new ResponseEntity(imFriendService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImFriend")
    @PutMapping(value = "/imFriend")
    @PreAuthorize("hasAnyRole('ADMIN','IMFRIEND_ALL','IMFRIEND_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImFriend resources){
        imFriendService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImFriend")
    @DeleteMapping(value = "/imFriend/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','IMFRIEND_ALL','IMFRIEND_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        imFriendService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}