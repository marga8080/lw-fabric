package com.linewell.common.factory;

import com.linewell.common.DateTimeManager;
import com.linewell.common.DateTimeManagerImpl;

/**
 * copy from ccip-core-framework-1.0.jar
 * 
 * @author mawei
 *
 */
public class DateTimeFactory {
	public static DateTimeManager getInstance() {
		try {
			Class<?> localClass = ImplClassConfigManager.getDateTimeImplClass();
			if (localClass != null) {
				return (DateTimeManager) ImplClassConfigManager.getDateTimeImplClass().newInstance();
			}
			return new DateTimeManagerImpl();
		} catch (InstantiationException localInstantiationException) {
			localInstantiationException.printStackTrace();
		} catch (IllegalAccessException localIllegalAccessException) {
			localIllegalAccessException.printStackTrace();
		}
		return null;
	}
}
