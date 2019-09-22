package com.largehat.admin.modules.tools.service;


import com.largehat.admin.modules.tools.domain.SysEmailConfig;
import com.largehat.admin.modules.tools.domain.vo.EmailVo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;

/**
 * @author Lion
 * @date 2018-12-26
 */
@CacheConfig(cacheNames = "email")
public interface SysEmailService {

    /**
     * 更新邮件配置
     * @param emailConfig
     * @param old
     * @return
     */
    @CachePut(key = "'1'")
    SysEmailConfig update(SysEmailConfig emailConfig, SysEmailConfig old);

    /**
     * 查询配置
     * @return
     */
    @Cacheable(key = "'1'")
    SysEmailConfig find();

    /**
     * 发送邮件
     * @param emailVo
     * @param emailConfig
     * @throws Exception
     */
    @Async
    void send(EmailVo emailVo, SysEmailConfig emailConfig) throws Exception;
}