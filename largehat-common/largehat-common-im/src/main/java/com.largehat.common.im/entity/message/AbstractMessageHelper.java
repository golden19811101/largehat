package com.largehat.common.im.entity.message;


import com.largehat.common.im.config.ImConfig;
import com.largehat.common.im.constant.ImConst;


/**
 * @author HP
 *
 */
public abstract class AbstractMessageHelper implements MessageHelper, ImConst {

	protected ImConfig imConfig;

	public ImConfig getImConfig() {
		return imConfig;
	}

	public void setImConfig(ImConfig imConfig) {
		this.imConfig = imConfig;
	}
}
