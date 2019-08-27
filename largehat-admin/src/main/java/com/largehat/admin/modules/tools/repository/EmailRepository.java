package com.largehat.admin.modules.tools.repository;


import com.largehat.admin.modules.tools.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lion
 * @date 2018-12-26
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
