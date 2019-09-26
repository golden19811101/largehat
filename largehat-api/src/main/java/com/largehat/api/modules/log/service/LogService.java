package com.largehat.api.modules.log.service;



import com.largehat.api.modules.log.domain.SysLog;
import com.largehat.api.modules.log.dto.LogQueryCriteria;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

/**
 * @author Lion
 * @date 2018-11-24
 */
public interface LogService {

    /**
     * queryAll
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(LogQueryCriteria criteria, Pageable pageable);

    /**
     * queryAllByUser
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAllByUser(LogQueryCriteria criteria, Pageable pageable);

    /**
     * 新增日志
     * @param username
     * @param ip
     * @param joinPoint
     * @param log
     */
    @Async
    void save(String username, String ip, ProceedingJoinPoint joinPoint, SysLog log);

    /**
     * 查询异常详情
     * @param id
     * @return
     */
    Object findByErrDetail(Long id);
}
