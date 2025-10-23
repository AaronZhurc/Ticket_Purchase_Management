package dao;

import java.util.Vector;

import vo.Flight;

public interface IFlightDAO {
	public Vector findDepart()throws Exception;//������ɵ�
	public Vector findLand()throws Exception;//���ؽ����
	public Vector findFlight(String depart,String land)throws Exception;//���𽵷��غ�����Ϣ
	public Flight findFlight(String FlightNum)throws Exception;//���غ�����Ϣ
}
