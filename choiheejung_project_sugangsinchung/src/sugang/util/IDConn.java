package sugang.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IDConn {
	public static String logIn() {
		String resultID=null;
		System.out.println("<< OO���б� �л��� ���� ������û DB�Դϴ�. >>");
		System.out.println("�α����� �й��� �Է����ּ���.");
		while(resultID==null) {
			String input = UserInput.inputString("�й�(stid)");
			String sql = "select stid from student where '"+input+"' in stid";
			try {
				ResultSet rs = DBConn.statementQuery(sql);
				if (rs.next()) {
					resultID=input;
					System.out.println(rs.getString(1)+" �л����� �α��εǾ����ϴ�.");
				} else {
					resultID=null;
					System.out.println("�ش��ϴ� id�� �����ϴ�! (��ҹ���, �Ϸù�ȣ ���� Ȯ���ϼ���.)");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return resultID;
	}
}
