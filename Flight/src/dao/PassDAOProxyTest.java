package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vo.Passenger;

public class PassDAOProxyTest {
	PassDAOProxy passDAOProxy=null;
	Passenger pass=null;
	@Before
	public void SetUp()throws Exception {
		passDAOProxy=new PassDAOProxy();
		pass=new Passenger();
		pass.setUserName("koto");
		pass.setUserAccount("hotmail");
		pass.setUserPassword("password");
		pass.setSex("female");
		pass.setContact("02512345678");
		pass.setIDnum("se1234567");
		pass.setIDtype("passport");
		pass.setTicketHold(1);
	}
	@After
	public void TearDown()throws Exception{
		
	}
	//@Test
	public void doRegis()throws Exception{
		if(passDAOProxy.doRegis(pass)==true) {
			System.out.println("�ɹ����һ����¼");
		} else {
			System.out.println("���ʧ��");
		}
	}
	//@Test
	public void findLogin()throws Exception{
		if(passDAOProxy.findLogin(pass.getUserAccount(), pass.getUserPassword())==true) {
			System.out.println("��½�ɹ�");
		} else {
			System.out.println("��½ʧ��");
		}
	}
	//@Test
	public void findInfo()throws Exception{
		if(passDAOProxy.findInfo("hotmail").getUserName().equals("koto")) {
			System.out.println("�ɹ�");
		} else {
			System.out.println("ʧ��");
		}
	}
	//@Test
	public void doMod()throws Exception{
		pass.setContact("02112345678");
		if(passDAOProxy.doMod(pass)==true) {
			System.out.println("�ɹ�");
		} else {
			System.out.println("ʧ��");
		}
	}
	//@Test
	public void doDel()throws Exception{
		if(passDAOProxy.doDel(pass)==true) {
			System.out.println("�ɹ�");
		} else {
			System.out.println("ʧ��");
		}
	}
	@Test
	public void findUser()throws Exception{
		pass.setUserAccount("1234");
		pass.setIDtype("id");
		if(passDAOProxy.findUser(pass)==true) {
			System.out.println("���û�");
		} else {
			System.out.println("�Ѵ���");
		}
	}
}
