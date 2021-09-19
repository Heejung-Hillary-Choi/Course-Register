package sugang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DBConn {

	private DBConn() {}
	private static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	public static Connection getInstance() {
		if(dbConn==null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String id = "human";
				String pw = "human";
				dbConn = DriverManager.getConnection(url,id,pw);
				System.out.println("DB Connected...");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(dbConn!=null) dbConn.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null; st=null; dbConn=null;
			System.out.println("DB Fully Closed.");
		}
	}
	public static int statementUpdate(String sql) {
		//insert, update, delete
		int rValue=-1;
		if(dbConn!=null) {
			try {
				if(st==null) {
					st=dbConn.createStatement();
				}
				rValue=st.executeUpdate(sql);
			}catch (SQLIntegrityConstraintViolationException e) {
				//외래키에 관한 내용은 출력 내용을 따로 지정해준다! *******************************
				//oracle에서 사전에 외래키를 지정해두었으므로, parent key 를 참조할 수 없으면 오류 발생!
				//java.sql.SQLIntegrityConstraintViolationException: ORA-02291: parent key not found
				//java.sql.SQLIntegrityConstraintViolationException: ORA-00001: unique constraint violated
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("not connected...");
		}
		return rValue;
	}
	public static ResultSet statementQuery(String sql) {
		//select
		if(dbConn!=null) {
			try {
				if(st==null) {
					st=dbConn.createStatement();
				}
				rs=st.executeQuery(sql);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("not connected...");
		}
		return rs;
	}
}
