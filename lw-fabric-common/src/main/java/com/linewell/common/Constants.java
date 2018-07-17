package com.linewell.common;

public abstract interface Constants {
	public static final String BUNDLE_EXTEND_IMPL = "Bundle-ExtendImplKey";
	public static final String SYSTEM_BUNDLE_LOCATION = "System Bundle";
	public static final String SYSTEM_BUNDLE_SYMBOLICNAME = "system.bundle";
	public static final String BUNDLE_CATEGORY = "Bundle-Category";
	public static final String BUNDLE_CLASSPATH = "Bundle-ClassPath";
	public static final String BUNDLE_COPYRIGHT = "Bundle-Copyright";
	public static final String BUNDLE_DESCRIPTION = "Bundle-Description";
	public static final String BUNDLE_NAME = "Bundle-Name";
	public static final String BUNDLE_TYPE = "Bundle-Type";
	public static final String BUNDLE_NATIVECODE = "Bundle-NativeCode";
	public static final String EXPORT_PACKAGE = "Export-Package";
	/**
	 * @deprecated
	 */
	public static final String EXPORT_SERVICE = "Export-Service";
	public static final String IMPORT_PACKAGE = "Import-Package";
	public static final String DYNAMICIMPORT_PACKAGE = "DynamicImport-Package";
	/**
	 * @deprecated
	 */
	public static final String IMPORT_SERVICE = "Import-Service";
	public static final String BUNDLE_VENDOR = "Bundle-Vendor";
	public static final String BUNDLE_VERSION = "Bundle-Version";
	public static final String BUNDLE_DOCURL = "Bundle-DocURL";
	public static final String BUNDLE_CONTACTADDRESS = "Bundle-ContactAddress";
	public static final String BUNDLE_ACTIVATOR = "Bundle-Activator";
	public static final String BUNDLE_UPDATELOCATION = "Bundle-UpdateLocation";
	/**
	 * @deprecated
	 */
	public static final String PACKAGE_SPECIFICATION_VERSION = "specification-version";
	public static final String BUNDLE_NATIVECODE_PROCESSOR = "processor";
	public static final String BUNDLE_NATIVECODE_OSNAME = "osname";
	public static final String BUNDLE_NATIVECODE_OSVERSION = "osversion";
	public static final String BUNDLE_NATIVECODE_LANGUAGE = "language";
	/**
	 * @deprecated
	 */
	public static final String BUNDLE_REQUIREDEXECUTIONENVIRONMENT = "Bundle-RequiredExecutionEnvironment";
	public static final String BUNDLE_SYMBOLICNAME = "Bundle-SymbolicName";
	public static final String SINGLETON_DIRECTIVE = "singleton";
	public static final String FRAGMENT_ATTACHMENT_DIRECTIVE = "fragment-attachment";
	public static final String FRAGMENT_ATTACHMENT_ALWAYS = "always";
	public static final String FRAGMENT_ATTACHMENT_RESOLVETIME = "resolve-time";
	public static final String FRAGMENT_ATTACHMENT_NEVER = "never";
	public static final String BUNDLE_LOCALIZATION = "Bundle-Localization";
	public static final String BUNDLE_LOCALIZATION_DEFAULT_BASENAME = "OSGI-INF/l10n/bundle";
	public static final String REQUIRE_BUNDLE = "Require-Bundle";
	public static final String BUNDLE_VERSION_ATTRIBUTE = "bundle-version";
	public static final String FRAGMENT_HOST = "Fragment-Host";
	public static final String SELECTION_FILTER_ATTRIBUTE = "selection-filter";
	public static final String BUNDLE_MANIFESTVERSION = "Bundle-ManifestVersion";
	public static final String VERSION_ATTRIBUTE = "version";
	public static final String BUNDLE_SYMBOLICNAME_ATTRIBUTE = "bundle-symbolic-name";
	public static final String RESOLUTION_DIRECTIVE = "resolution";
	public static final String RESOLUTION_MANDATORY = "mandatory";
	public static final String RESOLUTION_OPTIONAL = "optional";
	public static final String USES_DIRECTIVE = "uses";
	public static final String INCLUDE_DIRECTIVE = "include";
	public static final String EXCLUDE_DIRECTIVE = "exclude";
	public static final String MANDATORY_DIRECTIVE = "mandatory";
	public static final String VISIBILITY_DIRECTIVE = "visibility";
	public static final String VISIBILITY_PRIVATE = "private";
	public static final String VISIBILITY_REEXPORT = "reexport";
	public static final String EXTENSION_DIRECTIVE = "extension";
	public static final String EXTENSION_FRAMEWORK = "framework";
	public static final String EXTENSION_BOOTCLASSPATH = "bootclasspath";
	public static final String BUNDLE_ACTIVATIONPOLICY = "Bundle-ActivationPolicy";
	public static final String ACTIVATION_LAZY = "lazy";
	public static final String FRAMEWORK_VERSION = "org.osgi.framework.version";
	public static final String FRAMEWORK_VENDOR = "org.osgi.framework.vendor";
	public static final String FRAMEWORK_LANGUAGE = "org.osgi.framework.language";
	public static final String FRAMEWORK_OS_NAME = "org.osgi.framework.os.name";
	public static final String FRAMEWORK_OS_VERSION = "org.osgi.framework.os.version";
	public static final String FRAMEWORK_PROCESSOR = "org.osgi.framework.processor";
	/**
	 * @deprecated
	 */
	public static final String FRAMEWORK_EXECUTIONENVIRONMENT = "org.osgi.framework.executionenvironment";
	public static final String FRAMEWORK_BOOTDELEGATION = "org.osgi.framework.bootdelegation";
	public static final String FRAMEWORK_SYSTEMPACKAGES = "org.osgi.framework.system.packages";
	public static final String FRAMEWORK_SYSTEMPACKAGES_EXTRA = "org.osgi.framework.system.packages.extra";
	public static final String SUPPORTS_FRAMEWORK_EXTENSION = "org.osgi.supports.framework.extension";
	public static final String SUPPORTS_BOOTCLASSPATH_EXTENSION = "org.osgi.supports.bootclasspath.extension";
	public static final String SUPPORTS_FRAMEWORK_FRAGMENT = "org.osgi.supports.framework.fragment";
	public static final String SUPPORTS_FRAMEWORK_REQUIREBUNDLE = "org.osgi.supports.framework.requirebundle";
	public static final String FRAMEWORK_SECURITY = "org.osgi.framework.security";
	public static final String FRAMEWORK_SECURITY_OSGI = "osgi";
	public static final String FRAMEWORK_STORAGE = "org.osgi.framework.storage";
	public static final String FRAMEWORK_STORAGE_CLEAN = "org.osgi.framework.storage.clean";
	public static final String FRAMEWORK_STORAGE_CLEAN_ONFIRSTINIT = "onFirstInit";
	public static final String FRAMEWORK_LIBRARY_EXTENSIONS = "org.osgi.framework.library.extensions";
	public static final String FRAMEWORK_EXECPERMISSION = "org.osgi.framework.command.execpermission";
	public static final String FRAMEWORK_COMMAND_ABSPATH = "abspath";
	public static final String FRAMEWORK_TRUST_REPOSITORIES = "org.osgi.framework.trust.repositories";
	public static final String FRAMEWORK_WINDOWSYSTEM = "org.osgi.framework.windowsystem";
	public static final String FRAMEWORK_BEGINNING_STARTLEVEL = "org.osgi.framework.startlevel.beginning";
	public static final String FRAMEWORK_BUNDLE_PARENT = "org.osgi.framework.bundle.parent";
	public static final String FRAMEWORK_BUNDLE_PARENT_BOOT = "boot";
	public static final String FRAMEWORK_BUNDLE_PARENT_EXT = "ext";
	public static final String FRAMEWORK_BUNDLE_PARENT_APP = "app";
	public static final String FRAMEWORK_BUNDLE_PARENT_FRAMEWORK = "framework";
	public static final String OBJECTCLASS = "objectClass";
	public static final String SERVICE_ID = "service.id";
	public static final String SERVICE_PID = "service.pid";
	public static final String SERVICE_RANKING = "service.ranking";
	public static final String SERVICE_VENDOR = "service.vendor";
	public static final String SERVICE_DESCRIPTION = "service.description";
	public static final String FRAMEWORK_UUID = "org.osgi.framework.uuid";
	public static final String REMOTE_CONFIGS_SUPPORTED = "remote.configs.supported";
	public static final String REMOTE_INTENTS_SUPPORTED = "remote.intents.supported";
	public static final String SERVICE_EXPORTED_CONFIGS = "service.exported.configs";
	public static final String SERVICE_EXPORTED_INTENTS = "service.exported.intents";
	public static final String SERVICE_EXPORTED_INTENTS_EXTRA = "service.exported.intents.extra";
	public static final String SERVICE_EXPORTED_INTERFACES = "service.exported.interfaces";
	public static final String SERVICE_IMPORTED = "service.imported";
	public static final String SERVICE_IMPORTED_CONFIGS = "service.imported.configs";
	public static final String SERVICE_INTENTS = "service.intents";
	public static final String PROVIDE_CAPABILITY = "Provide-Capability";
	public static final String REQUIRE_CAPABILITY = "Require-Capability";
	public static final String EFFECTIVE_DIRECTIVE = "effective";
	public static final String EFFECTIVE_RESOLVE = "resolve";
	public static final String EFFECTIVE_ACTIVE = "active";
	public static final String FILTER_DIRECTIVE = "filter";
	public static final String FRAMEWORK_SYSTEMCAPABILITIES = "org.osgi.framework.system.capabilities";
	public static final String FRAMEWORK_SYSTEMCAPABILITIES_EXTRA = "org.osgi.framework.system.capabilities.extra";
	public static final String FRAMEWORK_BSNVERSION = "org.osgi.framework.bsnversion";
	public static final String FRAMEWORK_BSNVERSION_MULTIPLE = "multiple";
	public static final String FRAMEWORK_BSNVERSION_SINGLE = "single";
	public static final String FRAMEWORK_BSNVERSION_MANAGED = "managed";
	
	
	/**
	 * 配置文件所在的目录
	 */
	public static final String CONFIG_FOLDER = "config";
	
	/**
	 * 默认的编码
	 */
	public static final String DEFAULT_CHARSET = "UTF-8";
	
	/**
	 * xml头部信息
	 */
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

	/**
	 * 日期时间格式 "yyyy-MM-dd HH:mm:ss"
	 */
	public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 通用字符分隔符
	 */
	public static final String STRING_SPLIT_CHAR = ",";
	
	/**
	 * 通用报和类分隔符
	 */
	public static final String CLASS_POINT = ".";
}
