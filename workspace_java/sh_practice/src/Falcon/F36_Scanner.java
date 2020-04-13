package Falcon;

import java.util.Scanner;

public class F36_Scanner {

	public static void main(String[] args) {
		String source = "1 5 7";
		//String 인스턴스의 참조 값을 생성자로 전달하면서 Scanner인스턴스를 생성.
		//Scanner 인스턴스와 위의 문자열이 연결되었다.
//		Scanner sc = new Scanner(source);
		
		//System.in은 콘솔의 입력(사용자가)을 의미한다.
		Scanner sc = new Scanner(System.in);
		
		//nextInt메소드는 문자열에 저장되어 있는 데이터를 순서대로 int형으로 반환한다.
		//num1 => 1, num2 => 5, num3 => 7
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		int sum = num1 + num2 + num3;
		
		System.out.printf(
				"문자열에 저장된 %d %d %d의 합은 %d \n",
				num1, num2, num3, sum);
	}
}
