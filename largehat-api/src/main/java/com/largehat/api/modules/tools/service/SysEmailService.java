package com.largehat.api.modules.tools.service;


import com.largehat.api.modules.tools.domain.SysEmailConfig;
import com.largehat.api.modules.tools.domain.vo.EmailVo;
import org.springframework.cache.annotation.CacheConfig;

/**
 * @author Lion
 * @date 2018-12-26
 */
public interface SysEmailService {

    /**
     * 更新邮件配置
     * @param emailConfig
     * @param old
     * @return
     */
    SysEmailConfig update(SysEmailConfig emailConfig, SysEmailConfig old);

    /**
     * 查询配置
     * @return
     */
    SysEmailConfig find();

    /**
     * 发送邮件
     * @param emailVo
     * @param emailConfig
     * @throws Exception
     */
    void send(EmailVo emailVo, SysEmailConfig emailConfig) throws Exception;
}
