package sugang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sugang.dto.RegisterDTO;
import sugang.util.DBConn;

public class Dao {
	String stid;
	public Dao(String id) {
		this.stid=id;
	}
	
	//메소드 이름 형식 : dml+테이블
	
//수강신청 : register 테이블에 새로운 레코드 추가
	public int insertReg(RegisterDTO dto) {
		int rValue=0;
		String sql = "insert into register values('"
				+dto.getStid()+"','"+dto.getCorid()+"',0)";
		rValue = DBConn.statementUpdate(sql);
		System.out.println("수강신청! : '"+sql+"'");
		return rValue;
	}
	
//수강철회 : register 테이블에서 로그인한 학생id + 사용자입력한 과목id 모두 일치하는 레코드 삭제
	public int deleteReg(String stid, String corid) {
		int rValue=0;
		String sql = "delete register where stid='"+stid+
				"' and corid='"+corid+"'";
		rValue = DBConn.statementUpdate(sql);
		System.out.println("수강철회! : '"+sql+"'");
		return rValue;
	}
		
//내역조회 : register 테이블에서 로그인한 학생id가 있는 레코드집합 출력
	//join을 이용해서 과목번호가 아닌 과목이름이 나오도록 출력해봅시다.
	public ArrayList<String> selectReg(String stid) {
		ArrayList<String> arr = new ArrayList<String>();
		String sql = "select course.corname from register, course "
			   +"where stid='"+stid+"' and course.corid=register.corid";
		System.out.println("의 수강신청 목록 : ");
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				arr.add(rs.getString(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	public String selectSt(String stid) {
		String stname=null;
		String sql = "select stname from student where stid='"+stid+"'";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				stname=rs.getString(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stname;
	}	

//개인정보 수정 : student 테이블 갱신
	public int updateSt(String column, String newA) {
		int rValue=0;
		String sql = "update student set %s='%s' where stid='"+stid+"'";
		sql = String.format(sql, column,newA);
		System.out.println("내 개인정보 수정 : '"+sql+"'");
		rValue = DBConn.statementUpdate(sql);
		return rValue;
	}
}
