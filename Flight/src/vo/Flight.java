package vo;

import java.util.Date;
import java.util.Vector;

public class Flight {
	private String FlightNum;//航班号
	private String Airline;//执飞航司
	private String PlaneModel;//机型
	private String Departure;//起飞机场
	private String Landing;//降落机场
	private String Boarding;//登机口
	private Date DepartTime;//起飞时间
	private Date LandTime;//降落时间
	private int SeatsQuan;//座位数
	private int PassengQuan;//乘客数
	public void setFlightNum(String FlightNum) {
		this.FlightNum=FlightNum;
	}
	public String getFlightNum() {
		return this.FlightNum;
	}
	public void setAirline(String Airline) {
		this.Airline=Airline;
	}
	public String getAirline() {
		return this.Airline;
	}
	public void setPlaneModel(String PlaneModel) {
		this.PlaneModel=PlaneModel;
	}
	public String getPlaneModel() {
		return this.PlaneModel;
	}
	public void setDeparture(String Departure) {
		this.Departure=Departure;
	}
	public String getDeparture() {
		return this.Departure;
	}
	public void setLanding(String Landing) {
		this.Landing=Landing;
	}
	public String getLanding() {
		return this.Landing;
	}
	public void setBoarding(String Boarding) {
		this.Boarding=Boarding;
	}
	public String getBoarding() {
		return this.Boarding;
	}
	public void setDepartTime(Date DepartTime) {
		this.DepartTime=DepartTime;
	}
	public Date getDepartTime() {
		return this.DepartTime;
	}
	public void setLandTime(Date LandTime) {
		this.LandTime=LandTime;
	}
	public Date getLandTime() {
		return this.LandTime;
	}
	public void setSeatsQuan(int SeatsQuan) {
		this.SeatsQuan=SeatsQuan;
	}
	public int getSeatsQuan() {
		return this.SeatsQuan;
	}
	public void setPassengQuan(int PassengQuan) {
		this.PassengQuan=PassengQuan;
	}
	public int getPassengQuan() {
		return this.PassengQuan;
	}
	public Vector intoVector() {
		Vector row=new Vector();
		row.add(FlightNum);
		row.add(Airline);
		row.add(PlaneModel);
		row.add(Departure);
		row.add(Landing);
		row.add(Boarding);
		row.add(DepartTime);
		row.add(LandTime);
		row.add(SeatsQuan);
		row.add(PassengQuan);
		return row;
	}
}
