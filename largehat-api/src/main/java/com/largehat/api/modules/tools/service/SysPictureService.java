package com.largehat.api.modules.tools.service;


import com.largehat.api.modules.tools.domain.SysPicture;
import com.largehat.api.modules.tools.dto.PictureQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lion
 * @date 2018-12-27
 */
public interface SysPictureService {

    /**
     * 查询图片
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(PictureQueryCriteria criteria, Pageable pageable);

    /**
     * 上传图片
     * @param file
     * @param username
     * @return
     */
    SysPicture upload(MultipartFile file, String username);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    SysPicture findById(Long id);

    /**
     * 删除图片
     * @param picture
     */
    void delete(SysPicture picture);

    /**
     * 删除图片
     * @param ids
     */
    void deleteAll(Long[] ids);
}
