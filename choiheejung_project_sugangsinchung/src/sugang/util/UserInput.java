package sugang.util;

import java.util.Scanner;

public class UserInput {
	//정수 입력 창에 문자를 치는 경우에 대한 예외처리를 특정하여 출력내용을 지정하였습니다.
	private static Scanner sc = new Scanner(System.in);
	public static int inputInt(String st) {
		System.out.println(st+" 입력>>");
		String input=sc.nextLine();
		int result=0;
		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("only integer number allowed!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String inputString(String st) {
		System.out.println(st+" 입력>>");
		return sc.nextLine();
	}
}
