package com.largehat.common.im.service.uuid;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jwp on
 * sessionId生成器
 */
@Service
public class LongIdGenerator {

    protected AtomicLong id_gen = new AtomicLong(0);

    public long generateId(){
        return id_gen.incrementAndGet();
    }

    public static String getRandomId() {
        return IdUtil.simpleUUID();
    }
}