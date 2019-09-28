package com.largehat.server.base;


import com.largehat.server.dispatch.MessageDispatcher;
import com.largehat.server.helper.db.MysqlMessageHelper;
import com.largehat.server.helper.redis.RedisMessageHelper;
import com.largehat.server.listener.EventDispatcher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;

@Component
public class SpringContext implements ApplicationContextAware {

	private static SpringContext self;
	
	/** spring容器上下文 */
	private static ApplicationContext applicationContext = null;
	
	@PostConstruct
	private void init() {
		self = this;
	}

	//定义持reids持久化服务
	@Autowired
	private static RedisMessageHelper redisMessageHelper;

    //定义mysql持久化服务
	@Autowired
	private static MysqlMessageHelper mysqlMessageHelper;

	private static MessageDispatcher messageDispatcher;

	private static EventDispatcher eventDispatcher;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContext.applicationContext = applicationContext;
	}

	public final static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

	public final static <T> Collection<T> getBeansOfType(Class<T> clazz) {
		return applicationContext.getBeansOfType(clazz).values();
	}

	public final static <T> T getBean(String name, Class<T> requiredType) {
		return applicationContext.getBean(name, requiredType);
	}

	@Resource
	public void setMessageDispatcher(MessageDispatcher messageDispatcher) {
		SpringContext.messageDispatcher = messageDispatcher;
	}

	public final static MessageDispatcher getMessageDispatcher() {
		return messageDispatcher;
	}

	@Resource
	public void setEventDispatcher(EventDispatcher eventDispatcher) {
		SpringContext.eventDispatcher = eventDispatcher;
	}

	public final static EventDispatcher getEventDispatcher() {
		return eventDispatcher;
	}

}
