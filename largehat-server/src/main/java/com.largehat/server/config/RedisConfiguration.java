package com.largehat.server.config;


import com.largehat.server.base.reids.RedisTemplate;
import com.largehat.server.base.reids.RedisUtil;
import com.largehat.server.base.serialize.FastJson2JsonRedisSerializer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.time.Duration;


@Component
@Data
public class RedisConfiguration {

    /**
     * 数据库
     */
    @Value("${spring.redis.database}")
    protected String database;

    /**
     * 地址
     */
    @Value("${spring.redis.host}")
    protected String host;

    /**
     * 端口
     */
    @Value("${spring.redis.port}")
    protected Integer port;

    /**
     * 密码
     */
    @Value("${spring.redis.password}")
    protected String password;

    /**
     * 连接超时
     */
    @Value("${spring.redis.timeout}")
    protected Long timeout;


    /**
     *最大连接数
     */
    @Value("${spring.redis.maxActive}")
    protected String maxActive;


    /**
     *最长等待
     */
    @Value("${spring.redis.maxWait}")
    protected String maxWait;


    /**
     * 最大空闲数
     */
    @Value("${spring.redis.maxIdle}")
    protected String maxIdle;


    /**
     * 最小空闲数
     */
    @Value("${spring.redis.minIdle}")
    protected String minIdle;


    /**
     * <B>获取配置工厂信息</B>
     * @return
     */
    //@Bean
    public JedisConnectionFactory JedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration ();
        redisStandaloneConfiguration.setHostName(this.host);
        redisStandaloneConfiguration.setPort(this.port);
        //由于我们使用了动态配置库,所以此处省略
        //redisStandaloneConfiguration.setDatabase(database);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));
        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration.build());
        return factory;
    }


    /**
     * 实例化 RedisTemplate 对象
     * @param redisConnectionFactory
     * @return
     */
    //@Bean
    public RedisTemplate functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }


    /**
     * <B>引入自定义序列化</B>
     * @return
     */
    //@Bean
    public RedisSerializer fastJson2JsonRedisSerializer() {
        return new FastJson2JsonRedisSerializer<Object>(Object.class);
    }

    /**
     * <B>设置数据存入 redis 的序列化方式,并开启事务</B>
     * @param redisTemplate
     * @param factory
     */
    private void initDomainRedisTemplate(RedisTemplate redisTemplate, RedisConnectionFactory factory) {
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer());
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * @param: [redisTemplate]
     * @return: com.springboot.demo.base.utils.RedisUtil
     * @Description: 注入封装RedisTemplate
     */
//    @Bean(name = "redisUtil")
//    public RedisUtil redisUtil(RedisTemplate redisTemplate) {
//        RedisUtil redisUtil = new RedisUtil();
//        redisUtil.setRedisTemplate(redisTemplate);
//        return redisUtil;
//    }

}
