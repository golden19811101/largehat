package com.largehat.common.im.utils;


import lombok.extern.slf4j.Slf4j;

/**
 * 时间监测器,用于调试过程
 *
 *
 */
@Slf4j
public class TimeMonitor {

	private final boolean isDebug;
	public static final TimeMonitor DEBUG = new TimeMonitor(true);

	private long start = 0;

	public TimeMonitor(boolean isDebug) {
		this.isDebug = isDebug;
	}

	public void _s() {
		if (isDebug) {
			start = System.currentTimeMillis();
		}
	}

	public void _e(String p) {
		if (isDebug) {
			long e = System.currentTimeMillis();
			if(log.isDebugEnabled()) {
				log.debug(p + " time:" + (e - start) + "ms");
			}
		}
	}
}
