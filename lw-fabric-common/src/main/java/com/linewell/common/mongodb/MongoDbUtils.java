package com.linewell.common.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.linewell.common.exception.ExceptionType;
import com.linewell.common.exception.FrameworkException;
import com.mongodb.CommandResult;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

/**
 * MongoDb的工具类
 * 
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public class MongoDbUtils {

	/**
	 * 转换为MongoDB的属性配置
	 * 
	 * @param dbOptions
	 *            自定义的属性配置
	 * @return MongoDB的属性配置
	 */
	public static MongoClientOptions toMongoOptions(MongoDBOptions dbOptions) {
		MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();
		optionsBuilder.socketTimeout(dbOptions.getConnectTimeout());
		optionsBuilder.socketKeepAlive(dbOptions.isSocketKeepAlive());
		optionsBuilder.connectionsPerHost(dbOptions.getConnectionsPerHost());
		optionsBuilder.description(dbOptions.getDescription());
		optionsBuilder.connectTimeout(dbOptions.getConnectTimeout());
		// add by jly 2017-07-26 增加副本集名称
		String requiredReplicaSetName = dbOptions.getRequiredReplicaSetName();
		if (StringUtils.isNotBlank(requiredReplicaSetName)) {// 空字符串不能通过，否则未设置副本集启动会报错
			optionsBuilder.requiredReplicaSetName(requiredReplicaSetName);
		}

		// 读取类型
		String readPreference = dbOptions.getReadPreference();
		if (StringUtils.isEmpty(readPreference)) {
			readPreference = "";
		}

		readPreference = readPreference.toLowerCase();

		// 就近读取
		if ("nearest".equalsIgnoreCase(readPreference)) {
			optionsBuilder.readPreference(ReadPreference.nearest());
		} else if ("secondary".equals(readPreference)) {// 从从属服务器读取
			optionsBuilder.readPreference(ReadPreference.secondary());
		} else if ("primarypreferred".equals(readPreference)) {// 优先从主服务器读取
			optionsBuilder.readPreference(ReadPreference.primaryPreferred());
		} else if ("secondarypreferred".equals(readPreference)) {// 优先从从服务器读取
			optionsBuilder.readPreference(ReadPreference.secondaryPreferred());
		} else {// 从主服务器读取
			optionsBuilder.readPreference(ReadPreference.primary());
		}
		optionsBuilder.cursorFinalizerEnabled(dbOptions.isCursorFinalizerEnabled());
		optionsBuilder.maxWaitTime(dbOptions.getMaxWaitTime());
		optionsBuilder.threadsAllowedToBlockForConnectionMultiplier(dbOptions.getThreadsAllowedToBlockForConnectionMultiplier());
		return optionsBuilder.build();
		// options.setFsync(dbOptions.isFsync());
		// options.setJ(dbOptions.isJ());
		// options.setMaxAutoConnectRetryTime(dbOptions.getMaxAutoConnectRetryTime());
		// options.setMaxWaitTime(dbOptions.getMaxWaitTime());

		// options.setSafe(dbOptions.isSafe());
		// options.setSocketKeepAlive(dbOptions.isSocketKeepAlive());
		// options.setSocketTimeout(dbOptions.getSocketTimeout());
		// options.setWtimeout(dbOptions.getWtimeout());

		// return options;
	}

	/**
	 * 创建连接池
	 * 
	 * @param mongoCfg
	 *            配置对象
	 * @return CcipMorphia
	 * @throws NumberFormatException
	 * @throws UnknownHostException
	 * @throws MongoException
	 * @throws FrameworkException
	 */
	public static MongoDBPool cretateMongodb(MongoDBConfig mongoCfg)
			throws NumberFormatException, UnknownHostException, MongoException, FrameworkException {

		MongoDBPool ccipM = new MongoDBPool();

		// 2013-04-11 add by xhuatang
		// 添加集群的配置，可以设置多个IP地址多个端口号
		String[] addresses = mongoCfg.getAddress().split(",");
		String[] ports = mongoCfg.getPort().split(",");

		// 配置的ip地址与端口的个数需要能够相等
		if (addresses.length != ports.length || addresses.length < 1) {
			throw new FrameworkException(ExceptionType.ERROR, "");
		}

		MongoClient mongoClient = null;
		MongoCredential credential = null;

		// 如果需要验证，添加库的验证信息
		if (mongoCfg.isNeedAuth()) {

			// 添加验证票据
			credential = MongoCredential.createMongoCRCredential(mongoCfg.getUsername(), mongoCfg.getDbname(), mongoCfg.getPassword().toCharArray());
		}

		MongoClientOptions options = toMongoOptions(mongoCfg.getOptions());
		if (addresses.length == 1) {
			ServerAddress mongoServerAddress = new ServerAddress(mongoCfg.getAddress(), Integer.parseInt(mongoCfg.getPort()));

			if (null == credential) {
				mongoClient = new MongoClient(mongoServerAddress, options);
			} else {
				mongoClient = new MongoClient(mongoServerAddress, credential, options);
			}
			// mongo = new Mongo(mongoServerAddress, options);
		} else {
			List<ServerAddress> listServerAddress = new ArrayList<ServerAddress>();
			for (int i = 0; i < addresses.length; i++) {
				listServerAddress.add(new ServerAddress(addresses[i], Integer.parseInt(ports[i])));
			}
			if (null == credential) {
				mongoClient = new MongoClient(listServerAddress, options);
			} else {
				mongoClient = new MongoClient(listServerAddress, credential, options);
			}
			mongoClient.setReadPreference(ReadPreference.secondary());
			// options.setReadPreference(ReadPreference.secondary());
			// mongo = new Mongo(listServerAddress, options);
		}

		ccipM.setMongoDBConfig(mongoCfg);

		ccipM.setMongoClient(mongoClient);
		Morphia morphia = new Morphia();
		ccipM.setMorphia(morphia);

		// 数据库不为空时，初始化
		if (StringUtils.isNotEmpty(mongoCfg.getDbname())) {
			setDatastore(ccipM);
		}

		return ccipM;
	}

	/**
	 * 根据Mongo，Morphia，创建Datastore
	 * 
	 * @param mongo  MongoClient
	 * @param morphia Morphia
	 * @param dbName 数据库名称
	 * @param username 用户名称
	 * @param password 密码
	 * @return Datastore
	 * @throws FrameworkException
	 */
	public static Datastore createDatastore(MongoClient mongo, Morphia morphia, String dbName, String username, String password) throws FrameworkException {
		Datastore da = null;
		// if (isNeedAuth){
		// da = morphia.createDatastore(mongo,dbName,username,password.toCharArray());
		// } else {
		// da = morphia.createDatastore(mongo,dbName);
		// }
		da = morphia.createDatastore(mongo, dbName);
		if (null == da) {
			throw new FrameworkException(ExceptionType.ERROR, "00037");
		}
		return da;
	}

	/**
	 * 每次都重设置Datastore
	 * 
	 * @param ccipM
	 *            MongoDBPool
	 * @throws FrameworkException
	 */
	static void setDatastore(MongoDBPool ccipM) throws FrameworkException {
		MongoDBConfig mongoCfg = ccipM.getMongoDBConfig();
		MongoClient mongo = ccipM.getMongoClient();
		Morphia morphia = ccipM.getMorphia();

		String username = mongoCfg.getUsername();
		String password = mongoCfg.getPassword();
		String dbName = mongoCfg.getDbname();
		Datastore da = createDatastore(mongo, morphia, dbName, username, password);
		ccipM.setDatastore(da);
	}

	/**
	 * 判断要创建的数据库是否已经存在
	 * 
	 * @param host 服务器的地址
	 * @param port  服务器的端口号
	 * @param dbName 数据库名称
	 * @return 不存在返回 true
	 * @throws FrameworkException
	 */
	public static boolean isNoExistMongoDb(String host, int port, String dbName) throws FrameworkException {
		boolean isExist = true;
		MongoClient mongo = null;
		// 下面判断数据库是否已经存在
		try {
			ServerAddress mongoServerAddress = new ServerAddress(host, port);
			mongo = new MongoClient(mongoServerAddress);

			List<String> dbNameList = mongo.getDatabaseNames();
			if (dbNameList.contains(dbName)) {
				// Set<String> tables = mongo.getDB(dbName).getCollectionNames();
				// if(tables!=null && !tables.isEmpty()){
				// //说明有实际的表，则说明已经存在
				// throw new FrameworkException(ExceptionType.ERROR, "00038", dbName,
				// host, port+"");
				// }
				// modify by jly 2017-05-17 mongodb3.0以上版本通过以上方法获取集合名称列表为空，
				// 改为根据集合数据总量判断数据库是否是空数据库
				CommandResult commandResult = mongo.getDB(dbName).getStats();
				double dataSize = commandResult.getDouble("dataSize");
				if (dataSize > 0) {// 说明有数据存在，
					throw new FrameworkException(ExceptionType.ERROR, "00038", dbName, host, port + "");
				}
			}
			mongo.close();
			mongo = null;
		} catch (NumberFormatException e) {
			throw new FrameworkException(ExceptionType.ERROR, e, "00039", e.getMessage());
		} catch (MongoTimeoutException e) {
			throw new FrameworkException(ExceptionType.ERROR, e, "00072", e.getMessage());
		} finally {
			if (mongo != null) {
				mongo.close();
				mongo = null;
			}
		}
		return isExist;
	}

	/**
	 * 判断是否有安装MongoDB服务
	 * 
	 * @param host
	 *            服务器的地址
	 * @param port
	 *            服务器的端口号
	 * @return 判断MongoDb服务是否存在，不存在返回true
	 * @throws FrameworkException
	 */
	public static boolean isNoExistMongo(String host, int port) throws FrameworkException {
		boolean isExist = true; // 先默认为不存在
		MongoClient mongo = null;
		try {
			ServerAddress mongoServerAddress = new ServerAddress(host, port);
			mongo = new MongoClient(mongoServerAddress);
			List<String> dbNameList = mongo.getDatabaseNames();
			if (null != dbNameList && !dbNameList.isEmpty()) {
				isExist = false; // 说明已经存在
			}
		} catch (MongoException e) {
			// 不处理;

		} finally {
			if (mongo != null) {
				mongo.close();
			}
		}
		return isExist;
	}

	/**
	 * 与默认的配置合并
	 * 
	 * @param mongoDBConfig
	 * @throws FrameworkException
	 */
	public static void mergeMongoDBConfig(MongoDBConfig mongoDBConfig, MongoDBConfig defaultConfig) throws FrameworkException {

		// 与默认的配置合并
		// MongoDBConfig defaultConfig = MongoDBConfigFactory.getBundleMongoDBConfig();

		if (StringUtils.isEmpty(mongoDBConfig.getAddress())) {
			mongoDBConfig.setAddress(defaultConfig.getAddress());
		}
		if (StringUtils.isEmpty(mongoDBConfig.getPort())) {
			mongoDBConfig.setPort(defaultConfig.getPort());
		}
		if (StringUtils.isEmpty(mongoDBConfig.getUsername())) {
			mongoDBConfig.setUsername(defaultConfig.getUsername());
		}
		if (StringUtils.isEmpty(mongoDBConfig.getPassword())) {
			mongoDBConfig.setPassword(defaultConfig.getPassword());
		}

		if (null == mongoDBConfig.getOptions()) {
			mongoDBConfig.setOptions(defaultConfig.getOptions());
		}
	}

	/**
	 * 删除数据库
	 * 
	 * @param mongo
	 *            Mongo对象
	 * @param dbName
	 *            数据库名称
	 */
	public static void dropDatabase(Mongo mongo, String dbName) {
		if (null != mongo && StringUtils.isNotEmpty(dbName)) {
			mongo.dropDatabase(dbName);

			// 2013-08-26 modify by cshiyong begin
			// 连接的释放应在移除连接池对象时进行
			// mongo.close();
			// mongo = null;
			// 2013-08-26 modify by cshiyong end

		}
	}

	/**
	 * 获取MongoDBConfig唯一的 KEY，为服务器地址+端口号+数据库名称
	 * 
	 * @param mongoCfg
	 * @return
	 */
	public static String getKey(MongoDBConfig mongoCfg) {
		String key = mongoCfg.getAddress() + mongoCfg.getPort() + mongoCfg.getDbname();
		return key;
	}

}
