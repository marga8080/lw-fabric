package com.linewell.common.mongodb;

import java.util.HashMap;
import java.util.Map;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;

/**
 * 封装App Morphia的对象
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public class AppMongoDBPool {
	
	private Mongo mongo;
	
	private Morphia morphia;
	
	//key为appUnid，value为db对象
	private Map<String,Datastore> datastoreMap;
	
	/**
	 *  配置信息
	 */
	private MongoDBConfig mongoDBConfig;

	/**
	 * 返回 Mongo对象
	 * @return
	 */
	public Mongo getMongo() {
		return mongo;
	}
	/**
	 * 设置Mongo对象
	 * @param mongo
	 */
	public void setMongo(Mongo mongo) {
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
	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
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
	
	/**
	 * 获取db列表对象
	 * @return
	 */
	public Map<String, Datastore> getDatastoreMap() {
		return datastoreMap;
	}
	
	/**
	 * 设置db列表对象
	 * @param datastoreMap
	 */
	public void setDatastoreMap(Map<String, Datastore> datastoreMap) {
		this.datastoreMap = datastoreMap;
	}
	
	/**
	 * 把db追加到map中
	 * @param dbName  数据库名称
	 * @param db      数据库对象
	 */
	public void addDatastoreMap(String dbName,Datastore db){
		if (this.datastoreMap == null || this.datastoreMap.isEmpty()){
			this.datastoreMap = new HashMap<String,Datastore>();
		}
		
		if(!this.datastoreMap.containsKey(dbName)){
			this.datastoreMap.put(dbName, db);
		}
	}
	
	/**
	 * 根据数据库名称，获取Datastore对象
	 * @param dbName 数据库名称
	 * @return Datastore
	 */
	public Datastore getDatastore(String dbName){
		if (this.datastoreMap == null || this.datastoreMap.isEmpty()){
			return null;
		}
		return this.datastoreMap.get(dbName);
	}
	
}
