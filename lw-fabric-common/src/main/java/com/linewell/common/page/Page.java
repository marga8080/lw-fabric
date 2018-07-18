package com.linewell.common.page;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private long total; // 总记录数
	private List<T> list; // 结果集
	private int pageNo; // 第几页
	private int pageSize; // 每页记录数
	private int pages; // 总页数
	//private int size; // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性
	
	@JsonIgnore
	private boolean countTotal = true; //是否需要计算总数， 默认需要

	/**
	 * 总记录数
	 * @return
	 */
	public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 结果集
     * @return
     */
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * 第几页
     * @return
     */
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 每页记录数
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 总页数
     * @return
     */
    public int getPages() {
    	pages = (int) Math.ceil(total / pageSize);
        return pages;
    }

    /**
     * 当前页的数量 <= pageSize，该属性来自ArrayList的size属性
     * @return
     */
    public int getSize() {
        return list.size();
    }

	public boolean isFirstPage() {
		return pageNo == 1;
	}

	public boolean isLastPage() {
		return pageNo == pages || pages == 0;
	}

	public boolean isCountTotal() {
		return countTotal;
	}

	public void setCountTotal(boolean countTotal) {
		this.countTotal = countTotal;
	}

}
