package cn.pengyi.entity;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Customer {
	
	private int cid;
	private String custName;
	private String custLevel;
	private String custSource;
	private String custPhone;
	private String custMobile;
	
	//一对多 ,一个客户对应多个联系人
	@JSONField(serialize=false)
	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
	
	
	//一个客户对应多个拜访记录，这是一方
	@JSONField(serialize=false)
	private Set<Visit> setCustomerVisit = new HashSet<Visit>();
	public Set<Visit> getSetCustomerVisit() {
		return setCustomerVisit;
	}
	public void setSetCustomerVisit(Set<Visit> setCustomerVisit) {
		this.setCustomerVisit = setCustomerVisit;
	}
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	
	
	
}
