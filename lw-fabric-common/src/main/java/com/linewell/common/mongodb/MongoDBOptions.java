package com.linewell.common.mongodb;

import java.io.Serializable;

/**
 * MongoDB的属性对象
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public class MongoDBOptions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8163269628786107698L;

	/**
	 * 获取是否自动重连
	 * @return 是否自动重连
	 */
	public boolean isAutoConnectRetry() {
		return autoConnectRetry;
	}

	/**
	 * 设置是否自动重连
	 * @param autoConnectRetry 是否自动重连
	 */
	public void setAutoConnectRetry(boolean autoConnectRetry) {
		this.autoConnectRetry = autoConnectRetry;
	}

	/**
	 * 获取单个服务器的连接
	 * @return 单个服务器的连接
	 */
	public int getConnectionsPerHost() {
		return connectionsPerHost;
	}

	/**
	 * 设置单个服务器的连接数
	 * @param connectionsPerHost 单个服务器的连接数
	 */
	public void setConnectionsPerHost(int connectionsPerHost) {
		this.connectionsPerHost = connectionsPerHost;
	}

	/**
	 * 获取连接超时时间
	 * @return 连接超时时间
	 */
	public int getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * 设置连接超时时间
	 * @param connectTimeout 连接超时时间
	 */
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	/**
	 * 获取是否有一个finalize方法创建，清理的DBCursor实例的客户端不会关闭
	 * @return 是否有一个finalize方法创建，清理的DBCursor实例的客户端不会关闭
	 */
	public boolean isCursorFinalizerEnabled() {
		return cursorFinalizerEnabled;
	}

	/**
	 * 设置是否有一个finalize方法创建，清理的DBCursor实例的客户端不会关闭
	 * @param cursorFinalizerEnabled 是否有一个finalize方法创建，清理的DBCursor实例的客户端不会关闭
	 */
	public void setCursorFinalizerEnabled(boolean cursorFinalizerEnabled) {
		this.cursorFinalizerEnabled = cursorFinalizerEnabled;
	}

	/**
	 * 获取副本集名称
	 * @return 副本集名称
	 */
	public String getRequiredReplicaSetName() {
		return requiredReplicaSetName;
	}

	/**
	 * 设置副本集名称
	 * @param requiredReplicaSetName 副本集名称
	 */
	public void setRequiredReplicaSetName(String requiredReplicaSetName) {
		this.requiredReplicaSetName = requiredReplicaSetName;
	}

	/**
	 * 获取全局写是否同步
	 * @return 全局写是否同步
	 */
	public boolean isFsync() {
		return fsync;
	}

	/**
	 * 设置全局写是否同步
	 * @param fsync 全局写是否同步
	 */
	public void setFsync(boolean fsync) {
		this.fsync = fsync;
	}

	public boolean isJ() {
		return j;
	}

	public void setJ(boolean j) {
		this.j = j;
	}

	/**
	 * 获取最大的重新连接的次数
	 * @return 最大的重新连接的次数
	 */
	public long getMaxAutoConnectRetryTime() {
		return maxAutoConnectRetryTime;
	}

	/**
	 * 设置最大的重新连接的次数
	 * @param maxAutoConnectRetryTime 最大的重新连接的次数
	 */
	public void setMaxAutoConnectRetryTime(long maxAutoConnectRetryTime) {
		this.maxAutoConnectRetryTime = maxAutoConnectRetryTime;
	}

	/**
	 * 获取最大的等待时间
	 * @return 最大的等待时间
	 */
	public int getMaxWaitTime() {
		return maxWaitTime;
	}

	/**
	 * 设置最大的等待时间
	 * @param maxWaitTime 最大的等待时间
	 */
	public void setMaxWaitTime(int maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	/**
	 * 获取读的偏好，支持nearest,primary,secondary
	 * @return 读的偏好，支持nearest,primary,secondary
	 */
	public String getReadPreference() {
		return readPreference;
	}

	/**
	 * 设置读的偏好，支持nearest,primary,secondary
	 * @param readPreference 读的偏好，支持nearest,primary,secondary
	 */
	public void setReadPreference(String readPreference) {
		this.readPreference = readPreference;
	}

	/**
	 * driver uses WriteConcern.SAFE for all operations
	 * @return true if driver uses WriteConcern.SAFE for all operations
	 */
	public boolean isSafe() {
		return safe;
	}

	/**
	 * driver uses WriteConcern.SAFE for all operations
	 * @param true if safe driver uses WriteConcern.SAFE for all operations
	 */
	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	
	/**
	 * 获取是否Socket保持连接
	 * @return 是否Socket保持连接
	 */
	public boolean isSocketKeepAlive() {
		return socketKeepAlive;
	}

	/**
	 * 设置是否Socket保持连接
	 * @param socketKeepAlive 是否Socket保持连接
	 */
	public void setSocketKeepAlive(boolean socketKeepAlive) {
		this.socketKeepAlive = socketKeepAlive;
	}

	/**
	 * 获取Socket的超时时间
	 * @return Socket的超时时间
	 */
	public int getSocketTimeout() {
		return socketTimeout;
	}

	/**
	 * 设置Socket的超时时间
	 * @param socketTimeout Socket的超时时间
	 */
	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	/**
	 * 获取一个连接的最大线程数
	 * @return 一个连接的最大线程数
	 */
	public int getThreadsAllowedToBlockForConnectionMultiplier() {
		return threadsAllowedToBlockForConnectionMultiplier;
	}

	/**
	 * 设置一个连接的最大线程数
	 * @param threadsAllowedToBlockForConnectionMultiplier 一个连接的最大线程数
	 */
	public void setThreadsAllowedToBlockForConnectionMultiplier(
			int threadsAllowedToBlockForConnectionMultiplier) {
		this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
	}

	/**
	 * 获取写超时时间
	 * @return 写超时时间
	 */
	public int getWtimeout() {
		return wtimeout;
	}

	/**
	 * 设置写超时时间
	 * @param wtimeout 写超时时间
	 */
	public void setWtimeout(int wtimeout) {
		this.wtimeout = wtimeout;
	}

	/**
	 * 获取描述信息
	 * @return 描述信息
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置描述信息
	 * @param description 描述信息
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	private boolean autoConnectRetry;
	
	private int	connectionsPerHost;
	
	private int	connectTimeout;
	
	private boolean	cursorFinalizerEnabled;
	
	private String description;

	private boolean	fsync;
	
	private boolean	j;
	
	private long maxAutoConnectRetryTime;
	
	private int	maxWaitTime;
	
	private String readPreference;
	
	private boolean safe;
	
	private boolean	socketKeepAlive;
	
	private int	socketTimeout;
	
	private int	threadsAllowedToBlockForConnectionMultiplier;
	
	private int	wtimeout;
	
	/**
	 * 副本集名称 add by jly 2017-07-26
	 */
	private String requiredReplicaSetName;
}
