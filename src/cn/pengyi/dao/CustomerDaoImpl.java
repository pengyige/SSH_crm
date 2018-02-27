package cn.pengyi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.pengyi.entity.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	/*@Override
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

	@Override
	public Customer findOne(int cid) {
		
		return this.getHibernateTemplate().get(Customer.class, cid);
	}

	@Override
	public void delete(Customer c) {
		
		this.getHibernateTemplate().delete(c);
		
	}

	@Override
	public void update(Customer customer) {
		
		this.getHibernateTemplate().update(customer);
		
	}
*/
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		List<Long> list =  (List<Long>) this.getHibernateTemplate().find("select count(*) from Customer");
		int count = list.get(0).intValue();
		return count;
	}

	@Override
	public List<Customer> findPage(int begin, int pageSize) {
		//第一种 hibernate底层代码实现
		/*SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		
		List<Customer> list = query.list();*/
		
		
		//第二种 使用离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public List<Customer> findCondition(Customer customer) {
		//使用原始底层
	/*	SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer where custName=?");
		query.setParameter(0, "%"+customer.getCustName()+"%");
		List<Customer> list = query.list();*/
		
		//使用模板方法
/*		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where custName like ?", "%"+customer.getCustName()+"%");*/
		
		//使用离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.like("custName","%"+customer.getCustName()+"%"));
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	@Override
	public List<Customer> findMoreCondition(Customer customer) {
		//拼接hql语句
	/*	String hql = "from Customer where 1=1";
		List<Object> p = new ArrayList<Object>();
		if(customer.getCustName() != null && !"".equals(customer.getCustName())){
			
			hql += " and custName=? ";
			p.add(customer.getCustName());
		}
		
		if(customer.getCustLevel() != null && !"".equals(customer.getCustLevel())){
			
			hql += " and custLevel=? ";
			p.add(customer.getCustLevel());
		}
		
		if(customer.getCustSource() != null && !"".equals(customer.getCustSource()))	{
		
			hql += " and custSource=? ";
			p.add(customer.getCustSource());
		}
		
		return (List<Customer>) this.getHibernateTemplate().find(hql, p.toArray());*/
		
		//使用离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if(customer.getCustName() != null && !"".equals(customer.getCustName())){
			criteria.add(Restrictions.eq("custName", customer.getCustName()));
			
		}
		
		if(customer.getCustLevel() != null && !"".equals(customer.getCustLevel())){
			criteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
		}
		
		if(customer.getCustSource() != null && !"".equals(customer.getCustSource())){
			criteria.add(Restrictions.eq("custSource", customer.getCustSource()));
		}
		
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	
}
