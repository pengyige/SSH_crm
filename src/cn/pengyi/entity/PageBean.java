package cn.pengyi.entity;

import java.util.List;

public class PageBean {
	
	//当前页
	private int currentPage;
	
	//总记录数
	private int totalCount;
	
	//每页显示数
	private int pageSize;
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	//总页数(由totalCount和pageSize决定)
	private int totalPage;
	
	//开始位置(由当前页决定和pageSize决定)
	private int begin;
	
	//每页数据
	private List<Customer> list;
}
