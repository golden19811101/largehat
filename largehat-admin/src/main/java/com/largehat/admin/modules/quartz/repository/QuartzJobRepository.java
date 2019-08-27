package com.largehat.admin.modules.quartz.repository;

import com.largehat.admin.modules.quartz.domain.QuartzJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

/**
 * @author Lion
 * @date 2019-01-07
 */
public interface QuartzJobRepository extends JpaRepository<QuartzJob,Long>, JpaSpecificationExecutor {

    /**
     * 查询启用的任务
     * @return
     */
    List<QuartzJob> findByIsPauseIsFalse();
}
