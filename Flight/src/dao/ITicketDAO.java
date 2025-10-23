package dao;

import java.util.Vector;

public interface ITicketDAO {
	public boolean doBuy(String IDNum,String FlightNum,String SeatLocat)throws Exception;//∂©∆±
	public Vector findAll(String IDNum)throws Exception;//œ‘ æÀ˘”–∂©∆±
	public boolean doRefund(String TicketNum)throws Exception;//ÕÀ∆±
}
