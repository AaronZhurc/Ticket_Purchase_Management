package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ODBConn implements DatabaseConn{
	private final static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private final static String name="C##USER1";
	private final static String pass="123456";
	private Connection connection=null;
	ODBConn(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			this.connection=DriverManager.getConnection(url,name,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
    public Connection getConnection(){
        return this.connection;
    }
    @Override
    public void close() throws Exception{
        if(this.connection != null){
            try{
                this.connection.close();
            }catch (Exception e){
                throw e;
            }
        }
    }
}
