package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import vo.Flight;

public class FlightDAOImpl implements IFlightDAO{
	private Connection conn=null;
	private PreparedStatement stmt=null;
	public FlightDAOImpl(Connection _conn) {
		this.conn=_conn;
	}
	@Override
	public Vector findDepart()throws Exception{
		Vector rowData=new Vector();
		String sql="select distinct departure from flight";
		this.stmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			rowData.add(rs.getString("departure"));
		}
		return rowData;
	}
	@Override
	public Vector findLand()throws Exception{
		Vector rowData=new Vector();
		String sql="select distinct landing from flight";
		this.stmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			rowData.add(rs.getString("landing"));
		}
		return rowData;
	}
	@Override
	public Vector findFlight(String depart,String land)throws Exception{
		Vector rowData=new Vector();
		String sql="select * from flight where departure=? and landing=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, depart);
		this.stmt.setString(2, land);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			Flight fli=new Flight();
			fli.setFlightNum(rs.getString("FlightNum"));
			fli.setAirline(rs.getString("Airline"));
			fli.setPlaneModel(rs.getString("PlaneModel"));
			fli.setDeparture(rs.getString("Departure"));
			fli.setLanding(rs.getString("Landing"));
			fli.setBoarding(rs.getString("Boarding"));
			fli.setDepartTime(rs.getTimestamp("DepartTime"));
			fli.setLandTime(rs.getTimestamp("LandTime"));
			fli.setSeatsQuan(rs.getInt("SeatsQuan"));
			fli.setPassengQuan(rs.getInt("PassengQuan"));
			rowData.add(fli.intoVector());
		}
		return rowData;
	}
	@Override
	public Flight findFlight(String FlightNum)throws Exception{
		Flight fli=new Flight();
		String sql="select * from flight where flightnum=?";
		this.stmt=this.conn.prepareStatement(sql);
		this.stmt.setString(1, FlightNum);
		ResultSet rs=this.stmt.executeQuery();
		while(rs.next()) {
			fli.setFlightNum(rs.getString("FlightNum"));
			fli.setAirline(rs.getString("Airline"));
			fli.setPlaneModel(rs.getString("PlaneModel"));
			fli.setDeparture(rs.getString("Departure"));
			fli.setLanding(rs.getString("Landing"));
			fli.setBoarding(rs.getString("Boarding"));
			fli.setDepartTime(rs.getTimestamp("DepartTime"));
			fli.setLandTime(rs.getTimestamp("LandTime"));
			fli.setSeatsQuan(rs.getInt("SeatsQuan"));
			fli.setPassengQuan(rs.getInt("PassengQuan"));
		}
		return fli;
	}
}
