package cn.pengyi.dao;

import java.util.List;

import cn.pengyi.entity.Customer;

public interface CustomerDao extends BaseDao<Customer>{

	int findCount();

	List<Customer> findPage(int begin, int pageSize);

	List<Customer> findCondition(Customer customer);

	List<Customer> findMoreCondition(Customer customer);

}
