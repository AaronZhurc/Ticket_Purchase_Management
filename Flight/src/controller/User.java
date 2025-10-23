package controller;

import java.awt.HeadlessException;

import dao.DAOFactory;
import dao.IPassDAO;
import dao.PassDAOProxy;

import vo.Passenger;

public class User {
	private static Passenger user;
	public static void setUser(String acc) {
		IPassDAO dao;
		try {
			dao=DAOFactory.getIPassDAOInstance();
			user=dao.findInfo(acc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Passenger getUser() {
		return user;
	}
}
