package cn.pengyi.dao;

import java.util.List;

import cn.pengyi.entity.User;

public interface UserDao {

	User loginUser(User user);

	List<User> findAll();
	
}
