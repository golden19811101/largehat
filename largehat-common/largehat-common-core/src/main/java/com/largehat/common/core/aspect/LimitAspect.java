package com.largehat.common.core.aspect;


import com.largehat.common.core.annotation.Limit;
import com.largehat.common.core.exception.BadRequestException;
import com.largehat.common.core.utils.StringUtils;
import com.largehat.common.core.utils.RequestHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

//@Aspect
//@Component
//public class LimitAspect {
//    @Autowired
//    private RedisTemplate redisTemplate;
//    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);


//    @Pointcut("@annotation(com.largehat.common.core.annotation.Limit)")
//    public void pointcut() {
//    }
//
//    @Around("pointcut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        HttpServletRequest request = RequestHolder.getHttpServletRequest();
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method signatureMethod = signature.getMethod();
//        Limit limit = signatureMethod.getAnnotation(Limit.class);
//        LimitType limitType = limit.limitType();
//        String key = limit.key();
//        if (StringUtils.isEmpty(key)) {
//            switch (limitType) {
//                case IP:
//                    key = StringUtils.getIP(request);
//                    break;
//                default:
//                    key = signatureMethod.getName();
//            }
//        }

//        ImmutableList keys = ImmutableList.of(StringUtils.join(limit.prefix(), "_", key, "_", request.getRequestURI().replaceAll("/","_")));
//
//        String luaScript = buildLuaScript();
//        RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
//        Number count = (Number) redisTemplate.execute(redisScript, keys, limit.count(), limit.period());
//        if (null != count && count.intValue() <= limit.count()) {
//            logger.info("第{}次访问key为 {}，描述为 [{}] 的接口", count, keys, limit.name());
//            return joinPoint.proceed();
//        } else {
//            throw new BadRequestException("访问次数受限制");
//        }
//        return null;
//    }

    /**
     * 限流脚本
     */
//    private String buildLuaScript() {
//        return "local c" +
//                "\nc = redis.call('get',KEYS[1])" +
//                "\nif c and tonumber(c) > tonumber(ARGV[1]) then" +
//                "\nreturn c;" +
//                "\nend" +
//                "\nc = redis.call('incr',KEYS[1])" +
//                "\nif tonumber(c) == 1 then" +
//                "\nredis.call('expire',KEYS[1],ARGV[2])" +
//                "\nend" +
//                "\nreturn c;";
//    }
//}
