package com.linewell.common;

import java.io.File;

public abstract interface CcipConstants extends Constants {
	public static final String ENVCACHEKEY = "envVariables.properties";
	public static final String FILE_SEPARATOR = File.separator;
	public static final String CONFIG_FOLDER = "config";
	public static final String COMMA_STR = ",";
	public static final String SINGLE_QUOTES = "'";
	public static final String SEMI_STR = ";";
	public static final String PLUNIN_FOLDER_PATH = "plugin";
	public static final String PLUNIN_INTERFACE_FOLDER = "interface";
	public static final String PLUNIN_IMPL_FOLDER = "impl";
	public static final String INTERFACE_TYPE = "interface";
	public static final String IMPL_TYPE = "impl";
	public static final String PLUNIN_SYS_FOLDER = "sys";
	public static final String PLUNIN_APP_FOLDER = "app";
	public static final String PLUGIN_TEMP_FOLDER = "tmp";
	public static final String DEFAULT_CHARSET = "UTF-8";
	public static final String BUNDLE_FILE_POSTFIX = "jar";
	public static final String APP_IMPL_PATH = "plugin" + File.separator + "impl" + File.separator + "app";
	public static final String APP_INTERFACE_PATH = "plugin" + File.separator + "interface" + File.separator + "app";
	public static final String SYS_IMPL_PATH = "plugin" + File.separator + "impl" + File.separator + "sys";
	public static final String SYS_INTERFACE_PATH = "plugin" + File.separator + "interface" + File.separator + "sys";
	public static final String TEMP_FOLDER = "plugin" + File.separator + "tempfolder";
	public static final String PLUGIN_CLASSLOADERS_KEY = "ccip.classloaders";
	public static final String PLUGIN_JAR_NAME_KEY = "ccip.plugin.jarname";
	public static final String PLUGIN_TYPE_KEY = "ccip.plugin.type";
	public static final String PLUGIN_CACHE_DIR_KEY = "ccip.cache.dir";
	public static final String PLUGIN_LAST_MODIFIED = "ccip.plugin.lastModified";
}
