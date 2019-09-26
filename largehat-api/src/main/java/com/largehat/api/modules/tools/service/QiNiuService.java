package com.largehat.api.modules.tools.service;


import com.largehat.api.modules.tools.domain.QiniuConfig;
import com.largehat.api.modules.tools.domain.QiniuContent;
import com.largehat.api.modules.tools.dto.QiniuQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lion
 * @date 2018-12-31
 */
public interface QiNiuService {

    /**
     * 查询文件
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(QiniuQueryCriteria criteria, Pageable pageable);

    /**
     * 查配置
     * @return
     */
    QiniuConfig find();

    /**
     * 修改配置
     * @param qiniuConfig
     * @return
     */
    QiniuConfig update(QiniuConfig qiniuConfig);

    /**
     * 上传文件
     * @param file
     * @param qiniuConfig
     * @return
     */
    QiniuContent upload(MultipartFile file, QiniuConfig qiniuConfig);

    /**
     * 查询文件
     * @param id
     * @return
     */
    QiniuContent findByContentId(Long id);

    /**
     * 下载文件
     * @param content
     * @param config
     * @return
     */
    String download(QiniuContent content, QiniuConfig config);

    /**
     * 删除文件
     * @param content
     * @param config
     * @return
     */
    void delete(QiniuContent content, QiniuConfig config);

    /**
     * 同步数据
     * @param config
     */
    void synchronize(QiniuConfig config);

    /**
     * 删除文件
     * @param ids
     * @param config
     */
    void deleteAll(Long[] ids, QiniuConfig config);
}
