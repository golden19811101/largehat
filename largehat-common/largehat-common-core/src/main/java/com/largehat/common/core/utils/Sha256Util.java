package com.largehat.common.core.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.apache.commons.lang3.RandomStringUtils;


/**
 * <B>加密生成对应的字符串</B>
 */
public class Sha256Util {

    public static String encryption(String password, String salt) {
        if (StrUtil.isNotEmpty(salt)) {
            salt = RandomStringUtils.randomAlphanumeric(20);
        }
        return   DigestUtil.sha256Hex(password, salt);
    }
}
