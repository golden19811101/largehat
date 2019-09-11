package com.largehat.server.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
@Data
public class ReidsConfiguration {

    /**
     * 数据库
     */
    @Value("${spring.redis.database}")
    protected String database = "1";

    /**
     * 地址
     */
    @Value("${spring.redis.host}")
    protected String host = "";

    /**
     * 端口
     */
    @Value("${spring.redis.port}")
    protected String port = "6379";

    /**
     * 密码
     */
    @Value("${spring.redis.password}")
    protected String password = "";

    /**
     * 连接超时
     */
    @Value("${spring.redis.timeout}")
    protected String timeout = "";

}
