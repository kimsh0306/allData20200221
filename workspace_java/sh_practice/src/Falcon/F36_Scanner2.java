package Falcon;

import java.util.Scanner;

public class F36_Scanner2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름은: ");
		//문자열이기 때문에 String인 nextLine을 통해서 문자열을 입력 받는다.
		String str = sc.nextLine();
		System.out.println("안녕하세요 "+str+"님.");
		
		System.out.print("당신의 나이는: ");
		//나이는 정수형이기 때문에 nextInt를 통해서 입력 받는다.
		int nAge = sc.nextInt();
		System.out.println("당신의 나이는 "+nAge+"입니다.");
		//더이상 Scanner 클래스를 사용할 일이 없다.
		sc.close();
	}
}
