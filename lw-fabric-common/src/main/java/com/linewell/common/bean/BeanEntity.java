package com.linewell.common.bean;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.NotSaved;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public class BeanEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String UNIT_FIELD_NAME = "unitUnid";
	public static final String FK_SEARCH_NAME_FIELD = "_id";
	public static final String FK_BEAN_NAME_FIELD = "unid";
	@Id
	private String unid;
	@Indexed
	private String unitUnid;
	private String creator;
	private long createTime;
	private String modifier;
	private long modifyTime;
	private boolean deleteFlag;
	@NotSaved
	private BeanFlag beanFlag;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getUnitUnid() {
		return unitUnid;
	}

	public void setUnitUnid(String unitUnid) {
		this.unitUnid = unitUnid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public BeanFlag getBeanFlag() {
		return beanFlag;
	}

	public void setBeanFlag(BeanFlag beanFlag) {
		this.beanFlag = beanFlag;
	}

}
