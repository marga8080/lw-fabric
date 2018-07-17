package com.linewell.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public class BeanUtil {
	private static Log log = LogFactory.getLog(BeanUtil.class);
	public static final String SPELLFIELD_SUFFIX_NAME = "PinYin";
	public static final String CUSTOM_PACKAGE_PREFIX = "com.linewell.";

	public static void setValue(Object paramObject1, String paramString, Object paramObject2) {
		try {
			BeanUtils.setProperty(paramObject1, paramString, paramObject2);
		} catch (IllegalAccessException localIllegalAccessException) {
			localIllegalAccessException.printStackTrace();
		} catch (InvocationTargetException localInvocationTargetException) {
			localInvocationTargetException.printStackTrace();
		}
	}

	public static String getValue(Object paramObject, String paramString) {
		try {
			return BeanUtils.getProperty(paramObject, paramString);
		} catch (IllegalAccessException localIllegalAccessException) {
			localIllegalAccessException.printStackTrace();
		} catch (InvocationTargetException localInvocationTargetException) {
			localInvocationTargetException.printStackTrace();
		} catch (NoSuchMethodException localNoSuchMethodException) {
			localNoSuchMethodException.printStackTrace();
		}
		return null;
	}

	public static <T> T jsonToBean(String paramString, Class<T> paramClass) {
		Gson localGson = new Gson();
		return (T) localGson.fromJson(paramString, paramClass);
	}

	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(JsonElement paramJsonElement, Class<T> paramClass) {
		Gson localGson = new Gson();
		Object localObject = localGson.fromJson(paramJsonElement, paramClass);
		localGson = null;
		return (T) localObject;
	}

	public static void setSpellFieldValue(Object paramObject) {
		PropertyDescriptor[] arrayOfPropertyDescriptor1 = PropertyUtils.getPropertyDescriptors(paramObject);
		if (arrayOfPropertyDescriptor1 != null) {
			PropertyDescriptor[] arrayOfPropertyDescriptor2;
			int j = (arrayOfPropertyDescriptor2 = arrayOfPropertyDescriptor1).length;
			for (int i = 0; i < j; i++) {
				PropertyDescriptor localPropertyDescriptor = arrayOfPropertyDescriptor2[i];
				String str1 = localPropertyDescriptor.getName();
				Class<?> localClass = localPropertyDescriptor.getPropertyType();
				String str2 = localClass.getName();
				Object localObject = null;
				if (str2.indexOf("com.linewell.") >= 0) {
					try {
						localObject = PropertyUtils.getProperty(paramObject, str1);
					} catch (IllegalAccessException localIllegalAccessException) {
						log.error(localIllegalAccessException);
					} catch (InvocationTargetException localInvocationTargetException) {
						log.error(localInvocationTargetException);
					} catch (NoSuchMethodException localNoSuchMethodException) {
						log.error(localNoSuchMethodException);
					}
					if (localObject != null) {
						setSpellFieldValue(localObject);
					}
				} else if ((str1 != null) && (str1.endsWith("PinYin"))) {
					String str3 = str1.substring(0, str1.lastIndexOf("PinYin"));
					String str4 = getValue(paramObject, str3);
					String str5 = "";
					if (str4 != null) {
						str5 = PinyinUtil.DA833A2AC4A7DCB2A62E5E5BC48CB993(str4, false);
					}
					setValue(paramObject, str1, str5);
				}
			}
		}
	}
}
