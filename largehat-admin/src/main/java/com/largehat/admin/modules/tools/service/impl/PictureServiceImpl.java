package com.largehat.admin.modules.tools.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.largehat.admin.modules.tools.domain.Picture;
import com.largehat.admin.modules.tools.repository.PictureRepository;
import com.largehat.admin.modules.tools.service.PictureService;
import com.largehat.admin.modules.tools.service.dto.PictureQueryCriteria;
import com.largehat.common.core.constant.LargehatConstant;
import com.largehat.common.core.exception.BadRequestException;
import com.largehat.common.core.utils.FileUtil;
import com.largehat.common.core.utils.PageUtil;
import com.largehat.common.core.utils.QueryHelp;
import com.largehat.common.core.utils.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;

/**
 * @author Lion
 * @date 2018-12-27
 */
@Slf4j
@Service(value = "pictureService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public static final String SUCCESS = "success";

    public static final String CODE = "code";

    public static final String MSG = "msg";

    @Override
    public Object queryAll(PictureQueryCriteria criteria, Pageable pageable){
        return PageUtil.toPage(pictureRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Picture upload(MultipartFile multipartFile, String username) {
        File file = FileUtil.toFile(multipartFile);
        HashMap<String, Object> paramMap = new HashMap<>(1);

        paramMap.put("smfile", file);
        String result= HttpUtil.post(LargehatConstant.Url.SM_MS_URL, paramMap);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        Picture picture = null;
        if(!jsonObject.get(CODE).toString().equals(SUCCESS)){
            throw new BadRequestException(jsonObject.get(MSG).toString());
        }
        //转成实体类
        picture = JSON.parseObject(jsonObject.get("data").toString(), Picture.class);
        picture.setSize(FileUtil.getSize(Integer.valueOf(picture.getSize())));
        picture.setUsername(username);
        picture.setFilename(FileUtil.getFileNameNoEx(multipartFile.getOriginalFilename())+"."+FileUtil.getExtensionName(multipartFile.getOriginalFilename()));
        pictureRepository.save(picture);
        //删除临时文件
        FileUtil.del(file);
        return picture;

    }

    @Override
    public Picture findById(Long id) {
        Optional<Picture> picture = pictureRepository.findById(id);
        ValidationUtil.isNull(picture,"Picture","id",id);
        return picture.get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Picture picture) {
        try {
            String result= HttpUtil.get(picture.getDelete());
            pictureRepository.delete(picture);
        } catch(Exception e){
            pictureRepository.delete(picture);
        }

    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            delete(findById(id));
        }
    }
}
