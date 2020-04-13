package ex02variable;

/*
상수 : 저장된 값이 변하지 않는 메모리의 한종류
선언방법 : final 자료형 변수명 = 초기값;
- 상수는 딱 한번만 초기화되며, 중간에 값을 변경하면 에러발생됨
- 선언시 전체를 대문자로 선언하며 연결된 단어가 있을경우
	_(언더바)로 표현한다. 	
- 주로 프로그램내에서 코드의 가독성을 높여주기 위해 활용된다. 
 */
public class ConstantVar {

	public static void main(String[] args) {
		
		//상수를 선언함과 동시에 초기화
		final double PI = 3.14;		
		final int SCISSOR = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		
		System.out.println("PI(원주율)="+ PI);
		
		//상수는 한번 초기화되면 값을 변경할 수 없다. 
		//PI = 3.141592;
		
		//상수가 초기화되지 않은 상태에서 출력하면 에러발생됨.
		final String NICK_NAME;
		//System.out.println("우리는 "+ NICK_NAME);
		NICK_NAME = "코스모59기";
		System.out.println("우리는 "+ NICK_NAME);
		
		
		/*
		가위바위보 게임을 위해 개발자는 아래와 같이 결정하였다.
		가위 : 1, 바위 : 2, 보 : 3
		 */
		int computer, user;
		
		/*
		1, 3은 개발자 본인만 알수있는 내용이므로, 가독성이 떨어지는
		코드로 작성되었다. 즉 명시적이지 않은 코드.
		 */
		computer = 1;
		user = 3;
		System.out.println("컴퓨터가 이겼습니다.");
		
		/*
		PAPER와 같은 단어는 누가 보더라도 알수있으므로 가독성이 높은
		코드로 작성됨. 즉 명시적인 코드.
		 */
		computer = SCISSOR;
		user = PAPER;
		System.out.println("Computer Win");
		
		
		/*
		
		안녕하세요? 저는 "코스모"입니다.
		 */
		
		System.out.println("안녕하세요? 저는 \"코스모\"입니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
