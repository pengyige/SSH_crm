package cn.pengyi.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.pengyi.entity.User;
import cn.pengyi.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//属性封装
	private String username;
	private String password;
	
	

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



	public String login(){
		//1.获取数据
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//2.业务逻辑
		User userExist = userService.login(user);
		HttpServletRequest request = ServletActionContext.getRequest();
		if(userExist != null){
			
			request.getSession().setAttribute("user", userExist);
			return "loginsuccess";
		}else{
			request.setAttribute("error", "用户名或密码不正确");
			return "loginfail";
		}
		
		
	}
}
