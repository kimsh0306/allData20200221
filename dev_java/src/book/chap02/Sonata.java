package book.chap02;

/**********************************************************
  * 나는 클래스에서 변수의 선언 위치에 대해 말할 수 있다.
  * 클래스 선언한 바로 다음 자리 -전역변수
 **********************************************************/
public class Sonata {
	//전역 변수 위치
	String carColor = null; //참조형(reference type-주소번지 출력) 타입을 선언할 때 쓰는 예약어임.
	int speed;  //전역변수- 초기화를 생략할 수 있다.왜 안해도 되지? -생성자가 해주니깐...
	
	public static void main(String[] args) {
		//선언
		int wheelNum;  //지역변수-반드시 초기화를 해야 한다.
		//초기화
		//변수는 하나만 담을 수 있다.  동시에 두 개를 담을 수 없다. 초기화를 생략할 수 없다.
		wheelNum=0; 
		wheelNum=4; //기초+활용
		System.out.println(wheelNum); //실행하기 전에 예측해 보는 습관
		
		//carColor의 초기화를 빨강으로 초기화하시오
		//전역변수는 클래스 전역에서 사용할 수 있는데 왜 에러가 나는 걸까요?
		//carColor="red";  //[에러발생] static 필드에 사용할 수 없음
		Sonata sat = new Sonata(); //인스턴스화
		sat.carColor="red";  
		System.out.println(sat.carColor);
		//소나타 클래스 안에서 티볼리 안에 있는 변수나 메소드를 호출할 수 있다.
		sat.stop();
		System.out.println("스탑 메소드 호출 후 : "+sat.speed);
	}//end of main
	
	public void stop() {
		speed=0;
	}
}
