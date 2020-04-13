package debug;
/*
 * **자바 복습할 내용**
 * 1.변수, 연산자, 제어문
 * 2.배열, 클래스
 * 3.클래스 쪼개기
 * 4.MVC패턴을 적용한 프로그램 작성
 * 5.JDBC 연동하기
 */
public class MethodTest {
	//선언부
	int i = 10;
	boolean isOk = false;
	//생성부
	public MethodTest(){
		
	}
	//패키지가 다를 때 public을 붙여줘야 접근할 수 있다.
	public boolean methodB(int a, int y) {
		if(a>y) {
			isOk = true;
		}else {
			isOk = false;
		}
		return isOk;
	}
	//메소드 선언부
	//일반 메소드에도 디버그 모드를 붙일 수 있다.
	//코드 디버깅: 프로그래밍 코드에서 오류를 찾고 수정하는 과정.
	void methodA(){
		i=30;
		i=i+10;
		System.out.println("i+:"+i);
	}
	
	//메인메소드
	public static void main(String[] args) {
		MethodTest mt = new MethodTest();
 		mt.methodA();
	}

}
