package com.largehat.admin.modules.tools.controller;


import com.largehat.api.modules.tools.domain.VerificationCode;
import com.largehat.api.modules.tools.domain.vo.EmailVo;
import com.largehat.api.modules.tools.service.SysEmailService;
import com.largehat.api.modules.tools.service.VerificationCodeService;
import com.largehat.common.core.constant.LargehatConstant;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lion
 * @date 2018-12-26
 */
@RestController
@RequestMapping("api")
public class VerificationCodeController {

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private VerificationCodeService verificationCodeService;

    @Reference(version = "${api.service.version}", timeout = 30000, check = true)
    private SysEmailService emailService;

    @PostMapping(value = "/code/resetEmail")
    public ResponseEntity resetEmail(@RequestBody VerificationCode code) throws Exception {
        code.setScenes(LargehatConstant.RESET_MAIL);
        EmailVo emailVo = verificationCodeService.sendEmail(code);
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/code/email/resetPass")
    public ResponseEntity resetPass(@RequestParam String email) throws Exception {
        VerificationCode code = new VerificationCode();
        code.setType("email");
        code.setValue(email);
        code.setScenes(LargehatConstant.RESET_MAIL);
        EmailVo emailVo = verificationCodeService.sendEmail(code);
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/code/validated")
    public ResponseEntity validated(VerificationCode code){
        verificationCodeService.validated(code);
        return new ResponseEntity(HttpStatus.OK);
    }
}
