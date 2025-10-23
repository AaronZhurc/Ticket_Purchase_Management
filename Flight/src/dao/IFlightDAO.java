package dao;

import java.util.Vector;

import vo.Flight;

public interface IFlightDAO {
	public Vector findDepart()throws Exception;//返回起飞地
	public Vector findLand()throws Exception;//返回降落地
	public Vector findFlight(String depart,String land)throws Exception;//由起降返回航班信息
	public Flight findFlight(String FlightNum)throws Exception;//返回航班信息
}
