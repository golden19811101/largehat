package com.largehat.admin.modules.tools.repository;


import com.largehat.api.modules.tools.domain.SysEmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lion
 * @date 2018-12-26
 */
public interface SysEmailRepository extends JpaRepository<SysEmailConfig,Long> {
}
