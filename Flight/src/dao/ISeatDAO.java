package dao;

import java.util.Vector;

import vo.Seat;

public interface ISeatDAO {
	public Vector findEmpty(String FlightNum)throws Exception;//��ѯ����λ
	public Seat findSeat(String SeatNum)throws Exception;//��ѯ��λ
	public float findPrice(String SeatNum)throws Exception;
}
