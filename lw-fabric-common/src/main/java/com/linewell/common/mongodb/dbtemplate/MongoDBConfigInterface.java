package com.linewell.common.mongodb.dbtemplate;

import com.linewell.common.exception.FrameworkException;
import com.linewell.common.mongodb.MongoDBConfig;

/**
 * 获取服务器中MongoDB的配置信息
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public interface MongoDBConfigInterface {
	
	/**
	 * 获取通用的信息库 开发商、系统 、国际化、系统参数等
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getCcipMongoDBConfig() throws FrameworkException;
	
	/**
	 * 获取Bundle启动、分类的配置库
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getBundleMongoDBConfig() throws FrameworkException;
	
	
	/**
	 * 获取日志的配置库
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getLogMongoDBConfig() throws FrameworkException;
	
	/**
	 * 获取用户库配置及权限库信息
	 * @return 用户库配置及权限库   MongoDBConfig
	 * @throws FrameworkException 
	 */
	public MongoDBConfig getOrgAuthConfig() throws FrameworkException;
	
	/**
	 * 获取监控库配置信息
	 * @return 监控库配置信息
	 * @throws FrameworkException
	 */
	public MongoDBConfig getMonitorConfig() throws FrameworkException;
	
	/**
	 * 获取会话库配置信息
	 * @return 会话库配置信息
	 * @throws FrameworkException
	 */
	public MongoDBConfig getSessionConfig() throws FrameworkException;
	
	/**
	 * 获取admin配置信息
	 * @return admin配置信息
	 * @throws FrameworkException
	 */
	public MongoDBConfig getAdminConfig() throws FrameworkException;
	
	public MongoDBConfig getDataViewConfig() throws FrameworkException;
}
