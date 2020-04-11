package Falcon;

import java.util.Scanner;

public class F35_TryCatch2 {
	public static void main(String[] args) {
		System.out.println("두 개의 정수를 입력: ");
		Scanner key = new Scanner(System.in);
		int num1 = key.nextInt();
		int num2 = key.nextInt();
		
		System.out.println("입력한 두 정수는: "+num1+","+num2);
		/**********************************************************
		 * try에서는 예외가 발생할 수 있는 위치를 뜻한다.
		 * catch는 예외를 처리하기 위한 곳을 뜻한다.
		 * 나눗셈에서 0으로 나누는 상황은 오류.
		 * 예시)7을 0으로 나누려고 하면 예외처리 되야한다.
		 */
		try {
			System.out.println("나눗셈의 결과 몫: "+(num1/num2));
			System.out.println("나눗셈의 결과 나머지: "+(num1%num2));
			System.out.println("정상적으로 나눗셈이 실행되었습니다.");
		} catch (ArithmeticException e) {
			System.out.println("나눗셈 불가능");
			//e.getMessage() => 각각 예외처리 마다 다른 결과 값이 나온다.
			System.out.println(e.getMessage());//나중에 설명***
		}
		System.out.println("프로그램이 종료되었습니다.");
		key.close();
		
		/******************************************* 대표적인 예외 상황
		 * (이미 약속된 예외처리 상황)
		 * 배열의 접근에 잘못된 인덱스 값을 사용하는 예외 상황
		 * ArrayIndexOutOfBoundsException
		 * 허용할 수 없는 형변환 연산을 진행하는 상황
		 * ClassCastException
		 * 배열 선언 과정에서 배열의 크기를 음수로 지정하는 예외 상황
		 * NegativeArraySizeException
		 * 참조변수가 null로 초기화 된 상태에서 메소드를 호출하는 상황
		 * NullPointerException
		 */
	}
}
