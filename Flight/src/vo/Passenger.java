package vo;

public class Passenger {
	private String IDnum;//证件号码
	private String IDtype;//证件类型
	private String UserName;//用户姓名
	private String Sex;//用户性别
	private String Contact;//联系方式
	private String UserAccount;//用户账户
	private String UserPassword;//用户密码
	private int TicketHold;//机票持有数
	public void setIDnum(String IDnum) {
		this.IDnum=IDnum;
	}
	public String getIDnum() {
		return this.IDnum;
	}
	public void setIDtype(String IDtype) {
		this.IDtype=IDtype;
	}
	public String getIDtype() {
		return this.IDtype;
	}
	public void setUserName(String UserName) {
		this.UserName=UserName;
	}
	public String getUserName() {
		return this.UserName;
	}
	public void setSex(String Sex) {
		this.Sex=Sex;
	}
	public String getSex() {
		return this.Sex;
	}
	public void setContact(String Contact) {
		this.Contact=Contact;
	}
	public String getContact() {
		return this.Contact;
	}
	public void setUserAccount(String UserAccount) {
		this.UserAccount=UserAccount;
	}
	public String getUserAccount() {
		return this.UserAccount;
	}
	public void setUserPassword(String UserPassword) {
		this.UserPassword=UserPassword;
	}
	public String getUserPassword() {
		return this.UserPassword;
	}
	public void setTicketHold(int TicketHold) {
		this.TicketHold=TicketHold;
	}
	public int getTicketHold() {
		return this.TicketHold;
	}
	public void refund() {
		this.TicketHold--;
	}
	public void Buy() {
		this.TicketHold++;
	}
}
