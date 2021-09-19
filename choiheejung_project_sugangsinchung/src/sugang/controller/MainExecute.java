package sugang.controller;

import java.util.ArrayList;

import sugang.dao.Dao;
import sugang.dto.*;
import sugang.util.*;

public class MainExecute {

	public static void main(String[] args) {
		
		DBConn.getInstance();
		System.out.println(".\n.\n.\n");
		boolean isLogInFlag = false;

		String stid = IDConn.logIn();
		if(stid!=null) {
			isLogInFlag = true;
		}
		System.out.println(".\n.\n.\n");
		
		Dao dao = new Dao(stid);

		while(isLogInFlag) {
			System.out.println("�л� �޴� : 1.������û 2.����öȸ 3.������ȸ 4.������������ 5.����");
			int menu = UserInput.inputInt("�޴�");
			switch(menu) {
			case(1) :
				System.out.println("������û�� �����մϴ�.");
				String corid1 = UserInput.inputString("�м���ȣ(����ID)");
				RegisterDTO dto = new RegisterDTO(stid, corid1);
				int rValue1 = dao.insertReg(dto);
				if(rValue1==1) {
					System.out.println("������û�� ���������� �Ϸ�Ǿ����ϴ�.");
				} else {
					System.out.println("������û�� ���������� �Ϸ���� ���߽��ϴ�!");
				}
				System.out.println();
				break;
			case(2) :
				System.out.println("����öȸ�� �����մϴ�.");
				String corid2 = UserInput.inputString("�м���ȣ(����ID)");
				int rValue2 = dao.deleteReg(stid, corid2);
				if(rValue2>0) {
					System.out.println("����öȸ�� ���������� �Ϸ�Ǿ����ϴ�.");
				} else {
					System.out.println("����öȸ�� ���������� �Ϸ���� ���߽��ϴ�!");
				}
				System.out.println();
				break;
			case(3) :
				System.out.println("������ȸ�� �����մϴ�.");
				System.out.print(dao.selectSt(stid));
				ArrayList<String> myreg=dao.selectReg(stid);
				if(myreg!=null) {
					for(String result : myreg) {
						System.out.println(result);
					}
					System.out.println("������ȸ�� �Ϸ�Ǿ����ϴ�.");
				}
				System.out.println();
				break;
			case(4) :
				System.out.println("�������������� �����մϴ�.");
				String column = UserInput.inputString("������ �׸� : name / phone");
				String newA = UserInput.inputString("������ ����");
				int rValue4 = dao.updateSt("st"+column, newA);
				if(rValue4==1) { 
					//���� 1���� ������ �����ϹǷ� ���⼭�� 1�� �ƴϸ� ���� �������Դϴ�.
					System.out.println("�������� ������ ���������� �Ϸ�Ǿ����ϴ�.");
				} else {
					System.out.println("�������� ������ ���������� �Ϸ���� ���߽��ϴ�!");
				}
				System.out.println();
				break;
			case(5) :
				System.out.println("������û�� �����մϴ�. �α׾ƿ��մϴ�.");
				isLogInFlag=false;
				break;
			default:
				System.out.println("Invalid Menu!");
				System.out.println();
			}
		}
		
		stid = null;
//		System.out.println(stid);
//		System.out.println(isLogInFlag);
		
		System.out.println("\n.\n.\n.");
		DBConn.dbClose();
	}
}
