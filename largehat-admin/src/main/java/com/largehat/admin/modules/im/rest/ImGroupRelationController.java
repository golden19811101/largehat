package com.largehat.admin.modules.im.rest;


import com.largehat.admin.modules.im.domain.ImGroupRelation;
import com.largehat.admin.modules.im.service.ImGroupRelationService;
import com.largehat.admin.modules.im.service.dto.ImGroupRelationQueryCriteria;
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
public class ImGroupRelationController {

    @Autowired
    private ImGroupRelationService imGroupRelationService;

    @Log("查询ImGroupRelation")
    @GetMapping(value = "/imGroupRelation")
    @PreAuthorize("hasAnyRole('ADMIN','IMGROUPRELATION_ALL','IMGROUPRELATION_SELECT')")
    public ResponseEntity getImGroupRelations(ImGroupRelationQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imGroupRelationService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImGroupRelation")
    @PostMapping(value = "/imGroupRelation")
    @PreAuthorize("hasAnyRole('ADMIN','IMGROUPRELATION_ALL','IMGROUPRELATION_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImGroupRelation resources){
        return new ResponseEntity(imGroupRelationService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImGroupRelation")
    @PutMapping(value = "/imGroupRelation")
    @PreAuthorize("hasAnyRole('ADMIN','IMGROUPRELATION_ALL','IMGROUPRELATION_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImGroupRelation resources){
        imGroupRelationService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImGroupRelation")
    @DeleteMapping(value = "/imGroupRelation/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','IMGROUPRELATION_ALL','IMGROUPRELATION_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        imGroupRelationService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}