package book.chap08;

public class CarTest {
//오른쪽엔 항상 왼쪽보다 하위 클래스가 와야 한다.
	public static void main(String[] args) {
		//myCar로 접근할 수 있는 변수의 갯수는 몇 개 일까요? speed
		//myCar로 호출할 수 있는 메소드의 갯수는 몇 개 일까요? stop()
		//Car로 객체를 생성한 경우에는 메소드 한 개 변수 한 개만 호출 할 수 있어요.
		/* myCar의 타입이 Car타입이어서 Tivoli타입의 변수나 메소드는 한 개도 접근, 호출이
		 * 불가합니다.
		 * 이것은 new Tivoli()로 인스턴스화 한 경우에도 동일하게 적용됩니다.
		 * 다시 말하지만 타입이 Car타입이어서 생성부의 이름이 설사 Tivoli가 온다 하더라도
		 * Tivoli타입의 변수나 메소드는 접고, 호출이 불가하다는 것이죠.
		 * 이런 경우 메소드는 부모와 자식클래스 모두에 선언해 놓으면[메소드오버라이드] 호출은 가능합니다.
		 * 만일 부모에는 존재하고 자식에는 존재하지 않는 메소드의 경우 둘 다 무조건 부모메소드가 호출된다.
		 * 그러나 변수는...?
		 */
		Car myCar 		= new Car();
		System.out.println(myCar.speed);
		myCar.stop();
		myCar = null;			//반드시 널(=>이제 필요 없는 물건이야, 이제 버릴거야)로 처리한 다음에 인스턴스화 하게 되면 자바가상머신이 candidate(분리수거통에 넣은 상태)상태로 만들어 준다.메모리 관리.
		myCar = new Tivoli();	//윗라인에서 현라인으로 진행되는 과정에서 candidate상태가 됨(쓰레기값)
		System.out.println(myCar.speed);
		myCar.stop();			//Car에 있는 stop()가 Tivoli에도 있기 때문에[오버라이드] Tivoli의 stop()이 호출***********

		//herCar로 접근할 수 있는 변수의 갯수는 몇 개 일까요? carColor, volumn, speed
		//herCar로 호출할 수 있는 메소드의 갯수는 몇 개 일까요? volumnUp(), volumnDown(), stop()
		Tivoli herCar 	= null;
		//Car himCar 	= null;
	}
}
