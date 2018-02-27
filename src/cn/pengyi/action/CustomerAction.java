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
	//将客户列表信息封装进值栈
	private List list;
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	
	
	
	//属性封装得到当前页
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	//模型封装
	private Customer customer = new Customer();
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	
	//1转发到添加页面.jsp
	public String toAddPage() {
		return "toAddPage";
	}
	
	//2添加客户
	public String add() {
		customerService.add(customer);
		return "addsuccess";
	}
	
	//3显示所有客户
	public String list() {
		List<Customer> list = customerService.findAll();
		//放入request域对象中，使用el表达式取
/*		ServletActionContext.getRequest().setAttribute("list", list);*/
		//放入值栈对象中，使用el表达式也能去，但性能地下（由于对getAttrbutes进行了增强）,使用struts2
		//标签去取
		this.list = list;
		return "list";
	}
	
	//4删除客户
	public String delete(){
		//使用模型驱动封装cid值
		int cid = customer.getCid();
		
		Customer c = customerService.findOne(cid);
		if(c != null){
			customerService.delete(c);
		}
		
		return "deletesuccess";
	}
	
	
	//5显示需要修改客户信息
	public String showCustomer() {
		//使用模型驱动封装cid值
		int cid = customer.getCid();
		Customer c = customerService.findOne(cid);
		ServletActionContext.getRequest().setAttribute("customer", c);
		return "showCustomer";
	}

	
	//6修改客户
	public String update() {
		customerService.update(customer);
		return "updatesuccess";
	}
	
	
	//7分页显示客户
	public String listpage() {
		PageBean pageBean = customerService.listpage(this.currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listpage";
	}
	
	
	//8条件查询
	public String listcondition() {
		//将List放入值栈对象中
		if(customer.getCustName() != null && !"".equals(customer.getCustName())) {
			list = customerService.findCondition(customer);
			
		} else {
			//不输入，显示所有客户
			list = customerService.findAll();
		}
		
		this.list = list;
		return "listcondition";
	}
	
	//9到查询页面
	public String toMoreCondition() {
		return "toMoreCondition";
	}
	
	
	//10多条件查询
	public String moreCondition() {
		List<Customer> list = customerService.findMoreCondition(customer);
		this.list = list;
		return "list";
	}
	
	
	
	//11返回所有客户json数据
	public String cutomerJSON() throws IOException {
		
	/*	Customer customer = new Customer();
		customer.setCid(1);
		customer.setCustName("彭旖");
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
