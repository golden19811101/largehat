package com.largehat.api.modules.system.vo;

import lombok.Data;

/**
 * 修改密码的 Vo 类
 * @author Lion
 * @date 2019年7月11日13:59:49
 */
@Data
public class SysUserPassVo {

    private String oldPass;

    private String newPass;
}
