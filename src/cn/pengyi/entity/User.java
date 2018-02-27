package cn.pengyi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.transaction.annotation.Transactional;


public class User {
	

	private int id;
	private String username;
	private String password;
	private String address;
	
	//一个用户对应多个拜访记录 ，这是多的一方
	private Set<Visit> setUserVisit = new HashSet<Visit>();
	public Set<Visit> getSetUserVisit() {
		return setUserVisit;
	}
	public void setSetUserVisit(Set<Visit> setUserVisit) {
		this.setUserVisit = setUserVisit;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
