package vo;

import java.util.Vector;

public class Ticket {
	private String TicketNum;//»úÆ±±àºÅ
    private String IDNum;//Ö¤¼þºÅ
    private String SeatNum;//×ùÎ»ºÅ
    private String FlightNum;//º½°àºÅ
    public void setTicketNum(String TicketNum) {
		this.TicketNum=TicketNum;
	}
	public String getTicketNum() {
		return this.TicketNum;
	}
	public void setIDNum(String IDNum) {
		this.IDNum=IDNum;
	}
	public String getIDNum() {
		return this.IDNum;
	}
	public void setSeatNum(String SeatNum) {
		this.SeatNum=SeatNum;
	}
	public String getSeatNum() {
		return this.SeatNum;
	}
	public void setFlightNum(String FlightNum) {
		this.FlightNum=FlightNum;
	}
	public String getFlightNum() {
		return this.FlightNum;
	}
	public Vector intoVector() {
		Vector rowData=new Vector();
		rowData.add(TicketNum);
		rowData.add(IDNum);
		rowData.add(SeatNum);
		rowData.add(FlightNum);
		return rowData;
	}
}
