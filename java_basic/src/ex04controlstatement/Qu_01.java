package ex04controlstatement;

import java.io.IOException;

/*
문제1] 파일명 : Qu_01.java
사용자로부터 한 문자를 입력받아 
숫자이면 "숫자",  알파벳(대문자 혹은 소문자)이면 "알파벳"을 출력하고, 
만약 둘다 아니라면 "듣보잡"을 출력하는 프로그램을 작성하시오.
단, 아스키코드값을 모른다고 가정한다. 

 */
public class Qu_01 {

	public static void main(String[] args) throws IOException {
		
		System.out.print("문자 하나를 입력하세요:");
		char ascii = (char)System.in.read();
		
		if(ascii>='0' && ascii<='9') {
			//숫자인지 판단
			System.out.println("숫자입니다.");
		}
		else if((ascii>='a' && ascii<='z') 
				|| (ascii>='A' && ascii<='Z')) {
			//알파벳인지 판단
			/*
			아스키코드가 65~90 또는 97~122사이라면 알파벳으로
			판단할 수 있다. 
			 */
			System.out.println("알파벳입니다.");
		}
		else {
			//둘다 아니면 듣보잡
			System.out.println("듣보잡입니다.");
		}
		

	}

}







