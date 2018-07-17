package com.linewell.common.mongodb.dbtemplate;

import java.lang.reflect.ParameterizedType;

import org.mongodb.morphia.Datastore;

import com.linewell.common.bean.BeanEntity;
import com.linewell.common.exception.FrameworkException;
import com.linewell.common.mongodb.MongoDBPool;
import com.linewell.common.mongodb.MongoDbBaseTemplate;

/**
 * DataView Mongodb数据库基本模板
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public abstract class DataViewConfigTemplate<T extends BeanEntity> extends MongoDbBaseTemplate  {
	
	public DataViewConfigTemplate() {
		this.init();
	}
	
	/**
	 * 共享数据库的初始化 
	 * @throws FrameworkException
	 */
	protected void init() {
		try {
			Class<?> clazz = (Class<?>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			this.setBeanClass(clazz);
			MongoDBPool manageCcip = DataViewMongoDBPoolManager.getMongoDBPool();
			Datastore datastore = manageCcip.getDatastore();
			this.setDatastore(datastore);
		} catch (FrameworkException e) {
			e.printStackTrace();
		}
	}
	
	protected void reConnect() {
		init();
	}
}
