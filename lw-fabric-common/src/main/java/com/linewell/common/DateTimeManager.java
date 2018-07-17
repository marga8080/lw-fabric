package com.linewell.common;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public abstract interface DateTimeManager {
	public abstract long getLongTime();

	public abstract String parseTime(long paramLong);

	public abstract String getNowTime();
}
