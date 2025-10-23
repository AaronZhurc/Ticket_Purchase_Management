package dao;

import java.util.Vector;

import vo.Seat;

public interface ISeatDAO {
	public Vector findEmpty(String FlightNum)throws Exception;//查询空座位
	public Seat findSeat(String SeatNum)throws Exception;//查询座位
	public float findPrice(String SeatNum)throws Exception;
}
