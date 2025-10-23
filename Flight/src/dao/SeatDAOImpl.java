package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import vo.Seat;

public class SeatDAOImpl implements ISeatDAO{
	private Connection conn=null;
	private PreparedStatement stmt=null;
	public SeatDAOImpl(Connection _conn) {
		this.conn=_conn;
	}
	@Override
	public Vector findEmpty(String FlightNum)throws Exception{
		Vector rowData=new Vector();
		String sql="select seatlocat from seat where flightnum=? and status=\'Пезљ\'";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, FlightNum);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			rowData.add(rs.getString("seatlocat"));
		}
		return rowData;
	}
	@Override
	public Seat findSeat(String SeatNum)throws Exception{
		Seat seat=new Seat();
		String sql="select * from seat where SeatNum=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, SeatNum);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			seat.setSeatNum(rs.getString("SeatNum"));
			seat.setSeatLevel(rs.getString("SeatLevel"));
			seat.setSeatLocat(rs.getString("SeatLocat"));
			seat.setStatus(rs.getString("Status"));
			seat.setFlightNum(rs.getString("FlightNum"));
			seat.setPrice(rs.getFloat("Price"));
		}
		return seat;
	}
	@Override
	public float findPrice(String SeatNum)throws Exception{
		float price = 0;
		String sql="select Price from seat where SeatNum=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, SeatNum);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			price=rs.getFloat("Price");
		}
		return price;
	}
}
