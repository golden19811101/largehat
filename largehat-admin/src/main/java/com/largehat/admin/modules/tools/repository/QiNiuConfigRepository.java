package com.largehat.admin.modules.tools.repository;



import com.largehat.api.modules.tools.domain.QiniuConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lion
 * @date 2018-12-31
 */
public interface QiNiuConfigRepository extends JpaRepository<QiniuConfig,Long> {
}
