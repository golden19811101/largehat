package com.largehat.admin.modules.tools.repository;


import com.largehat.admin.modules.tools.domain.SysPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Lion
 * @date 2018-12-27
 */
public interface SysPictureRepository extends JpaRepository<SysPicture,Long>, JpaSpecificationExecutor {
}
