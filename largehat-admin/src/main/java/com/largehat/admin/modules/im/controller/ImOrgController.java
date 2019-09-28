package com.largehat.admin.modules.im.controller;




import com.largehat.api.modules.im.domain.ImOrg;
import com.largehat.api.modules.im.dto.ImOrgQueryCriteria;
import com.largehat.api.modules.im.service.ImOrgService;
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
public class ImOrgController {

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private ImOrgService imOrgService;

    @Log("查询ImOrg")
    @GetMapping(value = "/imOrg")
    @PreAuthorize("hasAnyRole('ADMIN','IMORG_ALL','IMORG_SELECT')")
    public ResponseEntity getImOrgs(ImOrgQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(imOrgService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ImOrg")
    @PostMapping(value = "/imOrg")
    @PreAuthorize("hasAnyRole('ADMIN','IMORG_ALL','IMORG_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ImOrg resources){
        return new ResponseEntity(imOrgService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ImOrg")
    @PutMapping(value = "/imOrg")
    @PreAuthorize("hasAnyRole('ADMIN','IMORG_ALL','IMORG_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ImOrg resources){
        imOrgService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ImOrg")
    @DeleteMapping(value = "/imOrg/{orgId}")
    @PreAuthorize("hasAnyRole('ADMIN','IMORG_ALL','IMORG_DELETE')")
    public ResponseEntity delete(@PathVariable Integer orgId){
        imOrgService.delete(orgId);
        return new ResponseEntity(HttpStatus.OK);
    }
}