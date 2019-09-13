package com.largehat.admin.modules.client.rest;

import com.largehat.admin.config.DataScope;
import com.largehat.admin.modules.client.domain.OssConfig;
import com.largehat.admin.modules.client.service.OssConfigService;
import com.largehat.admin.modules.client.service.dto.OssConfigQueryCriteria;
import com.largehat.common.core.annotation.Log;
import com.largehat.common.core.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author kafe
* @date 2019-09-12
*/
@RestController
@RequestMapping("api")
public class OssConfigController {

    @Autowired
    private OssConfigService ossConfigService;

    @Autowired
    private DataScope dataScope;

    private static final String ENTITY_NAME = "oss";

    @Log("查询oss配置")
    @GetMapping(value = "/oss")
    @PreAuthorize("hasAnyRole('ADMIN','OSS_ALL','OSS_SELECT')")
    public ResponseEntity getJobs(OssConfigQueryCriteria criteria,
                                  Pageable pageable){
        // 数据权限
//        criteria.setDeptIds(dataScope.getDeptIds());
        return new ResponseEntity(ossConfigService.queryAll(criteria, pageable),HttpStatus.OK);
    }

    @Log("新增oss配置")
    @PostMapping(value = "/oss")
    @PreAuthorize("hasAnyRole('ADMIN','OSS_ALL','OSS_CREATE')")
    public ResponseEntity create(@Validated @RequestBody OssConfig resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(ossConfigService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改oss配置")
    @PutMapping(value = "/oss")
    @PreAuthorize("hasAnyRole('ADMIN','OSS_ALL','OSS_EDIT')")
    public ResponseEntity update(@Validated(OssConfig.Update.class) @RequestBody OssConfig resources){
        ossConfigService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除oss配置")
    @DeleteMapping(value = "/oss/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','OSSALL','OSS_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        ossConfigService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}