package com.largehat.api.modules.quartz.service;


import com.largehat.api.modules.quartz.domain.QuartzJob;
import com.largehat.api.modules.quartz.dto.JobQueryCriteria;
import org.springframework.data.domain.Pageable;

/**
 * @author Lion
 * @date 2019-01-07
 */
public interface QuartzJobService {

    /**
     * queryAll quartzJob
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(JobQueryCriteria criteria, Pageable pageable);

    /**
     * queryAll quartzLog
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAllLog(JobQueryCriteria criteria, Pageable pageable);

    /**
     * create
     * @param resources
     * @return
     */
    QuartzJob create(QuartzJob resources);

    /**
     * update
     * @param resources
     * @return
     */
    void update(QuartzJob resources);

    /**
     * del
     * @param quartzJob
     */
    void delete(QuartzJob quartzJob);

    /**
     * findById
     * @param id
     * @return
     */
    QuartzJob findById(Long id);

    /**
     * 更改定时任务状态
     * @param quartzJob
     */
    void updateIsPause(QuartzJob quartzJob);

    /**
     * 立即执行定时任务
     * @param quartzJob
     */
    void execution(QuartzJob quartzJob);
}
