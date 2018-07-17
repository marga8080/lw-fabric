package com.linewell.common.bean;

import org.apache.commons.lang3.StringUtils;

import com.linewell.common.DateTimeManager;
import com.linewell.common.factory.DateTimeFactory;
import com.linewell.common.utils.BeanUtil;
import com.linewell.common.utils.CDC04FE60F6132D9E9E3703BF57F5DEC;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public abstract class BeanEntityAct {
	public static final String BEANFLAG = "beanFlag";
	public static final String UNID = "unid";
	public static final String CREATOR = "creator";
	public static final String CREATETIME = "createTime";
	public static final String MODEFIER = "modifier";
	public static final String MODIFYTIME = "modifyTime";

	public void setCommonValue(Object paramObject) {
		String str = BeanUtil.getValue(paramObject, "unid");
		if (StringUtils.isEmpty(str)) {
			BeanUtil.setValue(paramObject, "unid", CDC04FE60F6132D9E9E3703BF57F5DEC.getUnid());
		}
		DateTimeManager localDateTimeManager = DateTimeFactory.getInstance();
		str = BeanUtil.getValue(paramObject, "createTime");
		if ((StringUtils.isEmpty(str)) || (Long.parseLong(str) == 0L)) {
			BeanUtil.setValue(paramObject, "createTime", Long.valueOf(localDateTimeManager.getLongTime()));
		}
		str = BeanUtil.getValue(paramObject, "creator");
		if (StringUtils.isEmpty(str)) {
			BeanUtil.setValue(paramObject, "creator", getCurrentUserName());
		}
		str = BeanUtil.getValue(paramObject, "modifyTime");
		BeanUtil.setValue(paramObject, "modifyTime", Long.valueOf(localDateTimeManager.getLongTime()));
		str = BeanUtil.getValue(paramObject, "modifier");
		BeanUtil.setValue(paramObject, "modifier", getCurrentUserName());
		BeanUtil.setSpellFieldValue(paramObject);
	}

	public String getCurrentUserName() {
		return "ccip-admin";
	}
}
