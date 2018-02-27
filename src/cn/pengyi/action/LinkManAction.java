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
	
	//ģ��������װ����
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}
	
	
	//�ļ��ϴ�����
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

	//1����ϵ��ҳ��
	public String toAddPage() {
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	
	
	//2�����ϵ��
	public String addLinkMan()  {
		
		//��ȡ�����ͻ�cid
		//1ԭʼ��ʽ
	/*	String scid = ServletActionContext.getRequest().getParameter("cid");
		int cid = Integer.parseInt(scid);
		
		Customer c = new Customer();
		c.setCid(cid);
		
		linkMan.setCustomer(c);*/
		
		//2����ʹ�����Է�װ. customer.cid
		if(upload != null){
			//�����ļ�
			File serverFile = new File("E:\\ssh\\"+uploadFileName);
			//�����ļ�
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
	
	
	//3��ϵ���б�
	public String list() {
		List<LinkMan> list = linkManService.listLinkMan();
		ServletActionContext.getRequest().setAttribute("listLinkMan", list);
		return "listLinkMan";
	}
	
	//4�޸���ϵ��ҳ��
	public String showLinkMan() {
		//linkman����
		int linkid = linkMan.getLinkid();
		LinkMan link = linkManService.findOne(linkid);
		
		//���пͻ�
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("link", link);
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "showLinkMan";
	}
	
	
	//5�޸���ϵ��
	public String updateLinkMan() {
		linkManService.updateLinkMan(linkMan);
		return "updateLinkMan";
	}

	
	
	
}
