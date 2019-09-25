package com.largehat.common.cache;

import java.io.Serializable;

/**
 * @author Lion
 */
public interface IL2Cache {
	public void putL2Async(String key, Serializable value);
}
