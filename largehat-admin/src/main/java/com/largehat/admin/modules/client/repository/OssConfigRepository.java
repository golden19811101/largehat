package com.largehat.admin.modules.client.repository;

import com.largehat.admin.modules.client.domain.OssConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author kafe
* @date 2019-09-12
*/
public interface OssConfigRepository extends JpaRepository<OssConfig, Long>, JpaSpecificationExecutor {
}