package dao;

import vo.Passenger;

public interface IPassDAO {
	public boolean doRegis(Passenger pass)throws Exception;//ע��
	public boolean findLogin(String acc,String pw)throws Exception;//��¼
	public Passenger findInfo(String acc)throws Exception;//��ѯ��Ϣ
	public boolean doMod(Passenger pass)throws Exception;//�޸���Ϣ
	public boolean doDel(Passenger pass)throws Exception;//ɾ����Ϣ
	public boolean findUser(Passenger pass)throws Exception;//���ע���ظ���

}
