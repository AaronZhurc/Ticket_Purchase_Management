package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import vo.Ticket;

public class TicketDAOImpl implements ITicketDAO{
	private Connection conn=null;
	private PreparedStatement stmt=null;
	public TicketDAOImpl(Connection _conn) {
		this.conn=_conn;
	}
	@Override
	public boolean doBuy(String IDNum,String FlightNum,String SeatLocat)throws Exception{
		boolean flag=false;
		String TicketNum=IDNum+FlightNum+SeatLocat;
		String SeatNum=FlightNum+SeatLocat;
		String sql="insert into ticket(ticketnum,idnum,seatnum,flightnum) values (?,?,?,?)";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, TicketNum);
		this.stmt.setString(2, IDNum);
		this.stmt.setString(3, SeatNum);
		this.stmt.setString(4, FlightNum);
		if(this.stmt.executeUpdate()!=0) {
			flag=true;
		}
		return true;
	}
	@Override
	public Vector findAll(String IDNum)throws Exception{
		Vector rowData=new Vector();
		String sql="select * from ticket where idnum=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, IDNum);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			Ticket t=new Ticket();
			t.setTicketNum(rs.getString("TicketNum"));
			t.setIDNum(rs.getString("IDNum"));
			t.setSeatNum(rs.getString("SeatNum"));
			t.setFlightNum(rs.getString("FlightNum"));
			rowData.add(t);
		}
		return rowData;
	}
	@Override
	public boolean doRefund(String TicketNum)throws Exception{
		boolean flag=false;
		String sql="delete from ticket where ticketnum=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, TicketNum);
		if(this.stmt.executeUpdate()!=0) {
			flag=true;
		}
		return flag;
	}
}
