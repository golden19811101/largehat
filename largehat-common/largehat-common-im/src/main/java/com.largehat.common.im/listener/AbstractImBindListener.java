package com.largehat.common.im.listener;


import com.largehat.common.im.config.Config;
import com.largehat.common.im.constant.ImConst;


/**
 * @author Lion
 */
public abstract class AbstractImBindListener implements ImBindListener, ImConst {
	
	protected Config imConfig;

	public Config getImConfig() {
		return imConfig;
	}

	public void setImConfig(Config imConfig) {
		this.imConfig = imConfig;
	}
}
