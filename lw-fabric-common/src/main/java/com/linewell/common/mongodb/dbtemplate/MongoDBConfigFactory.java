package com.linewell.common.mongodb.dbtemplate;

import com.linewell.common.exception.FrameworkException;
import com.linewell.common.mongodb.MongoDBConfig;

/**
 * 获取配置库对应提供的工厂
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public class MongoDBConfigFactory {
	
	/**
	 * MongoDB配置管理的实现对象
	 */
	private static MongoDBConfigInterface mongoDBConfigManagerImpl = null;
	
	private MongoDBConfigFactory(){
		
	}
	
	/**
	 * 设置实例化对象 
	 * @param mongoDBConfigManager
	 */
	public static void setMongoDBConfigManager(MongoDBConfigInterface mongoDBConfigManager){
		mongoDBConfigManagerImpl = mongoDBConfigManager;
	}

	/**
	 * 获取通用的信息库 开发商、系统 、国际化、系统参数等
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public static MongoDBConfig getCcipMongoDBConfig() throws FrameworkException {
		return mongoDBConfigManagerImpl.getCcipMongoDBConfig();
	}
	
	/**
	 * 获取Bundle启动、分类的配置库
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public static MongoDBConfig getBundleMongoDBConfig() throws FrameworkException {
		return mongoDBConfigManagerImpl.getBundleMongoDBConfig();
	}
	
	/**
	 * 获取组织架构、权限的配置库
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public static MongoDBConfig getOrgAuthMongoDBConfig() throws FrameworkException {
		return mongoDBConfigManagerImpl.getOrgAuthConfig();
	}
	
	/**
	 * 获取会话库配置信息
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public static MongoDBConfig getSessionMongoDBConfig() throws FrameworkException {
		return mongoDBConfigManagerImpl.getSessionConfig();
	}
	
	/**
	 * 获取监控的配置库，主要是错误日志，及插件的监控信息库
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public static MongoDBConfig getMonitorMongoDBConfig() throws FrameworkException {
		return mongoDBConfigManagerImpl.getMonitorConfig();
	}
	
	/**
	 * 获取日志的配置库，包括登录、操作及授权日志
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public static MongoDBConfig getLogMongoDBConfig() throws FrameworkException {
		return mongoDBConfigManagerImpl.getLogMongoDBConfig();
	}
	
	/**
	 * 获取admin配置库
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public static MongoDBConfig getAdminMongoDBConfig() throws FrameworkException {
		return mongoDBConfigManagerImpl.getAdminConfig();
	}
	
	/**
	 * 获取admin配置库
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public static MongoDBConfig getDataViewMongoDBConfig() throws FrameworkException {
		return mongoDBConfigManagerImpl.getDataViewConfig();
	}
}
