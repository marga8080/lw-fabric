package com.linewell.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public class DateTimeManagerImpl implements DateTimeManager {
	static String pattern = "yyyy-MM-dd HH:mm:ss";
	static final SimpleDateFormat df = new SimpleDateFormat(pattern);

	public long getLongTime() {
		return System.currentTimeMillis();
	}

	public String getNowTime() {
		long l = getLongTime();
		String str = null;
		str = df.format(new Date(l));
		return str;
	}

	public String getNowTime(String paramString) {
		long l = getLongTime();
		String str = null;
		str = df.format(new Date(l));
		return str;
	}

	public String parseTime(long paramLong) {
		String str = null;
		Date localDate = new Date(paramLong);
		str = df.format(localDate);
		return str;
	}
}