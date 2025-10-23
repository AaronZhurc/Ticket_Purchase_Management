package dao;

import java.sql.ResultSet;
import java.util.Vector;

import dbc.DBConnFactory;
import dbc.DatabaseConn;
import vo.Ticket;

public class TicketDAOProxy implements ITicketDAO {
	private DatabaseConn dbConn=null;
	private ITicketDAO dao=null;
	public TicketDAOProxy()throws Exception {
		dbConn=DBConnFactory.getDataBaseConnection();
		this.dao=new TicketDAOImpl(dbConn.getConnection());
	}
	@Override
	public boolean doBuy(String IDNum, String FlightNum, String SeatLocat) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			flag=dao.doBuy(IDNum, FlightNum, SeatLocat);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return flag;
	}
	@Override
	public Vector findAll(String IDNum)throws Exception{
		Vector rowData=null;
		try {
			rowData=this.dao.findAll(IDNum);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return rowData;
	}
	@Override
	public boolean doRefund(String TicketNum)throws Exception{
		boolean flag=false;
		try {
			flag=dao.doRefund(TicketNum);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return flag;
	}
}
