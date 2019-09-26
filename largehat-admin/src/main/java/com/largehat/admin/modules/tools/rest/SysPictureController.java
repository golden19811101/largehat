package com.largehat.admin.modules.tools.rest;

import com.largehat.api.modules.tools.domain.SysPicture;
import com.largehat.api.modules.tools.dto.PictureQueryCriteria;
import com.largehat.api.modules.tools.service.SysPictureService;
import com.largehat.common.core.utils.SecurityUtils;
import com.largehat.common.core.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2018/09/20 14:13:32
 */
@RestController
@RequestMapping("/api")
public class SysPictureController {

    @Autowired
    private SysPictureService pictureService;

    @Log("查询图片")
    @PreAuthorize("hasAnyRole('ADMIN','PICTURE_ALL','PICTURE_SELECT')")
    @GetMapping(value = "/pictures")
    public ResponseEntity getRoles(PictureQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(pictureService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    /**
     * 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    @Log("上传图片")
    @PreAuthorize("hasAnyRole('ADMIN','PICTURE_ALL','PICTURE_UPLOAD')")
    @PostMapping(value = "/pictures")
    public ResponseEntity upload(@RequestParam MultipartFile file){
        String userName = SecurityUtils.getUsername();
        SysPicture picture = pictureService.upload(file,userName);
        Map map = new HashMap(3);
        map.put("errno",0);
        map.put("id",picture.getId());
        map.put("data",new String[]{picture.getUrl()});
        return new ResponseEntity(map,HttpStatus.OK);
    }

    /**
     * 删除图片
     * @param id
     * @return
     */
    @Log("删除图片")
    @PreAuthorize("hasAnyRole('ADMIN','PICTURE_ALL','PICTURE_DELETE')")
    @DeleteMapping(value = "/pictures/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        pictureService.delete(pictureService.findById(id));
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除多张图片
     * @param ids
     * @return
     */
    @Log("删除图片")
    @PreAuthorize("hasAnyRole('ADMIN','PICTURE_ALL','PICTURE_DELETE')")
    @DeleteMapping(value = "/pictures")
    public ResponseEntity deleteAll(@RequestBody Long[] ids) {
        pictureService.deleteAll(ids);
        return new ResponseEntity(HttpStatus.OK);
    }
}
