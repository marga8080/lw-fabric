package com.linewell.common.http;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 请求服务器返回的结果对象
 * @author mawei
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {

	private static final long serialVersionUID = 5904767038637432979L;
	
	public static final String DEFAULT_ERROR = "-1"; 
	public static final String SUCCESS = "0"; // 返回0 时表示正确

	private String errcode = SUCCESS;
	private String errmsg; // 描述
	private T data;
	
	public void setResult(String errcode, String errmsg) {
		this.setErrcode(errcode);
		this.setErrmsg(errmsg);
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	
}