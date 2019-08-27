package com.largehat.admin.modules.tools.service;


import com.largehat.admin.modules.tools.domain.VerificationCode;
import com.largehat.admin.modules.tools.domain.vo.EmailVo;

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
