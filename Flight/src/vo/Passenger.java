package vo;

public class Passenger {
	private String IDnum;//֤������
	private String IDtype;//֤������
	private String UserName;//�û�����
	private String Sex;//�û��Ա�
	private String Contact;//��ϵ��ʽ
	private String UserAccount;//�û��˻�
	private String UserPassword;//�û�����
	private int TicketHold;//��Ʊ������
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
