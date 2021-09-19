package sugang.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IDConn {
	public static String logIn() {
		String resultID=null;
		System.out.println("<< OO대학교 학생을 위한 수강신청 DB입니다. >>");
		System.out.println("로그인할 학번을 입력해주세요.");
		while(resultID==null) {
			String input = UserInput.inputString("학번(stid)");
			String sql = "select stid from student where '"+input+"' in stid";
			try {
				ResultSet rs = DBConn.statementQuery(sql);
				if (rs.next()) {
					resultID=input;
					System.out.println(rs.getString(1)+" 학생으로 로그인되었습니다.");
				} else {
					resultID=null;
					System.out.println("해당하는 id가 없습니다! (대소문자, 일련번호 등을 확인하세요.)");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return resultID;
	}
}
