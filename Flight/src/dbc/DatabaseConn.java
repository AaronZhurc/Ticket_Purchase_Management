package dbc;

import java.sql.Connection;

public interface DatabaseConn {
	public Connection getConnection();
	public void close() throws Exception;
}
