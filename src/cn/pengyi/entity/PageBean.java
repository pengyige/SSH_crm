package cn.pengyi.entity;

import java.util.List;

public class PageBean {
	
	//��ǰҳ
	private int currentPage;
	
	//�ܼ�¼��
	private int totalCount;
	
	//ÿҳ��ʾ��
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

	//��ҳ��(��totalCount��pageSize����)
	private int totalPage;
	
	//��ʼλ��(�ɵ�ǰҳ������pageSize����)
	private int begin;
	
	//ÿҳ����
	private List<Customer> list;
}
