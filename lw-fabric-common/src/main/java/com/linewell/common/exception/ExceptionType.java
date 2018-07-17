package com.linewell.common.exception;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public enum ExceptionType {
	
	ERROR(1),
	TIP(2);
	
	private int type;

	private ExceptionType(int paramInt1) {
		this.type = paramInt1;
	}

	public int getType() {
		return this.type;
	}
}
