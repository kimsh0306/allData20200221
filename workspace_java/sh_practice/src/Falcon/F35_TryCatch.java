package Falcon;

import java.util.Scanner;

public class F35_TryCatch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~100까지의 숫자를 입력하세요: ");
		int num = sc.nextInt();
		
		//if문을 이용한 예외처리
		if(num<1 || num>100) {
			System.out.println("1이상 100이하의 값이 아닙니다.");
		}
	}

}
