package dao;

import java.util.Vector;

public interface ITicketDAO {
	public boolean doBuy(String IDNum,String FlightNum,String SeatLocat)throws Exception;//��Ʊ
	public Vector findAll(String IDNum)throws Exception;//��ʾ���ж�Ʊ
	public boolean doRefund(String TicketNum)throws Exception;//��Ʊ
}
