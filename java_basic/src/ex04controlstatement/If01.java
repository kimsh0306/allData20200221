package ex04controlstatement;

import java.io.IOException;

public class If01 {
	
	/*
	if문(조건문, 분기문)
		형식1
			if(조건문){
				실행문1;
				실행문2;
			}
		-if문의 조건문은 반드시 비교식 혹은 논리식이어야 한다.
		-즉 결과값이 boolean타입(true, false)이어야 한다. 
		-실행할 문장이 하나일때는 중괄호 생략이 가능하다. 
	 */
	public static void main(String[] args) throws IOException {
		
		int num = 10;	
		 
		//아래 문장은 조건식이 boolean이 아닌 산술식이므로 에러발생
//		if(num%2) {
//			System.out.println("잘못된 조건식입니다.");
//		}
//		if(num) {
//			System.out.println("이것도 잘못된 조건식입니다.");
//		}
	
		//if문의 조건은 아래와같이 boolean값을 반환하는 조건식이어야 한다.
		if(num%2==0) {
			System.out.printf("%d는 짝수입니다", num);
		}
		if(num%2==0 && num>=10) {
			System.out.printf("%n%d는 짝수이고 10보다 "
					+ "크거나같다.%n", num);
		}
		
		//경우에 따라 무조건 실행되는 if문도 필요함. 
		if(true) {
			System.out.println("무조건 실행되는 if문입니다.");
		}		
		
		/*
		if(조건식); => 조건식에 상관없이 다음 문장이 실행되는 형태로
			세미콜론은 문장의 끝을 나타내므로 사용에 주의해야 한다. 
		 */
		if(num%2 != 0); 		
		{
			System.out.printf("%d는 홀수입니다.", num);
		}

		/*
		조건검사후 실행할 문장이 하나인 경우에는 {} 중괄호를 
		생략할수 있다. 단, 실행문이 2개 이상인 경우에는 한문장만 
		실행되므로 의도치않은 결과가 나올수 있으므로 주의해야한다. 
		 */
		if(num%2 == 0) 
			System.out.println("\n"+ num +"은 짝수이다");
		
		if(num%2 != 0) { 
			System.out.println("num은 "+ num +"입니다.");
			System.out.println(num +"은 홀수입니다.");
		}
		

		/*
		System.in.read()
			: 사용자에게 하나의 문자를 입력받을때 사용하는 메소드로
			입력한 문자의 아스키코드값을 반환한다. 
			해당 함수는 기본적으로 IOException 예외를 가지고 있어서
			무시하기 위해 main()함수에서 throws 한다. (예외처리에서 학습할 내용)
		 */
		/*System.out.print("하나의 문자를 입력하세요:");
		int asciiCode = System.in.read();
		System.out.println("사용자가 입력한 문자의 아스키코드값:"
				+ asciiCode);
		System.out.println("사용자가 입력한 문자:"
				+ (char)asciiCode);*/





		
		/*
		시나리오] 사용자가 입력한 문자가 숫자인지 판단하는
		프로그램을 작성하시오. 
		 */
		System.out.print("문자 하나를 입력하세요:");
		int ascii = System.in.read();		
		//아스키코드값을 알고있을때..
		/*
			'0'의 아스키코드값 : 48
			'9'의 아스키코드값 : 57
			즉, 해당 값 사이에 있다면 숫자로 판단할수 있다. 
		*/
		if(ascii>=48 && ascii<=57) {
			System.out.println("입력한 문자는 숫자입니다");
		}
		else {
			System.out.println("입력한 문자는 숫자가 아닙니다.");
		} 
		//아스키코드값을 모를때...
		/*
		문자는 내부적으로 아스키코드로 저장되므로 아래와같은 비교연산이
		가능하다. 또한 산술연산도 가능하다. 
		 */
		boolean isNumber = (ascii>='0' && ascii<='9');
		if(isNumber) {
			System.out.println("입력한 문자는 숫자입니다");
		}
		else {
			System.out.println("입력한 문자는 숫자가 아닙니다.");
		}	
		
	}

}
