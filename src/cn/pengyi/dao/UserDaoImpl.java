package cn.pengyi.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.pengyi.entity.User;

//直接继承HibernateDaoSupport，内部维护了一个hibernateTemplate
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


	@Override
	public User loginUser(User user) {
		List<User> userList = (List<User>) this.getHibernateTemplate().find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		if(userList.size() != 0 ) {
			return userList.get(0);
		}
		return null;
	}
	
	
	@Override
	public List<User> findAll() {
		
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
	


	
}
