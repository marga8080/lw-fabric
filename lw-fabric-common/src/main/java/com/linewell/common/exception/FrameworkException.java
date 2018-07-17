package com.linewell.common.exception;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public class FrameworkException extends Exception {
	private static final long serialVersionUID = 9197264379214608529L;
	private ExceptionType type;
	private String[] params;
	private String code;

	public FrameworkException(ExceptionType paramExceptionType, String paramString, String... paramVarArgs) {
		super("Exception Code:" + paramString);
		this.params = paramVarArgs;
		this.type = paramExceptionType;
		this.code = paramString;
	}

	public FrameworkException(ExceptionType paramExceptionType, Throwable paramThrowable, String paramString,
			String... paramVarArgs) {
		super("Exception Code:" + paramString, paramThrowable);
		this.params = paramVarArgs;
		this.type = paramExceptionType;
		this.code = paramString;
	}

	public String getCode() {
		return this.code;
	}

	public String[] getParams() {
		return this.params;
	}

	public ExceptionType getType() {
		return this.type;
	}
}
