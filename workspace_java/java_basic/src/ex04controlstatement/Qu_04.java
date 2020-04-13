package ex04controlstatement;

import java.io.IOException;

public class Qu_04 {

	public static void main(String[] args) throws IOException {

		System.out.print("하나의 문자를 입력하세요:");
		int inputChar = System.in.read();
		
		/*
		삼항연산자 형식 : 
		변수 = (조건식) ? 참일때값 : 거짓일때값;
		*/
		String resultStr = (inputChar>='0' && inputChar<='9') ? 
				"숫자입니다" : "숫자가아닙니다";
		System.out.println(resultStr);	
	}

}



