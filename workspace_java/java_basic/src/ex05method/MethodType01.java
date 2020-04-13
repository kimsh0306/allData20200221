package ex05method;

/*
Method(메소드) : 객체지향 프로그램에서 행동 또는 동작을 의미한다.
	즉 어떤일을 처리하는 하나의 모듈(부속품)이라 정의할수 있다.
	-메소드는 반드시 class안에 정의해야한다.
	-메소드안에 다른 메소드를 정의할수 없다.
	-정의할때 반드시 반환타입을 명시해야한다. 만약 반환값이 없다면
	void로 정의한다. 
	-이름의 규칙은 변수명과 동일하다. 소문자로 시작하는 변형된 
	camel case를 사용한다. (Ex : simpleFunc(), addCalculate() 등)
	
	JAVA에서의 Naming Rule(이름규칙)
	-클래스명 : SimpleFunc -> 대문자로 시작하는 Camel case
	-메소드명 혹은 변수명 : simpleFunc() simpleFunc
	-상수 : SIMPLE_FUNC -> 전체를 대문자로 작성
	-패키지명 : simplefunc -> 전체를 소문자로 작성
 */
public class MethodType01 {
	
	/*
	[메소드형식1] 매개변수도 없고 반환값도 없는 경우
		: 해당 형식은 주로 출력을 담당하는 경우 사용된다. 
		반환타입은 반드시 void로 명시해야 한다. 
	 */

	static void noParamNoReturn() {
		System.out.println("==메뉴를 선택하세욤==");
		System.out.println("1.열기, 2.계속하기, 3.종료");
		System.out.println("=====================");
	}
	
	/*
	동일 클래스내에서 메소드명의 중복은 불가능하다. 
	단, 메소드명은 동일하나 매개변수의 갯수 혹은 타입을 달리하여
	중복을 허용하는 문법을 "메소드 오버로딩(Overloading)"이라
	한다. 즉 완전히 똑같은 형태의 정의는 불가능하다. 
	 */
	static void noParamNoReturn2() {
		//함수의 몸체가 없는 경우도 있음
	}	
	static void noParamNoReturn2(int a) {
		//동일한 이름의 함수가 선언되었음. 단 매개변수의 갯수는 다름.
	}
	
	static void noParamNoReturn3() {
		int returnValue = 89;
		System.out.println("[Return문 이전]");
		
		//return;
		/*
		위와같이 함수 중간에 return을 쓰게되면 함수의 종료(소멸)을
		의미하므로 그 아래 문장은 실행되지 않는 코드가 된다. 
		따라서 에러가 발생하므로 아래와 같이 조건에 따라 실행결과가
		달라질수 있는 형태로 작성해야 한다. 
		 */	
		if(returnValue%2==0) {
			System.out.println(returnValue +"는 짝수");
			return;
		}
		
		System.out.println(returnValue +"는 홀수");
		System.out.println("[return문 이후]");
	}
	
	public static void main(String[] args) {
		noParamNoReturn();
		noParamNoReturn2();
		noParamNoReturn3();
	}
}
