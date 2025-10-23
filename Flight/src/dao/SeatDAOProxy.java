package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import dbc.DBConnFactory;
import dbc.DatabaseConn;
import vo.Seat;

public class SeatDAOProxy implements ISeatDAO {
	private DatabaseConn dbConn=null;
	private ISeatDAO dao=null;
	public SeatDAOProxy()throws Exception {
		dbConn=DBConnFactory.getDataBaseConnection();
		this.dao=new SeatDAOImpl(dbConn.getConnection());
	}
	@Override
	public Vector findEmpty(String FlightNum)throws Exception{
		Vector rowData=null;
		try {
			rowData=this.dao.findEmpty(FlightNum);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return rowData;
	}
	@Override
	public Seat findSeat(String SeatNum)throws Exception{
		Seat seat=new Seat();
		try {
			seat=this.dao.findSeat(SeatNum);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return seat;
	}
	@Override
	public float findPrice(String SeatNum)throws Exception{
		float price=0;
		try {
			price=this.dao.findPrice(SeatNum);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return price;
	}
}
