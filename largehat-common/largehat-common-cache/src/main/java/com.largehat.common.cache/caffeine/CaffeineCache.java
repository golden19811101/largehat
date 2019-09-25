package com.largehat.common.cache.caffeine;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.largehat.common.cache.ICache;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

/**
 * 
 * @author Lion
 */
public class CaffeineCache  implements ICache {
	
	private LoadingCache<String, Serializable> loadingCache = null;
	
	private LoadingCache<String, Serializable> temporaryLoadingCache = null;

	public CaffeineCache(LoadingCache<String, Serializable> loadingCache, LoadingCache<String, Serializable> temporaryLoadingCache) {
		this.loadingCache = loadingCache;
		this.temporaryLoadingCache = temporaryLoadingCache;
	}

	@Override
	public void clear() {
		loadingCache.invalidateAll();
		temporaryLoadingCache.invalidateAll();
	}

	@Override
	public Serializable get(String key) {
		if (StringUtils.isBlank(key)) {
			return null;
		}
		Serializable ret = loadingCache.getIfPresent(key);
		if (ret == null) {
			ret = temporaryLoadingCache.getIfPresent(key);
		}
		
		return ret;
	}

	@Override
	public Collection<String> keys() {
		ConcurrentMap<String, Serializable> map = loadingCache.asMap();
		return map.keySet();
	}

	@Override
	public void put(String key, Serializable value) {
		if (StringUtils.isBlank(key)) {
			return;
		}
		loadingCache.put(key, value);
	}
	
	@Override
	public void putTemporary(String key, Serializable value) {
		if (StringUtils.isBlank(key)) {
			return;
		}
		temporaryLoadingCache.put(key, value);
	}

	@Override
	public void remove(String key) {
		if (StringUtils.isBlank(key)) {
			return;
		}
		loadingCache.invalidate(key);
		temporaryLoadingCache.invalidate(key);
	}

	/**
	 * 
	 * @return
	 * @author: Lion
	 */
	public ConcurrentMap<String, Serializable> asMap() {
		return loadingCache.asMap();
	}
	
	/**
	 * 
	 * @return
	 * @author: Lion
	 */
	public long size() {
		return loadingCache.estimatedSize();//.size();
	}


	@Override
	public <T> T get(String key, Class<T> clazz) {
		return (T)get(key);
	}
}
