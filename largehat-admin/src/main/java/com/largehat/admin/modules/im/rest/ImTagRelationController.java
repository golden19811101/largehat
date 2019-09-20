package com.largehat.admin.modules.im.rest;


import com.largehat.admin.modules.im.domain.ImTagRelation;
import com.largehat.admin.modules.im.service.ImTagRelationService;
import com.largehat.admin.modules.im.service.dto.ImTagRelationQueryCriteria;
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
public class ImTagRelationController {

    @Autowired
    private ImTagRelationService imTagRelationService;

    @Log("查询ImTagRelation")
    @GetMapping(value = "/imTagRelation")
    @PreAuthorize("hasAnyRole('ADMIN','IMTAGRELATION_ALL','IMTAGRELATION_SELECT')")
    public ResponseEntity getImTagRelations(ImTagRelationQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imTagRelationService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImTagRelation")
    @PostMapping(value = "/imTagRelation")
    @PreAuthorize("hasAnyRole('ADMIN','IMTAGRELATION_ALL','IMTAGRELATION_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImTagRelation resources){
        return new ResponseEntity(imTagRelationService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImTagRelation")
    @PutMapping(value = "/imTagRelation")
    @PreAuthorize("hasAnyRole('ADMIN','IMTAGRELATION_ALL','IMTAGRELATION_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImTagRelation resources){
        imTagRelationService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImTagRelation")
    @DeleteMapping(value = "/imTagRelation/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','IMTAGRELATION_ALL','IMTAGRELATION_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        imTagRelationService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}