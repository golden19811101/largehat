package com.largehat.admin.modules.im.rest;


import com.largehat.admin.modules.im.domain.ImOrgAuth;
import com.largehat.admin.modules.im.service.ImOrgAuthService;
import com.largehat.admin.modules.im.service.dto.ImOrgAuthQueryCriteria;
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
public class ImOrgAuthController {

    @Autowired
    private ImOrgAuthService imOrgAuthService;

    @Log("查询ImOrgAuth")
    @GetMapping(value = "/imOrgAuth")
    @PreAuthorize("hasAnyRole('ADMIN','IMORGAUTH_ALL','IMORGAUTH_SELECT')")
    public ResponseEntity getImOrgAuths(ImOrgAuthQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imOrgAuthService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImOrgAuth")
    @PostMapping(value = "/imOrgAuth")
    @PreAuthorize("hasAnyRole('ADMIN','IMORGAUTH_ALL','IMORGAUTH_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImOrgAuth resources){
        return new ResponseEntity(imOrgAuthService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImOrgAuth")
    @PutMapping(value = "/imOrgAuth")
    @PreAuthorize("hasAnyRole('ADMIN','IMORGAUTH_ALL','IMORGAUTH_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImOrgAuth resources){
        imOrgAuthService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImOrgAuth")
    @DeleteMapping(value = "/imOrgAuth/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','IMORGAUTH_ALL','IMORGAUTH_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        imOrgAuthService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}