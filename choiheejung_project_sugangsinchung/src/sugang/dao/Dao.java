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
	
	//�޼ҵ� �̸� ���� : dml+���̺�
	
//������û : register ���̺� ���ο� ���ڵ� �߰�
	public int insertReg(RegisterDTO dto) {
		int rValue=0;
		String sql = "insert into register values('"
				+dto.getStid()+"','"+dto.getCorid()+"',0)";
		rValue = DBConn.statementUpdate(sql);
		System.out.println("������û! : '"+sql+"'");
		return rValue;
	}
	
//����öȸ : register ���̺��� �α����� �л�id + ������Է��� ����id ��� ��ġ�ϴ� ���ڵ� ����
	public int deleteReg(String stid, String corid) {
		int rValue=0;
		String sql = "delete register where stid='"+stid+
				"' and corid='"+corid+"'";
		rValue = DBConn.statementUpdate(sql);
		System.out.println("����öȸ! : '"+sql+"'");
		return rValue;
	}
		
//������ȸ : register ���̺��� �α����� �л�id�� �ִ� ���ڵ����� ���
	//join�� �̿��ؼ� �����ȣ�� �ƴ� �����̸��� �������� ����غ��ô�.
	public ArrayList<String> selectReg(String stid) {
		ArrayList<String> arr = new ArrayList<String>();
		String sql = "select course.corname from register, course "
			   +"where stid='"+stid+"' and course.corid=register.corid";
		System.out.println("�� ������û ��� : ");
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

//�������� ���� : student ���̺� ����
	public int updateSt(String column, String newA) {
		int rValue=0;
		String sql = "update student set %s='%s' where stid='"+stid+"'";
		sql = String.format(sql, column,newA);
		System.out.println("�� �������� ���� : '"+sql+"'");
		rValue = DBConn.statementUpdate(sql);
		return rValue;
	}
}
