package com.largehat.admin.modules.im.rest;


import com.largehat.admin.modules.im.domain.ImTagGroup;
import com.largehat.admin.modules.im.service.ImTagGroupService;
import com.largehat.admin.modules.im.service.dto.ImTagGroupQueryCriteria;
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
public class ImTagGroupController {

    @Autowired
    private ImTagGroupService imTagGroupService;

    @Log("查询ImTagGroup")
    @GetMapping(value = "/imTagGroup")
    @PreAuthorize("hasAnyRole('ADMIN','IMTAGGROUP_ALL','IMTAGGROUP_SELECT')")
    public ResponseEntity getImTagGroups(ImTagGroupQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imTagGroupService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImTagGroup")
    @PostMapping(value = "/imTagGroup")
    @PreAuthorize("hasAnyRole('ADMIN','IMTAGGROUP_ALL','IMTAGGROUP_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImTagGroup resources){
        return new ResponseEntity(imTagGroupService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImTagGroup")
    @PutMapping(value = "/imTagGroup")
    @PreAuthorize("hasAnyRole('ADMIN','IMTAGGROUP_ALL','IMTAGGROUP_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImTagGroup resources){
        imTagGroupService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImTagGroup")
    @DeleteMapping(value = "/imTagGroup/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','IMTAGGROUP_ALL','IMTAGGROUP_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        imTagGroupService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}