package com.largehat.admin.modules.tools.service;


import com.largehat.admin.modules.tools.domain.SysPicture;
import com.largehat.admin.modules.tools.service.dto.PictureQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lion
 * @date 2018-12-27
 */
@CacheConfig(cacheNames = "picture")
public interface SysPictureService {

    /**
     * 查询图片
     * @param criteria
     * @param pageable
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(PictureQueryCriteria criteria, Pageable pageable);

    /**
     * 上传图片
     * @param file
     * @param username
     * @return
     */
    @CacheEvict(allEntries = true)
    SysPicture upload(MultipartFile file, String username);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SysPicture findById(Long id);

    /**
     * 删除图片
     * @param picture
     */
    @CacheEvict(allEntries = true)
    void delete(SysPicture picture);

    /**
     * 删除图片
     * @param ids
     */
    @CacheEvict(allEntries = true)
    void deleteAll(Long[] ids);
}
