package cn.pengyi.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.pengyi.entity.Customer;
import cn.pengyi.entity.PageBean;
import cn.pengyi.service.CustomerService;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	//���ͻ��б���Ϣ��װ��ֵջ
	private List list;
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	
	
	
	//���Է�װ�õ���ǰҳ
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	//ģ�ͷ�װ
	private Customer customer = new Customer();
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	
	//1ת�������ҳ��.jsp
	public String toAddPage() {
		return "toAddPage";
	}
	
	//2��ӿͻ�
	public String add() {
		customerService.add(customer);
		return "addsuccess";
	}
	
	//3��ʾ���пͻ�
	public String list() {
		List<Customer> list = customerService.findAll();
		//����request������У�ʹ��el���ʽȡ
/*		ServletActionContext.getRequest().setAttribute("list", list);*/
		//����ֵջ�����У�ʹ��el���ʽҲ��ȥ�������ܵ��£����ڶ�getAttrbutes��������ǿ��,ʹ��struts2
		//��ǩȥȡ
		this.list = list;
		return "list";
	}
	
	//4ɾ���ͻ�
	public String delete(){
		//ʹ��ģ��������װcidֵ
		int cid = customer.getCid();
		
		Customer c = customerService.findOne(cid);
		if(c != null){
			customerService.delete(c);
		}
		
		return "deletesuccess";
	}
	
	
	//5��ʾ��Ҫ�޸Ŀͻ���Ϣ
	public String showCustomer() {
		//ʹ��ģ��������װcidֵ
		int cid = customer.getCid();
		Customer c = customerService.findOne(cid);
		ServletActionContext.getRequest().setAttribute("customer", c);
		return "showCustomer";
	}

	
	//6�޸Ŀͻ�
	public String update() {
		customerService.update(customer);
		return "updatesuccess";
	}
	
	
	//7��ҳ��ʾ�ͻ�
	public String listpage() {
		PageBean pageBean = customerService.listpage(this.currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listpage";
	}
	
	
	//8������ѯ
	public String listcondition() {
		//��List����ֵջ������
		if(customer.getCustName() != null && !"".equals(customer.getCustName())) {
			list = customerService.findCondition(customer);
			
		} else {
			//�����룬��ʾ���пͻ�
			list = customerService.findAll();
		}
		
		this.list = list;
		return "listcondition";
	}
	
	//9����ѯҳ��
	public String toMoreCondition() {
		return "toMoreCondition";
	}
	
	
	//10��������ѯ
	public String moreCondition() {
		List<Customer> list = customerService.findMoreCondition(customer);
		this.list = list;
		return "list";
	}
	
	
	
	//11�������пͻ�json����
	public String cutomerJSON() throws IOException {
		
	/*	Customer customer = new Customer();
		customer.setCid(1);
		customer.setCustName("���");
		List<Customer> list = new ArrayList();
		list.add(customer);
		list.add(customer);
		list.add(customer);*/
		List<Customer> list = customerService.findAll();
		
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		
		String json = JSON.toJSONString(list);
		response.getWriter().write(json);
		
		return NONE;
	}
	@Override
	public Customer getModel() {
		
		return customer;
	}
}
