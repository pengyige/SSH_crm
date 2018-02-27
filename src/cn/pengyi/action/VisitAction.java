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
	
	//ģ��������װ����
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

	

	//1������ҳ��
	public String toAddPage() {
		
		//��ѯ���пͻ�
		 List<Customer> listCustomer = customerService.findAll();
		
		//��ѯ�����û�
		List<User> listUser = userService.findAll();
		 
		//ҳ����ת
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		ServletActionContext.getRequest().setAttribute("listUser", listUser);
		return "toAddPage";
	}


	
	
	//2��������
	public String addVisit() {
		
		this.visitService.addVisit(visit);
		return "addVisitSuccess";
	}
	
	
	//3�ݷ��б�
	public String list() {
		//��ȡvisitList
		List<Visit> visitList = visitService.findAll();
		
		//ҳ����ת
		ServletActionContext.getRequest().setAttribute("visitList", visitList);
		return "list";
	}
}
