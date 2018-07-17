package com.linewell.fabric.console.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linewell.common.BaseController;
import com.linewell.common.http.ResponseResult;
import com.linewell.fabric.console.bean.Test;
import com.linewell.fabric.console.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("web/test")
@Api(value = "测试", description = "测试用")
public class TestController extends BaseController {
	
	@Autowired
	private TestService testService;

	@GetMapping("get")
	@ApiOperation(value = "test GET")
	public ResponseResult<Object> get(String id, HttpServletRequest request) {
		logger.info("test GET");
		ResponseResult<Object> result = new ResponseResult<Object>();
		result.setData(testService.get(id));
		return result;
	}

	@PostMapping("post")
	@ApiOperation(value = "test POST")
	public ResponseResult<Object> post(@RequestBody Test a, HttpServletRequest request) {
		logger.info("test POST");
		ResponseResult<Object> result = new ResponseResult<Object>();
		testService.save(a);
		result.setData(a);
		return result;
	}

}

