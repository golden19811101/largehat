package com.largehat.server.listener;


import com.largehat.server.base.SpringContext;
import com.largehat.server.listener.annotation.EventHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MessageListenerBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware, Ordered {

	@Autowired
	private ListenerManager listenerMgr;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {

	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
		try {
			Class<?> clz = bean.getClass();
			Object listener = bean;
			Method[] methods = clz.getDeclaredMethods();
			for (Method method:methods) {
				EventHandler mapperAnnotation = method.getAnnotation(EventHandler.class);
				if (mapperAnnotation != null) {
					EventType[] eventTypes = mapperAnnotation.value();
					for(EventType eventType: eventTypes) {
						SpringContext.getEventDispatcher().registerEvent(eventType, listener);
						listenerMgr.registerEventListener(listener, eventType, method);
					}
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

}