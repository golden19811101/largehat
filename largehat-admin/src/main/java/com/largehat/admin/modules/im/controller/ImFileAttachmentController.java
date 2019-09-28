package com.largehat.admin.modules.im.controller;



import com.largehat.api.modules.im.domain.ImFileAttachment;
import com.largehat.api.modules.im.dto.ImFileAttachmentQueryCriteria;
import com.largehat.api.modules.im.service.ImFileAttachmentService;
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
public class ImFileAttachmentController {

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private ImFileAttachmentService imFileAttachmentService;

    @Log("查询ImFileAttachment")
    @GetMapping(value = "/imFileAttachment")
    @PreAuthorize("hasAnyRole('ADMIN','IMFILEATTACHMENT_ALL','IMFILEATTACHMENT_SELECT')")
    public ResponseEntity getImFileAttachments(ImFileAttachmentQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imFileAttachmentService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImFileAttachment")
    @PostMapping(value = "/imFileAttachment")
    @PreAuthorize("hasAnyRole('ADMIN','IMFILEATTACHMENT_ALL','IMFILEATTACHMENT_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImFileAttachment resources){
        return new ResponseEntity(imFileAttachmentService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImFileAttachment")
    @PutMapping(value = "/imFileAttachment")
    @PreAuthorize("hasAnyRole('ADMIN','IMFILEATTACHMENT_ALL','IMFILEATTACHMENT_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImFileAttachment resources){
        imFileAttachmentService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImFileAttachment")
    @DeleteMapping(value = "/imFileAttachment/{fileId}")
    @PreAuthorize("hasAnyRole('ADMIN','IMFILEATTACHMENT_ALL','IMFILEATTACHMENT_DELETE')")
    public ResponseEntity delete(@PathVariable Integer fileId){
        imFileAttachmentService.delete(fileId);
        return new ResponseEntity(HttpStatus.OK);
    }
}