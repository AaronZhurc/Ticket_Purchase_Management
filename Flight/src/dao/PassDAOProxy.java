package dao;

import dbc.DatabaseConn;
import dbc.DBConnFactory;
import vo.Passenger;

public class PassDAOProxy implements IPassDAO{
	private DatabaseConn dbConn=null;
	private IPassDAO dao=null;
	public PassDAOProxy()throws Exception {
		dbConn=DBConnFactory.getDataBaseConnection();
		this.dao=new PassDAOImpl(dbConn.getConnection());
	}
	@Override
	public boolean doRegis(Passenger pass)throws Exception{
		boolean flag=false;
		try {
			flag=this.dao.doRegis(pass);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return flag;
	}
	@Override
	public boolean findLogin(String acc,String pw)throws Exception{
		boolean flag=false;
		try {
			flag=this.dao.findLogin(acc, pw);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return flag;
	}
	@Override
	public Passenger findInfo(String acc)throws Exception{
		Passenger pass=null;
		try {
			pass=this.dao.findInfo(acc);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return pass;
	}
	@Override
	public boolean doMod(Passenger pass)throws Exception{
		boolean flag=false;
		try {
			flag=this.dao.doMod(pass);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return flag;
	}
	@Override
	public boolean doDel(Passenger pass)throws Exception{
		boolean flag=false;
		try {
			flag=this.dao.doDel(pass);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return flag;
	}
	@Override
	public boolean findUser(Passenger pass)throws Exception{
		boolean flag=false;
		try {
			flag=this.dao.findUser(pass);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return flag;
	}
}
