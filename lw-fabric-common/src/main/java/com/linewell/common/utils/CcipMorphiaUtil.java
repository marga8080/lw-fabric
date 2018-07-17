package com.linewell.common.utils;

import java.beans.PropertyDescriptor;
import java.util.Iterator;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.mongodb.morphia.query.UpdateOperations;

import com.linewell.common.bean.BeanEntity;
import com.linewell.common.exception.ExceptionType;
import com.linewell.common.exception.FrameworkException;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public class CcipMorphiaUtil {
	//private static final String unid = "unid";

	public static <A> void updateOps(UpdateOperations<A> paramUpdateOperations, A paramA) throws FrameworkException {
		String[] arrayOfString = null;
		if ((paramA instanceof BeanEntity)) {
			arrayOfString = new String[] { "unid" };
		}
		updateOps(paramUpdateOperations, paramA, arrayOfString);
	}

	public static <A> void updateOps(UpdateOperations<A> paramUpdateOperations, A paramA, String[] paramArrayOfString)
			throws FrameworkException {
		if (paramUpdateOperations == null) {
			throw new FrameworkException(ExceptionType.TIP, "08107", new String[] { "ops" });
		}
		if (paramA == null) {
			throw new FrameworkException(ExceptionType.TIP, "08107", new String[] { "ops" });
		}
		if ((paramA instanceof BeanEntity)) {
			if (paramArrayOfString == null) {
				paramArrayOfString = new String[] { "unid" };
			}
			if (!ArrayUtils.contains(paramArrayOfString, "unid")) {
				paramArrayOfString = (String[]) ArrayUtils.add(paramArrayOfString, "unid");
			}
		}
		PropertyDescriptor[] arrayOfPropertyDescriptor1 = PropertyUtils.getPropertyDescriptors(paramA);
		JSONObject localJSONObject = JSONObject.fromObject(paramA);
		DA833A2AC4A7DCB2A62E5E5BC48CB993(localJSONObject);
		PropertyDescriptor[] arrayOfPropertyDescriptor2;
		int j = (arrayOfPropertyDescriptor2 = arrayOfPropertyDescriptor1).length;
		for (int i = 0; i < j; i++) {
			PropertyDescriptor localPropertyDescriptor = arrayOfPropertyDescriptor2[i];
			String str = localPropertyDescriptor.getName();
			if ((localJSONObject.containsKey(str)) && (!str.equals("class"))
					&& (!ArrayUtils.contains(paramArrayOfString, str))) {
				Object localObject = localJSONObject.get(str);
				if (((!(localObject instanceof JSONObject)) || (!JSONObject.fromObject(localObject).isNullObject()))
						&& ((!(localObject instanceof JSONArray)) || (!JSONArray.fromObject(localObject).isEmpty()))
						&& (!(localObject instanceof JSONNull))) {
					paramUpdateOperations.set(str, localObject);
				}
			}
		}
	}

	private static void DA833A2AC4A7DCB2A62E5E5BC48CB993(Object paramObject) {
		if ((paramObject == null) || (!(paramObject instanceof JSONObject))) {
			return;
		}
		JSONObject localJSONObject1 = (JSONObject) paramObject;
		JSONObject localJSONObject2 = JSONObject.fromObject(localJSONObject1.toString());
		Iterator<?> localIterator1 = localJSONObject2.keys();
		while (localIterator1.hasNext()) {
			String str = (String) localIterator1.next();
			Object localObject1 = localJSONObject1.get(str);
			if ((localObject1 instanceof JSONObject)) {
				if (!JSONObject.fromObject(localObject1).isNullObject()) {
					DA833A2AC4A7DCB2A62E5E5BC48CB993(localObject1);
				}
			} else if ((localObject1 instanceof JSONArray)) {
				if (!JSONArray.fromObject(localObject1).isEmpty()) {
					JSONArray localJSONArray = (JSONArray) localObject1;
					Iterator<?> localIterator2 = localJSONArray.iterator();
					while (localIterator2.hasNext()) {
						Object localObject2 = localIterator2.next();
						DA833A2AC4A7DCB2A62E5E5BC48CB993(localObject2);
					}
				}
			} else if ((localObject1 instanceof JSONNull)) {
				localJSONObject1.put(str, null);
			}
		}
		localJSONObject2 = null;
	}
}
