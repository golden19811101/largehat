package com.largehat.common.im.listener;


import com.largehat.common.im.config.ImConfig;
import com.largehat.common.im.constant.ImConst;


/**
 * @author Lion
 */
public abstract class AbstractImBindListener implements ImBindListener, ImConst {
	
	protected ImConfig imConfig;

	public ImConfig getImConfig() {
		return imConfig;
	}

	public void setImConfig(ImConfig imConfig) {
		this.imConfig = imConfig;
	}
}
