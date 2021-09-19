package sugang.util;

import java.util.Scanner;

public class UserInput {
	//���� �Է� â�� ���ڸ� ġ�� ��쿡 ���� ����ó���� Ư���Ͽ� ��³����� �����Ͽ����ϴ�.
	private static Scanner sc = new Scanner(System.in);
	public static int inputInt(String st) {
		System.out.println(st+" �Է�>>");
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
		System.out.println(st+" �Է�>>");
		return sc.nextLine();
	}
}
