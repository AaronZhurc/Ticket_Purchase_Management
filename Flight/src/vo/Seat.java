package vo;

import java.util.Vector;

public class Seat {
	private String SeatNum;//座位号
    private String SeatLevel;//等级
    private String SeatLocat;//位置
    private float Price;//票价
    private String Status;//票价
    private String FlightNum;//航班号
    public void setSeatNum(String SeatNum) {
		this.SeatNum=SeatNum;
	}
	public String getSeatNum() {
		return this.SeatNum;
	}
	public void setSeatLevel(String SeatLevel) {
		this.SeatLevel=SeatLevel;
	}
	public String getSeatLevel() {
		return this.SeatLevel;
	}
	public void setSeatLocat(String SeatLocat) {
		this.SeatLocat=SeatLocat;
	}
	public String getSeatLocat() {
		return this.SeatLocat;
	}
	public void setPrice(float Price) {
		this.Price=Price;
	}
	public float getPrice() {
		return this.Price;
	}
	public void setStatus(String Status) {
		this.Status=Status;
	}
	public String getStatus() {
		return this.Status;
	}
	public void setFlightNum(String FlightNum) {
		this.FlightNum=FlightNum;
	}
	public String getFlightNum() {
		return this.FlightNum;
	}
}
