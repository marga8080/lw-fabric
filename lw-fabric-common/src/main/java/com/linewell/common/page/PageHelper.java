package com.linewell.common.page;

import java.util.List;

import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;

public class PageHelper {

	/**
	 * 返回查询结果
	 * @param page
	 * @param query
	 * @return
	 */
	public static <T> Page<T> pageResult(Page<T> page, Query<T> query) {
		if (page.isCountTotal()) {
			// 查询总数
			long count = query.count();
			page.setTotal(count);
		}

		FindOptions options = new FindOptions();
		options.limit(page.getPageSize());
		options.skip((page.getPageNo() - 1) * page.getPageSize());
		List<T> list = query.asList(options);
		page.setList(list);
		return page;
	}
	
	/**
	 * 
	 * 设置page参数
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public static <T> Page<T> startPage(int pageNo, int pageSize) {
		return startPage(pageNo, pageSize, true);
	}
	
	/**
	 * 
	 * 设置page参数
	 * @param pageNum
	 * @param pageSize
	 * @param countTotal 是否需要计算总数
	 * @return
	 */
	public static <T> Page<T> startPage(int pageNo, int pageSize, boolean countTotal) {
		Page<T> page = new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setCountTotal(countTotal);;
		return page;
	}
}
