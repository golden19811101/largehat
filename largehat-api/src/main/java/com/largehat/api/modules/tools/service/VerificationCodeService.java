package com.largehat.api.modules.tools.service;


import com.largehat.api.modules.tools.domain.VerificationCode;
import com.largehat.api.modules.tools.domain.vo.EmailVo;

/**
 * @author Lion
 * @date 2018-12-26
 */
public interface VerificationCodeService {

    /**
     * 发送邮件验证码
     * @param code
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code
     */
    void validated(VerificationCode code);
}
