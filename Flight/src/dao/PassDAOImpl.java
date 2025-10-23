package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Passenger;

public class PassDAOImpl implements IPassDAO{
	private Connection conn=null;
	private PreparedStatement stmt=null;
	public PassDAOImpl(Connection _conn) {
		this.conn=_conn;
	}
	@Override
	public boolean doRegis(Passenger pass)throws Exception{
		boolean flag=false;
		String sql="insert into passenger(idnum,idtype,username,sex,contact,useraccount,userpassword,tickethold) values (?,?,?,?,?,?,?,?)";
		this.stmt=this.conn.prepareStatement(sql); 
		this.stmt.setString(1, pass.getIDnum());
		this.stmt.setString(2, pass.getIDtype());
		this.stmt.setString(3, pass.getUserName());
		this.stmt.setString(4, pass.getSex());
		this.stmt.setString(5, pass.getContact());
		this.stmt.setString(6, pass.getUserAccount());
		this.stmt.setString(7, pass.getUserPassword());
		this.stmt.setInt(8, pass.getTicketHold());
		if(this.stmt.executeUpdate()>0) {
			flag=true;
		}
		this.stmt.close();
		return flag;
	}
	@Override
	public boolean findLogin(String acc,String pw)throws Exception{
		boolean flag=false;
		String sql="select userpassword from passenger where useraccount=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, acc);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			if(rs.getString("userpassword").equals(pw)) {
				flag=true;
			}
		}
		rs.close();
		this.stmt.close();
		return flag;
	}
	@Override
	public Passenger findInfo(String acc)throws Exception{
		Passenger pass=null;
		String sql="select * from passenger where useraccount=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, acc);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			pass=new Passenger();
			pass.setIDnum(rs.getString("IDNum"));
			pass.setIDtype(rs.getString("IDType"));
			pass.setUserName(rs.getString("UserName"));
			pass.setSex(rs.getString("Sex"));
			pass.setContact(rs.getString("Contact"));
			pass.setUserAccount(rs.getString("UserAccount"));
			pass.setUserPassword(rs.getString("UserPassword"));
			pass.setTicketHold(rs.getInt("TicketHold"));
		}
		return pass;
	}
	@Override
	public boolean doMod(Passenger pass)throws Exception {
		boolean flag=false;
		String sql="update passenger set UserName=? , Sex=? , Contact=? , UserPassword=? where idnum=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, pass.getUserName());
		this.stmt.setString(2, pass.getSex());
		this.stmt.setString(3, pass.getContact());
		this.stmt.setString(4, pass.getUserPassword());
		this.stmt.setString(5, pass.getIDnum());
		if(this.stmt.executeUpdate()!=0) {
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean doDel(Passenger pass)throws Exception{
		boolean flag=false;
		String sql="delete from passenger where idnum=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, pass.getIDnum());
		if(this.stmt.executeUpdate()!=0) {
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean findUser(Passenger pass)throws Exception{
		boolean flag=false;
		String sql="select * from passenger where idnum=? and IDType=? or UserAccount=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, pass.getIDnum());
		this.stmt.setString(2, pass.getIDtype());
		this.stmt.setString(3, pass.getUserAccount());
		ResultSet rs=this.stmt.executeQuery();
		if(!rs.next()) {
			flag=true;
		}
		return flag;
	}
}
