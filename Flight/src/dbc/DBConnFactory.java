package dbc;

public class DBConnFactory {
	public static DatabaseConn getDataBaseConnection() throws Exception{
        return new ODBConn();
    }
}
