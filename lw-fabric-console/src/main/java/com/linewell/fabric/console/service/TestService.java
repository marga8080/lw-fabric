package com.linewell.fabric.console.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linewell.fabric.console.bean.Test;
import com.linewell.fabric.console.dao.TestDao;

@Service
public class TestService {
	
	@Autowired
	TestDao testDao;
	
	/**
	 * 经测试mongodb 事务不能回滚
	 * @param test
	 * @return
	 */
//	@Transactional(readOnly=false, rollbackFor=Throwable.class)
	public boolean save(Test test) {
		boolean bol = testDao.save(test);
//		System.out.println(bol);
//		int a = 1 / 0 ; // 抛异常测试是否回滚
		return bol;
	}

	
	public Test get(String unid) {
    	return testDao.get(unid);
    }
}
