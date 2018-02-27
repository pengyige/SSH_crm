package cn.pengyi.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pengyi.dao.UserDao;
import cn.pengyi.entity.User;

@Transactional
public class UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		
		
		return userDao.loginUser(user);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	
	
}
