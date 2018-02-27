package cn.pengyi.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.pengyi.entity.Customer;
import cn.pengyi.entity.User;
import cn.pengyi.entity.Visit;
import cn.pengyi.service.CustomerService;
import cn.pengyi.service.UserService;
import cn.pengyi.service.VisitService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	
	//模型驱动封装数据
	private Visit visit = new Visit();
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}
	
	private VisitService visitService;
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	

	//1到新增页面
	public String toAddPage() {
		
		//查询所有客户
		 List<Customer> listCustomer = customerService.findAll();
		
		//查询所有用户
		List<User> listUser = userService.findAll();
		 
		//页面跳转
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		ServletActionContext.getRequest().setAttribute("listUser", listUser);
		return "toAddPage";
	}


	
	
	//2新增方法
	public String addVisit() {
		
		this.visitService.addVisit(visit);
		return "addVisitSuccess";
	}
	
	
	//3拜访列表
	public String list() {
		//获取visitList
		List<Visit> visitList = visitService.findAll();
		
		//页面跳转
		ServletActionContext.getRequest().setAttribute("visitList", visitList);
		return "list";
	}
}
