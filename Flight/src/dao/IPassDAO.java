package dao;

import vo.Passenger;

public interface IPassDAO {
	public boolean doRegis(Passenger pass)throws Exception;//注册
	public boolean findLogin(String acc,String pw)throws Exception;//登录
	public Passenger findInfo(String acc)throws Exception;//查询信息
	public boolean doMod(Passenger pass)throws Exception;//修改信息
	public boolean doDel(Passenger pass)throws Exception;//删除信息
	public boolean findUser(Passenger pass)throws Exception;//检查注册重复性

}
