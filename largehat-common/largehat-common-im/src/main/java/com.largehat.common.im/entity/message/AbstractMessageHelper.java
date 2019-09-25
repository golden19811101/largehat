package com.largehat.common.im.entity.message;


import com.largehat.common.im.config.Config;
import com.largehat.common.im.constant.ImConst;


/**
 * @author HP
 *
 */
public abstract class AbstractMessageHelper implements MessageHelper, ImConst {

	protected Config imConfig;

	public Config getImConfig() {
		return imConfig;
	}

	public void setImConfig(Config imConfig) {
		this.imConfig = imConfig;
	}
}
