package ex05method;

import java.io.IOException;
import java.util.Scanner;

/*
시나리오] 사용자로부터 두개의 정수와 산술연산자를 입력받아서
연산결과를 반환하는 메소드를 작성하시오.
그리고 사용자가 입력한 연산자를 리턴받아 출력하시오.
입력예)
	정수1을 입력하세요 : 100
	정수2를 입력하세요 : 200
	산술연산자를 입력하세요.(+,-,*,/,%) : +
	연산결과 : 100 + 200 = 300
정수입력은 Scanner클래스를 산술연산자 입력은 read()메소드 사용할것.
 */
public class MethodType02_3 {

	public static void main(String[] args) throws IOException {		
		
		String r = numArith();
		System.out.println("연산결과:"+ r);
	}
	
	static String numArith() throws IOException {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수1:");
		int num1 = scan.nextInt();
		System.out.print("정수2:");
		int num2 = scan.nextInt();
		System.out.print("산술연산자를 입력하세요:");
		char oper = (char)System.in.read();
		
		//결과반환용 변수
		String result;
		
		switch(oper) {
		case '+':			
			result = num1 +"+"+ num2 +"="+ (num1+num2);
			break;
		case '-':
			result = num1 +"-"+ num2 +"="+ (num1-num2);
			break;
		case '*':
			result = num1 +"*"+ num2 +"="+ (num1*num2);
			break;
		case '/':
			result = num1 +"/"+ num2 +"="+ (num1/num2); 
			break;
		case '%':
			result = num1 +"%"+ num2 +"="+ (num1%num2);
			break;
		default:
			//System.out.println("연산자가 잘못되었습니다.");
			result = "연산자가 잘못되었습니다";
		}
		
		return result;
	}//end of numArith
}
