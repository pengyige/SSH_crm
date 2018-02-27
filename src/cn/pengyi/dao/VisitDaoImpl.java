package cn.pengyi.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.pengyi.entity.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	@Override
	public void add(Visit visit) {
		
		this.getHibernateTemplate().save(visit);
	}

	@Override
	public List<Visit> findAll() {
	
		return (List<Visit>) this.getHibernateTemplate().find("from Visit");
	}

}
