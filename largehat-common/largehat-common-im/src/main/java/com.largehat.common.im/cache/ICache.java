package com.largehat.common.im.cache;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Lion
 * 2017年8月10日 上午11:38:26
 */
public interface ICache {

	/**
	 *
	 * 清空所有缓存
	 * @author Lion
	 */
	void clear();

	/**
	 * 根据key获取value
	 * @param key
	 * @return
	 * @author Lion
	 */
	public Serializable get(String key);
	
	/**
	 * 根据key获取value
	 * @param key
	 * @param clazz
	 * @return
	 * @author: Lion
	 */
	public <T> T get(String key, Class<T> clazz);

	/**
	 * 获取所有的key
	 * @return
	 * @author Lion
	 */
	Collection<String> keys();

	/**
	 * 将key value保存到缓存中
	 * @param key
	 * @param value
	 * @author Lion
	 */
	public void put(String key, Serializable value);

	/**
	 * 删除一个key
	 * @param key
	 * @return
	 * @author Lion
	 */
	public void remove(String key);

	/**
	 * 临时添加一个值，用于防止缓存穿透攻击
	 * @param key
	 * @param value
	 */
	void putTemporary(String key, Serializable value);
}
