package com.largehat.admin.modules.tools.rest;


import com.largehat.web.constant.LargehatConstant;
import com.largehat.admin.modules.tools.domain.VerificationCode;
import com.largehat.admin.modules.tools.domain.vo.EmailVo;
import com.largehat.admin.modules.tools.service.EmailService;
import com.largehat.admin.modules.tools.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lion
 * @date 2018-12-26
 */
@RestController
@RequestMapping("api")
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private EmailService emailService;

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
