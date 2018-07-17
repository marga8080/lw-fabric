package com.linewell.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linewell.common.http.ResponseResult;

/**
 * 控制器基类
 * @author mawei@linewell.com
 * @since 2018年6月6日
 */
public abstract class BaseController {
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	
	/**    
     * 统一异常处理    
     * @return json格式
     */      
    @ExceptionHandler(Exception.class)  
    @ResponseBody
    public ResponseResult<Object> exceptionHandler(Exception e) {       
    	ResponseResult<Object> result = new ResponseResult<Object>();
    	logger.error("捕获异常", e);
    	result.setErrcode(ResponseResult.DEFAULT_ERROR);
    	result.setErrmsg(e.getMessage());
    	return result;
    } 
}
