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
			System.out.println("학생 메뉴 : 1.수강신청 2.수강철회 3.내역조회 4.개인정보수정 5.종료");
			int menu = UserInput.inputInt("메뉴");
			switch(menu) {
			case(1) :
				System.out.println("수강신청을 진행합니다.");
				String corid1 = UserInput.inputString("학수번호(과목ID)");
				RegisterDTO dto = new RegisterDTO(stid, corid1);
				int rValue1 = dao.insertReg(dto);
				if(rValue1==1) {
					System.out.println("수강신청이 정상적으로 완료되었습니다.");
				} else {
					System.out.println("수강신청이 정상적으로 완료되지 못했습니다!");
				}
				System.out.println();
				break;
			case(2) :
				System.out.println("수강철회를 진행합니다.");
				String corid2 = UserInput.inputString("학수번호(과목ID)");
				int rValue2 = dao.deleteReg(stid, corid2);
				if(rValue2>0) {
					System.out.println("수강철회가 정상적으로 완료되었습니다.");
				} else {
					System.out.println("수강철회가 정상적으로 완료되지 못했습니다!");
				}
				System.out.println();
				break;
			case(3) :
				System.out.println("내역조회를 진행합니다.");
				System.out.print(dao.selectSt(stid));
				ArrayList<String> myreg=dao.selectReg(stid);
				if(myreg!=null) {
					for(String result : myreg) {
						System.out.println(result);
					}
					System.out.println("내역조회가 완료되었습니다.");
				}
				System.out.println();
				break;
			case(4) :
				System.out.println("개인정보수정을 진행합니다.");
				String column = UserInput.inputString("수정할 항목 : name / phone");
				String newA = UserInput.inputString("수정할 내용");
				int rValue4 = dao.updateSt("st"+column, newA);
				if(rValue4==1) { 
					//본인 1명만의 정보를 수정하므로 여기서는 1이 아니면 전부 비정상입니다.
					System.out.println("개인정보 수정이 정상적으로 완료되었습니다.");
				} else {
					System.out.println("개인정보 수정이 정상적으로 완료되지 못했습니다!");
				}
				System.out.println();
				break;
			case(5) :
				System.out.println("수강신청을 종료합니다. 로그아웃합니다.");
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
