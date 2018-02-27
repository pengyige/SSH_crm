package cn.pengyi.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.pengyi.entity.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	@Override
	public void add(LinkMan linkMan) {
		
		this.getHibernateTemplate().save(linkMan);
		
	}

	@Override
	public List<LinkMan> list() {
		
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

	@Override
	public LinkMan findOne(int linkid) {
		
		return this.getHibernateTemplate().get(LinkMan.class,linkid);
	}

	@Override
	public void updateLinkMan(LinkMan linkMan) {
		
		this.getHibernateTemplate().update(linkMan);
		
	}
	
}
