package ex05method;

import java.util.Scanner;

/*
문제5-1) 파일명 : QuSimpleOperation.java (난이도:하)
두개의 정수를 입력받아서 사칙연산의 결과를 출력하는 메소드와 main메소드를 
작성해보자. 단 나눗셈은 몫과 나머지를 각각 출력해야 한다.
파라메타로 전달되는 두 숫자는 모두 0 이상의 양의 정수이다.
메소드명 : arithmetic()
 */
public class QuSimpleOperation {

	static void arithmetic(int a, int b) {
		System.out.printf("덧셈:%d + %d = %d\n",a,b,(a+b));
		System.out.printf("뺄셈:%d - %d = %d\n",a,b,(a-b));
		System.out.printf("곱셈:%d * %d = %d\n",a,b,(a*b));
		System.out.printf("나눗셈:%d / %d = %d\n",a,b,(a/b));
		System.out.printf("나머지:%d %% %d = %d\n",a,b,(a%b));
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요:");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요:");
		int num2 = sc.nextInt();

		arithmetic(num1, num2);
	}

}






