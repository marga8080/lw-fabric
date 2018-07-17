package com.linewell.common.factory;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public class ImplClassConfigManager {
	private static Class<?> bundleCateoryImplClass;
	private static Class<?> bundleLogImplClass;
	private static Class<?> persistentCacheImplClass;
	private static Class<?> ccipLogImpl;
	private static Class<?> distributedServiceImpl;
	private static Class<?> webServiceImplClass;
	private static Class<?> dateTimeImplClass;

	public static Class<?> getBundleCateoryImplClass() {
		return bundleCateoryImplClass;
	}

	public static void setBundleCateoryImplClass(Class<?> paramClass) {
		bundleCateoryImplClass = paramClass;
	}

	public static Class<?> getBundleLogImplClass() {
		return bundleLogImplClass;
	}

	public static void setBundleLogImplClass(Class<?> paramClass) {
		bundleLogImplClass = paramClass;
	}

	public static Class<?> getPersistentCacheImplClass() {
		return persistentCacheImplClass;
	}

	public static void setPersistentCacheImplClass(Class<?> paramClass) {
		persistentCacheImplClass = paramClass;
	}

	public static Class<?> getCcipLogImpl() {
		return ccipLogImpl;
	}

	public static void setCcipLogImpl(Class<?> paramClass) {
		ccipLogImpl = paramClass;
	}

	public static Class<?> getDistributedServiceImpl() {
		return distributedServiceImpl;
	}

	public static void setDistributedServiceImpl(Class<?> paramClass) {
		distributedServiceImpl = paramClass;
	}

	public static Class<?> getWebServiceImplClass() {
		return webServiceImplClass;
	}

	public static void setWebServiceImplClass(Class<?> paramClass) {
		webServiceImplClass = paramClass;
	}

	public static Class<?> getDateTimeImplClass() {
		return dateTimeImplClass;
	}

	public static void setDateTimeImplClass(Class<?> paramClass) {
		dateTimeImplClass = paramClass;
	}
}