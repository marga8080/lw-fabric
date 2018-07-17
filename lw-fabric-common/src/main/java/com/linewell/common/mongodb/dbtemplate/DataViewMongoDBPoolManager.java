package com.linewell.common.mongodb.dbtemplate;

import java.io.File;
import java.net.UnknownHostException;

import com.linewell.common.exception.ExceptionType;
import com.linewell.common.exception.FrameworkException;
import com.linewell.common.mongodb.MongoDBConfig;
import com.linewell.common.mongodb.MongoDBPool;
import com.linewell.common.mongodb.MongoDbUtils;
import com.linewell.common.mongodb.XmlConfigManager;
import com.mongodb.MongoException;

/**
 * 对外提供的MongoDb管理
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public class DataViewMongoDBPoolManager {
	
	private static MongoDBPool mongoDBPool = null;
	
	private DataViewMongoDBPoolManager(){
		
	}
	public static MongoDBPool getMongoDBPool() throws FrameworkException{
		if(mongoDBPool==null){
			init();
		}
		return mongoDBPool;
	}
	/**
	 * 初始化
	 * @throws FrameworkException
	 */
	private  static void init() throws FrameworkException{
		XmlConfigManager xmlConfigManager = XmlConfigManager.getInstance();
		String xmlFileName = xmlConfigManager.getConfigFileName();
		
		File xmlFile = new File(xmlFileName);
		
		MongoDBConfig  mongodbConfig = null;
		if(xmlFile.exists()){
			//存在，说明是NameNode,需要进行初始化
			XmlConfigManager.getInstance().initConfig();
			mongodbConfig = xmlConfigManager.getFabricConfig();
		} else {
			mongodbConfig = MongoDBConfigFactory.getDataViewMongoDBConfig();
		}
		if(null!= mongodbConfig){
			setMongoDBPool(mongodbConfig);
		}
	}
	
	/**
	 * 获取MongoDB
	 * @return
	 * @throws FrameworkException
	 */
	private static void setMongoDBPool(MongoDBConfig  mongodbConfig)  throws FrameworkException{
		try {
			mongoDBPool = MongoDbUtils.cretateMongodb(mongodbConfig);
		} catch (NumberFormatException e) {
			throw new FrameworkException(ExceptionType.ERROR, e, "00064");
		} catch (UnknownHostException e) {
			throw new FrameworkException(ExceptionType.ERROR, e, "00064");
		} catch (MongoException e) {
			throw new FrameworkException(ExceptionType.ERROR, e, "00064");
		}
	}
}