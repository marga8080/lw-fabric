package com.linewell.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
    
    /**
	 * 获取页码
	 * @param request
	 * @return
	 */
	public static int getPageNo(HttpServletRequest request) {
		String no = request.getParameter("pageNo");
		int pageNo = 1;
		if (StringUtils.isNumeric(no)){
			pageNo = Integer.parseInt(no);
		}
		return pageNo;
	}
	
	/**
	 * 获取每页记录数pageSize
	 * @param request
	 * @param defaultPageSize 默认pageSize
	 * @return
	 */
	public static int getPageSize(HttpServletRequest request, int defaultPageSize) {
		String size = request.getParameter("pageSize");
		int pageSize = defaultPageSize;
		if (StringUtils.isNumeric(size)){
			pageSize = Integer.parseInt(size);
		} 
		return pageSize;
	}
	
	/**
	 * 获取每页记录数pageSize
	 * @param request
	 * @param defaultPageSize 默认10
	 * @return
	 */
	public static int getPageSize(HttpServletRequest request) {
		return getPageSize(request, 10);
	}
}
