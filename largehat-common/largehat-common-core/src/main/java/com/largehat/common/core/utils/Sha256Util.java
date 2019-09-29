package com.largehat.common.core.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * <B>加密生成对应的字符串</B>
 */
public class Sha256Util {

    public static String sha256EncryptionStr(String password, String salt) {
        if (StrUtil.isNotEmpty(salt)) {
            salt = RandomStringUtils.randomAlphanumeric(20);
        }
        return   DigestUtil.sha256Hex(password, salt);
    }


    public static Map<String, String> sha256EncryptionMap(String password, String salt) {
        if (StrUtil.isNotEmpty(salt)) {
            salt = RandomStringUtils.randomAlphanumeric(20);
        }

        String value =  DigestUtil.sha256Hex(password, salt);
        Map map =  new HashMap<String, String>();
        map.put("salt",  salt);
        map.put("value",  value);

        return map;
    }
}
