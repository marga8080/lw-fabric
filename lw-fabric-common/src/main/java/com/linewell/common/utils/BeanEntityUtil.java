package com.linewell.common.utils;

import com.linewell.common.bean.BeanEntityAct;

public class BeanEntityUtil extends BeanEntityAct {
	private String userUnid;

	public void setUserUnid(String paramString) {
		this.userUnid = paramString;
	}

	public String getCurrentUserName() {
		return this.userUnid;
	}
}
