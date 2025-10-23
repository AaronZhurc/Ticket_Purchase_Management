package dao;

public class DAOFactory {
	public static IPassDAO getIPassDAOInstance()throws Exception{
		return new PassDAOProxy();
	}
	public static IFlightDAO getIFlightDAOInstance()throws Exception{
		return new FlightDAOProxy();
	}
	public static ISeatDAO getISeatDAOInstance()throws Exception{
		return new SeatDAOProxy();
	}
	public static ITicketDAO getITicketDAOInstance()throws Exception{
		return new TicketDAOProxy();
	}
}
