package vo;

import java.util.Date;
import java.util.Vector;

public class Flight {
	private String FlightNum;//�����
	private String Airline;//ִ�ɺ�˾
	private String PlaneModel;//����
	private String Departure;//��ɻ���
	private String Landing;//�������
	private String Boarding;//�ǻ���
	private Date DepartTime;//���ʱ��
	private Date LandTime;//����ʱ��
	private int SeatsQuan;//��λ��
	private int PassengQuan;//�˿���
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
