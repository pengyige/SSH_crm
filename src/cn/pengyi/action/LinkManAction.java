package cn.pengyi.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.pengyi.entity.Customer;
import cn.pengyi.entity.LinkMan;
import cn.pengyi.service.CustomerService;
import cn.pengyi.service.LinkManService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	
	//模型驱动封装数据
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}
	
	
	//文件上传对象
	private File upload;
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	//1到联系人页面
	public String toAddPage() {
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	
	
	//2添加联系人
	public String addLinkMan()  {
		
		//获取所属客户cid
		//1原始方式
	/*	String scid = ServletActionContext.getRequest().getParameter("cid");
		int cid = Integer.parseInt(scid);
		
		Customer c = new Customer();
		c.setCid(cid);
		
		linkMan.setCustomer(c);*/
		
		//2还是使用属性封装. customer.cid
		if(upload != null){
			//创建文件
			File serverFile = new File("E:\\ssh\\"+uploadFileName);
			//复制文件
			try {
				FileUtils.copyFile(upload, serverFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		linkManService.addLinkMan(linkMan);
		return "addLinkManSuccess";
	}
	
	
	//3联系人列表
	public String list() {
		List<LinkMan> list = linkManService.listLinkMan();
		ServletActionContext.getRequest().setAttribute("listLinkMan", list);
		return "listLinkMan";
	}
	
	//4修改联系人页面
	public String showLinkMan() {
		//linkman对象
		int linkid = linkMan.getLinkid();
		LinkMan link = linkManService.findOne(linkid);
		
		//所有客户
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("link", link);
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "showLinkMan";
	}
	
	
	//5修改联系人
	public String updateLinkMan() {
		linkManService.updateLinkMan(linkMan);
		return "updateLinkMan";
	}

	
	
	
}
