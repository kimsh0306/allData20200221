package book.chap02;

public class Tivoli {
	int speed = 0;
	
	void speedUp() {
		speed = speed + 1; //1
	}
	/*
	 *자바가상머신이 동작하는 순서대로 번호를 매겨볼까?
	    16(메인)-23(인스턴스)-24(출력)-25(초기화(30))-26(출력) 
	 */
	//entry point - 가장 먼저 실행되는 부분(메인메소드)
	public static void main(String[] args) {
		/*
		 * 문제제기
		 * non-static타입의 speed변수는 static이 있는 메인 메소드 안에서 접근이 불가
		 * 해결방법- 어떡하지? How
		 * 인스턴스화 하면 된다.
		 */
		Tivoli gnom = new Tivoli();  //인스턴스화
		System.out.println("gnom의 주소번지는 "+gnom); //주소번지 출력 @15db9742  16진수 표현 0~9 a~f=16개 (RGB#ff00ff)
		gnom.speed=30; //.다트연산자. 구분하기위해 Tivoli타입
		System.out.println(gnom.speed);
		gnom.speedUp();   
		System.out.println(gnom.speed);
	}
}
