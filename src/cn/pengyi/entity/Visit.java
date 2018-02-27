package cn.pengyi.entity;


//将多对多拆分成两个一对多，相当于中间表
public class Visit {
	
	private int vid;
	private String vaddress;
	private String vcontent;
	
	private Customer customer;
	private User user;
	
	
	/*//仅仅用于获取表单提交的数据
	private int uvid;
	private int cvid;
	public int getUvid() {
		return uvid;
	}
	public void setUvid(int uvid) {
		this.uvid = uvid;
	}
	public int getCvid() {
		return cvid;
	}
	
	
	public void setCvid(int cvid) {
		this.cvid = cvid;
	}
	*/
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVaddress() {
		return vaddress;
	}
	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}
	public String getVcontent() {
		return vcontent;
	}
	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}
	
}
