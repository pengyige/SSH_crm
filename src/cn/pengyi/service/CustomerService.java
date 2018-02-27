package cn.pengyi.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pengyi.dao.CustomerDao;
import cn.pengyi.entity.Customer;
import cn.pengyi.entity.PageBean;

@Transactional
public class CustomerService {
	
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void add(Customer customer) {
		
		customerDao.add(customer);
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	public Customer findOne(int cid) {
		// TODO Auto-generated method stub
		return customerDao.findOne(cid);
	}

	public void delete(Customer c) {
		// TODO Auto-generated method stub
		customerDao.delete(c);
	}

	public void update(Customer customer) {
	
		customerDao.update(customer);
	}

	public PageBean listpage(int currentPage) {
		PageBean pageBean = new PageBean();
		
		
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//总记录数
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		
		//算出总页数
		if(totalCount%pageSize == 0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//判断是否超出页面范围
		if(currentPage <= 0){
			currentPage = 1;
		}
		
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		pageBean.setCurrentPage(currentPage);
		
		//算出开始页数
		int begin = (currentPage-1) * pageSize;
		List<Customer> list = customerDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public List<Customer> findCondition(Customer customer) {
		
		return customerDao.findCondition(customer);
	}

	public List<Customer> findMoreCondition(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.findMoreCondition(customer);
	}
	
	
}
