package com.linewell.common.mongodb;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

/**
 * 封装Morphia的对象
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public class MongoDBPool {
	
	private MongoClient mongo;
	
	private Morphia morphia;
	
	private Datastore datastore;
	
	/**
	 *  配置信息
	 */
	private MongoDBConfig mongoDBConfig;

	/**
	 * 返回 Mongo对象
	 * @return
	 */
	public MongoClient getMongoClient() {
		return mongo;
	}
	/**
	 * 设置Mongo对象
	 * @param mongo
	 */
	void setMongoClient(MongoClient mongo) {
		this.mongo = mongo;
	}
	/**
	 * 返回Morphia对象
	 * @return
	 */
	public Morphia getMorphia() {
		return morphia;
	}
	/**
	 * 设置Morphia对象
	 * @param morphia
	 */
	void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}
	
	/**
	 * 返回连接池对象，主要是由此对象进行数据库操作
	 * @return
	 */
	public Datastore getDatastore() {
		return datastore;
	}
	/**
	 * 设置连接池对象
	 * @param datastore
	 */
	void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}
	
	/**
	 * 把类对象设置到morphia的 Map中，前台是此类对象，必须包含ObjecID，要不会出错
	 * @param clazz
	 */
	public void setMap(Class<?> clazz){
		this.morphia.map(clazz);
	}
	
	/**
	 * 返回连接池的配置对象
	 * @return
	 */
	public MongoDBConfig getMongoDBConfig() {
		return mongoDBConfig;
	}
	
	/**
	 * 设置连接池的配置对象
	 * @param mongoDBConfig
	 */
	public void setMongoDBConfig(MongoDBConfig mongoDBConfig) {
		this.mongoDBConfig = mongoDBConfig;
	}
	
}
