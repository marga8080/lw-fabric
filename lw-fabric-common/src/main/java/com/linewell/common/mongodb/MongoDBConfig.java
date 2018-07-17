package com.linewell.common.mongodb;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;

import com.linewell.common.bean.BeanEntity;


/**
 * 定义mongodb配置对象
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
@Entity(noClassnameStored = true)
public class MongoDBConfig  extends BeanEntity implements Serializable {
	
	/**
	 * 定义别名的属性名称
	 * alias
	 */
	public static final String FIELD_NAME_ALIAS="alias";

	/**
	 * 定义源的app的unid，如果是saas单位 的app，有值 
	 * resourceAppUnid
	 */
	public static final String FIELD_RES_APPUNID = "resourceAppUnid";
	
	/**
	 * 唯一序列号
	 */
	private static final long serialVersionUID = 8244826133158101902L;

	/**
	 * 别名，也可通过此别名获取 连接池 对象
	 */
	private String alias;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 端口号
	 */
	private String port;
	
	// 2013-12-20 add by xhuatang begin
	// 需要启用授权
	private boolean needAuth;
	
	// 副本集的配置，配置规则为（ip1:port1,ip2:port2)
	private String replicaSetSeeds;
	// 2013-12-20 add by xhuatang end
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 数据库名称
	 */
	private String dbname;
	
	
	/**
	 * 分布式管理的节点名称
	 */	
	private String nodeName;
	
	/**
	 * MongoDB连接池配置
	 */
	private MongoDBOptions options;
	
	
	/**
	 * 源的unid，如果有值，说明当前是saas用户 app的unid yjy 2013-9-23
	 */
	private String resourceAppUnid;
	
	
	/**
	 * 返回配置的别名
	 * @return
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置配置的别名
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * 返回数据库的地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置数据库的地址
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 返回数据库的端口号
	 * @return
	 */
	public String getPort() {
		return port;
	}
	/**
	 * 设置数据库的端口号
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * 获取是否需要验证
	 * @return the needAuth
	 */
	public boolean isNeedAuth() {
		return needAuth;
	}
	
	/**
	 * 设置是否需要验证
	 * @param needAuth the needAuth to set
	 */
	public void setNeedAuth(boolean needAuth) {
		this.needAuth = needAuth;
	}
	
	/**
	 * 获取副本集的节点配置
	 * @return the replicaSetSeeds
	 */
	public String getReplicaSetSeeds() {
		return replicaSetSeeds;
	}
	
	/**
	 * 设置副本集的节点配置
	 * @param replicaSetSeeds the replicaSetSeeds to set
	 */
	public void setReplicaSetSeeds(String replicaSetSeeds) {
		this.replicaSetSeeds = replicaSetSeeds;
	}
	/**
	 * 返回数据库的用户名
	 * @return
	 */
	public String getUsername() {
		return username;
	}
    /**
     * 设置数据库的用户名
     * @param username
     */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 返回数据库的密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置数据库的密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 返回数据库名称
	 * @return
	 */
	public String getDbname() {
		return dbname;
	}
	/**
	 * 设置数据库名称
	 * @param dbname
	 */
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	/**
	 * 返回分布式节点名称
	 * @return
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * 设置分布式节点名称
	 * @param nodeName
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	/**
	 * 获取源的unid，如果有值，说明当前是saas单位的app的unid
	 * @return
	 */
	public String getResourceAppUnid() {
		return resourceAppUnid;
	}
	
	/**
	 * 设置源的unid，如果有值，说明当前是saas单位的app的unid
	 * @param resourceAppUnid
	 */
	public void setResourceAppUnid(String resourceAppUnid) {
		this.resourceAppUnid = resourceAppUnid;
	}
	
	/**
	 * 获取MongoDB的连接池
	 * @return
	 */
	public MongoDBOptions getOptions() {
		return options;
	}
	
	/**
	 * 设置MongoDB的连接池
	 * @param options
	 */
	public void setOptions(MongoDBOptions options) {
		this.options = options;
	}
	
	
}
