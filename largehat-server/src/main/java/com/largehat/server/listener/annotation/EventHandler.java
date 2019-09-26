package com.largehat.server.listener.annotation;



import com.largehat.server.listener.EventType;

import java.lang.annotation.*;

/**
 * 事件处理者
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
	
	/** 绑定的事件类型列表 */
	public EventType[] value();
	
}
