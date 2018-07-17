package com.linewell.common.mongodb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.xml.sax.SAXException;

import com.linewell.common.Constants;
import com.linewell.common.exception.ExceptionType;
import com.linewell.common.exception.FrameworkException;
import com.linewell.common.utils.Dom4jUtil;

/**
 * 只提供给NameNode使用 mongodb配置对象的解析
 * 
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public class XmlConfigManager {

	/**
	 * mongodb配置的文件名
	 */
	final static String CONFIG_XML_FILE_NAME = "mongodb.xml";

	/**
	 * mongodb配置文件的验证xsd
	 */
	private final static String CONFIG_XSD_FILE_NAME = "mongodb.xsd";


	/**
	 * 默认的配置的别名
	 */
	final static String DEFAULF_ALIAS = "ccip";

	/**
	 * 保存Bundle启动、分类的配置库别名
	 */
	final static String BUNDLE_ALIAS = "bundle";

	/**
	 * 保存Log启动、分类的配置库别名
	 */
	final static String LOG_ALIAS = "log";

	/**
	 * 用户库配置信息
	 */
	final static String USER_ALIAS = "user";

	/**
	 * 监控库配置信息
	 */
	final static String MONITOR_ALIAS = "monitor";

	/**
	 * 会话库存储信息
	 */
	final static String SESSION_ALIAS = "session";

	/**
	 * 应用库的配置别名
	 */
	final static String APP_ALIAS = "app";

	/**
	 * admin的配置别名
	 */
	final static String ADMIN_ALIAS = "admin";

	/**
	 * fabric的配置别名
	 */
	final static String FABRIC_ALIAS = "fabric";

	/**
	 * 默认的端口号
	 */
	private final static String DEFAULT_PORT = "27017";

	/**
	 * 默认SOCKET超时时间
	 */
	private final static int DEFAULT_SOCKEY_TIMEOUT = 2000;

	// 单实例对象
	private static XmlConfigManager configManager;

	// 2013-04-16 add by xhuatang
	// 设置全局的MongoDBConfig的List配置对象
	private static final List<MongoDBConfig> configList = new ArrayList<MongoDBConfig>();

	/**
	 * 配置的xml文件名，包括路径
	 */
	private String xmlFileName;

	private XmlConfigManager() {

	}

	/**
	 * 单实例的获取
	 * 
	 * @return XmlConfigManager
	 * @throws FrameworkException
	 */
	public static synchronized XmlConfigManager getInstance() throws FrameworkException {
		if (null == configManager) {
			configManager = new XmlConfigManager();
		}
		return configManager;
	}

	/**
	 * 获取MongoDb的配置对象
	 * 
	 * @return
	 * @throws FrameworkException
	 */
	private Document getDoc() throws FrameworkException {
		this.xmlFileName = this.getConfigFileName();
		String xsdFileName = getMongoDBConfigPath() + File.separator + CONFIG_XSD_FILE_NAME;

		File xmlFile = new File(xmlFileName);
		File xsdFile = new File(xsdFileName);

		Dom4jUtil dom4jUtil = Dom4jUtil.getInstance();

		try {
			boolean result = dom4jUtil.validateXmlByXsd(xmlFile, xsdFile);
			if (!result) {
				throw new FrameworkException(ExceptionType.ERROR, "00030");
			}
		} catch (SAXException e) {
			throw new FrameworkException(ExceptionType.ERROR, e, "00029", e.getMessage());
		} catch (IOException e) {
			throw new FrameworkException(ExceptionType.ERROR, e, "00006", e.getMessage());
		}

		Document doc = dom4jUtil.getXmlDocByFileName(xmlFileName);
		if (null == doc) {
			throw new FrameworkException(ExceptionType.ERROR, "00031", xmlFileName);
		}

		return doc;
	}

	/**
	 * yjy 2013-7-10
	 * 
	 * @throws FrameworkException
	 */
	public void initConfig() throws FrameworkException {
		if (configList.size() > 0) {
			// 说明初始化过了
			return;
		}
		this.xmlFileName = getMongoDBConfigPath() + File.separator + CONFIG_XML_FILE_NAME;
		File xmlFile = new File(xmlFileName);

		if (xmlFile.exists()) {
			// 文件存在，则以文件的方式初始化mongoDb的配置信息
			this.initXMLConfig();
		}
	}
	
	private String getMongoDBConfigPath() {
		return this.getClass().getResource("/mongodb").getPath();
	}

	/**
	 * 把配置文件中的内容读出
	 * 
	 * @throws FrameworkException
	 */
	private void initXMLConfig() throws FrameworkException {

		Document doc = this.getDoc();

		Element root = doc.getRootElement();

		List<?> nodes = root.selectNodes("mongo");

		String nodeName = "node";
		//nodeName = FrameworkConfigManager.getInstance().getConfig().getNodeName();

		for (int i = 0; i < nodes.size(); i++) {
			MongoDBConfig mongodbConfig = new MongoDBConfig();

			mongodbConfig.setNodeName(nodeName);

			Element element = (Element) nodes.get(i);

			Node node = element.selectSingleNode("alias");
			if (null != node) {
				mongodbConfig.setAlias(node.getText());
			}

			node = element.selectSingleNode("address");
			if (null != node) {
				mongodbConfig.setAddress(node.getText());
			}

			node = element.selectSingleNode("port");
			if (null != node) {
				if (null == node.getText() || "".equals(node.getText().trim())) {
					mongodbConfig.setPort(DEFAULT_PORT);
				} else {
					mongodbConfig.setPort(node.getText());
				}
			}

			node = element.selectSingleNode("username");
			if (null != node) {
				mongodbConfig.setUsername(node.getText());
			}

			node = element.selectSingleNode("password");
			if (null != node) {
				mongodbConfig.setPassword(node.getText());
			}

			node = element.selectSingleNode("dbname");
			if (null != node) {
				mongodbConfig.setDbname(node.getText());
			}

			// 2013-12-20 add by xhuatang begin
			// 添加是否需要用户验证与副本集
			node = element.selectSingleNode("needAuth");
			if (null != node) {
				boolean needAuth = Boolean.parseBoolean(node.getText());
				mongodbConfig.setNeedAuth(needAuth);
			}

			node = element.selectSingleNode("replicaSetSeeds");
			if (null != node) {
				mongodbConfig.setReplicaSetSeeds(node.getText());
			}
			// 2013-12-20 add by xhuatang end

			// 增加MongoDB连接池配置
			MongoDBOptions options = new MongoDBOptions();

			String value = "";

			// 每个主机的连接数
			node = element.selectSingleNode("connectionsPerHost");
			if (null != node) {
				value = node.getText();
				if (StringUtils.isNotEmpty(value)) {
					options.setConnectionsPerHost(Integer.parseInt(value));
				}
			}
			// 线程队列数
			node = element.selectSingleNode("threadsAllowedToBlockForConnectionMultiplier");
			if (null != node) {
				value = node.getText();
				if (StringUtils.isNotEmpty(value)) {
					options.setThreadsAllowedToBlockForConnectionMultiplier(Integer.parseInt(value));
				}
			}
			// 最大等待连接的线程阻塞时间
			node = element.selectSingleNode("maxWaitTime");
			if (null != node) {
				value = node.getText();
				if (StringUtils.isNotEmpty(value)) {
					options.setMaxWaitTime(Integer.parseInt(value));
				}
			}

			// 连接超时的毫秒
			node = element.selectSingleNode("connectTimeout");
			if (null != node) {
				value = node.getText();
				if (StringUtils.isNotEmpty(value)) {
					options.setConnectTimeout(Integer.parseInt(value));
				}
			}

			// socket超时
			node = element.selectSingleNode("socketTimeout");
			if (null != node) {
				value = node.getText();
				if (StringUtils.isNotEmpty(value)) {
					options.setSocketTimeout(Integer.parseInt(value));
				} else {
					options.setSocketTimeout(DEFAULT_SOCKEY_TIMEOUT);
				}
			} else {
				options.setSocketTimeout(DEFAULT_SOCKEY_TIMEOUT);
			}

			// 这个控制是否在一个连接时，系统会自动重试
			node = element.selectSingleNode("autoConnectRetry");
			if (null != node) {
				value = node.getText();
				if (StringUtils.isNotEmpty(value)) {
					options.setAutoConnectRetry(Boolean.parseBoolean(value));
				}
			}

			// socket是否保持活动
			node = element.selectSingleNode("socketKeepAlive");
			if (null != node) {
				value = node.getText();
				if (StringUtils.isNotEmpty(value)) {
					options.setSocketKeepAlive(Boolean.parseBoolean(value));
				}
			}

			// add by jly 2017-07-26 增加副本集名称
			options.setRequiredReplicaSetName(mongodbConfig.getReplicaSetSeeds());

			mongodbConfig.setOptions(options);
			configList.add(mongodbConfig);
		}
	}

	/**
	 * 获取默认的配置
	 * 
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getCcipConfig() throws FrameworkException {
		return this.getConfig(DEFAULF_ALIAS);
	}

	/**
	 * 获取保存Bundle启动、分类的配置库的mongodb配置
	 * 
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getBundleConfig() throws FrameworkException {
		return this.getConfig(BUNDLE_ALIAS);
	}

	/**
	 * 获取保存log库的mongodb配置
	 * 
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getLogConfig() throws FrameworkException {
		return this.getConfig(LOG_ALIAS);
	}

	/**
	 * 获取用户库配置信息
	 * 
	 * @return 用户库配置信息 MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getUserConfig() throws FrameworkException {
		return this.getConfig(USER_ALIAS);
	}

	/**
	 * 获取监控库配置信息
	 * 
	 * @return 监控库配置信息
	 * @throws FrameworkException
	 */
	public MongoDBConfig getMonitorConfig() throws FrameworkException {
		return this.getConfig(MONITOR_ALIAS);
	}

	/**
	 * 获取会话库配置信息
	 * 
	 * @return 会话库配置信息
	 * @throws FrameworkException
	 */
	public MongoDBConfig getSessionConfig() throws FrameworkException {
		return this.getConfig(SESSION_ALIAS);
	}

	/**
	 * 获取应用库的配置
	 * 
	 * @return MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getAppConfig() throws FrameworkException {
		return this.getConfig(APP_ALIAS);
	}

	/**
	 * 根据别名获取配置信息
	 * 
	 * @param alias
	 * @return
	 * @throws FrameworkException
	 */
	public MongoDBConfig getConfig(String alias) throws FrameworkException {
		if (null == configList || configList.isEmpty()) {
			System.out.println("XmlConfigManager:getConfig（） alias:" + alias);
			XmlConfigManager xmlConfig = XmlConfigManager.getInstance();
			xmlConfig.initConfig();
			// throw new FrameworkException(ExceptionType.ERROR, "00031", xmlFileName);
		}
		MongoDBConfig aliasConfig = null;
		String aliasLower = alias.toLowerCase();
		for (MongoDBConfig mongodbConfig : configList) {
			if (aliasLower.equals(mongodbConfig.getAlias().toLowerCase())) {
				aliasConfig = mongodbConfig;
				break;
			}
		}
		return aliasConfig;
	}

	/**
	 * 判断别名是否已经存在
	 * 
	 * @param alias
	 * @return 存在返回true
	 */
	boolean isExit(String alias) {
		boolean isExit = false;
		try {
			MongoDBConfig cfg = this.getConfig(alias);
			if (null != cfg) {
				isExit = true;
			}
		} catch (FrameworkException e) {
			e.printStackTrace();
		}
		return isExit;
	}

	/**
	 * 保存一新的配置对象，根据默认的取值
	 * 
	 * @param alias
	 *            别名
	 * @param nodeName
	 *            分布式节点名称
	 * @param mongoDBConfig
	 *            MongoDBConfig 配置对象 如果为空，则以默认的设置
	 * @return
	 * @throws FrameworkException
	 */
	@SuppressWarnings("unchecked")
	boolean save(String alias, MongoDBConfig mongoDBConfig) throws FrameworkException {

		if (this.isExit(alias)) {
			throw new FrameworkException(ExceptionType.ERROR, "00032", CONFIG_XML_FILE_NAME, alias);
		}

		// 还要判断新建的数据库是否存在

		Dom4jUtil dom4jUtil = Dom4jUtil.getInstance();

		Document doc = this.getDoc();

		Element root = doc.getRootElement();
		List<Element> nodes = root.selectNodes("mongo");

		// 先取出默认的配置
		Element defaultElemnet = null;
		for (int i = 0; i < nodes.size(); i++) {
			Element element = (Element) nodes.get(i);
			Node node = element.selectSingleNode("alias");
			if (node != null && node.getText().equals(DEFAULF_ALIAS)) {
				defaultElemnet = element;
				break;
			}
		}
		if (null == defaultElemnet) {
			throw new FrameworkException(ExceptionType.ERROR, "00033", CONFIG_XML_FILE_NAME, DEFAULF_ALIAS);
		}

		// 作一个拷贝
		Element newElement = defaultElemnet.createCopy();

		Node node = newElement.selectSingleNode("alias");
		node.setText(alias);

		node = newElement.selectSingleNode("dbname");
		if (null != node) {
			node.setText(mongoDBConfig.getDbname());
		}

		node = newElement.selectSingleNode("address");
		if (null != node) {
			node.setText(mongoDBConfig.getAddress());
		}

		node = newElement.selectSingleNode("port");
		if (null != node) {
			node.setText(mongoDBConfig.getPort());
		}

		node = newElement.selectSingleNode("username");
		if (null != node) {
			node.setText(mongoDBConfig.getUsername());
		}

		node = newElement.selectSingleNode("password");
		if (null != node) {
			node.setText(mongoDBConfig.getPassword());
		}

		nodes.add(newElement);

		root.setContent(nodes);

		// System.out.println("ok");
		// dom4jUtil.outPutSystemOut(doc, Constants.DEFAULT_CHARSET);

		dom4jUtil.outPutXmlToFile(doc, this.xmlFileName, Constants.DEFAULT_CHARSET);

		// 重新更新
		this.initConfig();

		return true;
	}

	/**
	 * 删除别名对应的配置
	 * 
	 * @param alias
	 * @return
	 * @throws FrameworkException
	 */
	boolean delete(String alias) throws FrameworkException {

		if (!this.isExit(alias)) {
			throw new FrameworkException(ExceptionType.ERROR, "00033", CONFIG_XML_FILE_NAME, alias);
		}

		Document doc = this.getDoc();

		Element root = doc.getRootElement();

		List<?> nodes = root.selectNodes("mongo");

		// 先取出配置
		Element delElemnet = null;
		for (int i = 0; i < nodes.size(); i++) {
			Element element = (Element) nodes.get(i);
			Node node = element.selectSingleNode("alias");
			if (node != null && node.getText().equals(alias)) {
				delElemnet = element;
				break;
			}
		}
		if (null == delElemnet) {
			throw new FrameworkException(ExceptionType.ERROR, "00033", CONFIG_XML_FILE_NAME, DEFAULF_ALIAS);
		}

		nodes.remove(delElemnet);
		root.setContent(nodes);

		Dom4jUtil dom4jUtil = Dom4jUtil.getInstance();
		dom4jUtil.outPutXmlToFile(doc, this.xmlFileName, Constants.DEFAULT_CHARSET);

		// 重新更新
		this.initConfig();

		return true;
	}

	/**
	 * 返回所有的配置信息列表
	 * 
	 * @return
	 */
	List<MongoDBConfig> getConfigList() {
		return configList;
	}

	/**
	 * 获取配置文件的完整的路径名
	 * 
	 * @return 配置文件的完整的路径名
	 */
	public String getConfigFileName() {
		String xmlFileName = getMongoDBConfigPath() + File.separator + CONFIG_XML_FILE_NAME;
		return xmlFileName;
	}


	/**
	 * 获取admin配置信息
	 * 
	 * @return admin配置信息 MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getAdminConfig() throws FrameworkException {
		return this.getConfig(ADMIN_ALIAS);
	}

	/**
	 * 获取Fabric配置信息
	 * 
	 * @return admin配置信息 MongoDBConfig
	 * @throws FrameworkException
	 */
	public MongoDBConfig getFabricConfig() throws FrameworkException {
		return this.getConfig(FABRIC_ALIAS);
	}
}
