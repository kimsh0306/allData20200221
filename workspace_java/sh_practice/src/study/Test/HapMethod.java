package study.Test;

import java.util.Scanner;

/*
 * 숫자 두 개를 입력받고 그 두 수를 더해주는 메소드를 만들어라.
 * 받은 값을 출력해 주는 메소드를 만들어라.
 * 메인에서 첫 번째 메소드의 결과를 두 번째 메소드가 출력할 수 있게 하라.
 */

public class HapMethod {
	
	int hap(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	
	void print(int re) {
		System.out.println("두 수의 합은:"+re);
	}
	
	public static void main(String[] args) {
		HapMethod me = new HapMethod();
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("첫 번째 숫자를 입력하세요");
		int num1 = sc1.nextInt();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("두 번째 숫자를 입력하세요");
		int num2 = sc1.nextInt();	
		me.print(me.hap(num1,num2));
	}
}
