package ex01start;

public class SystemOutPrintln {

	public static void main(String[] args) {
		
		int num1 = 100;
		/*
		System.out.println() : 내용을 출력한 후 자동으로 줄바꿈 처리를 한다.
		System.out.print() : 출력후 줄바꿈처리를 하지않는다. 이때
			줄바꿈을 하고싶다면 \n을 추가한다. 
		System.out.printf() : 출력내용을 서식에 맞춰서 출력할때 사용하며,
		 	자체적은 줄바꿈기능은 없다. printf문에서는 줄바꿈을 위해 \n 과 %n
		 	두가지를 사용할 수 있다.
		 */
		System.out.println("num1="+ num1);		
		System.out.print("num1="+ num1 +"\n");		
		System.out.printf("num1=%d%n", num1);
		
		/*
		print()문에서 + 기호의 역할
		-숫자끼리는 실제 덧셈연산을 수행한다. 
		-문자열, 숫자, 변수 등 서로 성격이 다른 개체끼리는 연결해서 출력한다.
		 */
		//숫자(정수 or 실수)로 인식해서 해당 숫자를 출력		
		System.out.println(7);
		System.out.println(3.14);
		
		//숫자와 숫자로 인식하여 실제 덧셈연산의 결과를 출력
		System.out.println(3 + 5);
		System.out.println(3.5 + 5.1);
		
		//문자열과 숫자이므로 단순히 연결만해서 출력
		System.out.println("3+5="+ 8);
		System.out.println(3.15 +"는 실수입니다.");
		
		//성격이 동일한 문자열이지만 연산의 대상이 아니므로 연결해서 출력
		System.out.println("3+5" + " 의 연산결과는 8입니다.");
				
		//변수와 문자열을 연결해서 출력
		System.out.println("num1 은 "+ num1 +" 입니다.");	
		
	}

}
