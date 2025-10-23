package dao;

import java.util.Vector;

import dbc.DBConnFactory;
import dbc.DatabaseConn;
import vo.Flight;

public class FlightDAOProxy implements IFlightDAO {
	private DatabaseConn dbConn=null;
	private IFlightDAO dao=null;
	public FlightDAOProxy()throws Exception {
		dbConn=DBConnFactory.getDataBaseConnection();
		this.dao=new FlightDAOImpl(dbConn.getConnection());
	}
	@Override
	public Vector findDepart()throws Exception{
		Vector rowData=null;
		try {
			rowData=this.dao.findDepart();
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return rowData;
	}
	@Override
	public Vector findLand()throws Exception{
		Vector rowData=null;
		try {
			rowData=this.dao.findLand();
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return rowData;
	}
	@Override
	public Vector findFlight(String depart,String land)throws Exception{
		Vector rowData=null;
		try {
			rowData=this.dao.findFlight(depart, land);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return rowData;
	}
	@Override
	public Flight findFlight(String FlightNum)throws Exception{
		Flight fli=null;
		try {
			fli=this.dao.findFlight(FlightNum);
		} catch(Exception e) {
			throw e;
		} finally {
			dbConn.close();
		}
		return fli;
	}
}
