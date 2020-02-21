package book.chap08;

public class CarTest2 {
	//오른쪽엔 항상 왼쪽보다 하위 클래스가 와야 한다.
	public static void main(String[] args) {
		Car myCar 		= null;
		Tivoli herCar 	= new Tivoli();
		myCar 			= herCar;
		//결론:두 변수가 같은 주소번지를 갖는다.하나를 참조한다.
		System.out.println(myCar+", "+herCar);
		myCar.speed = 10;
		herCar.speed = 100;
		System.out.println(myCar.speed);
		System.out.println(herCar.speed);//두 변수가 가리키는 것이 하나다.********
		if(myCar instanceof Car) {
			System.out.println("myCar는 Car클래스 타입입니다.");
		}else {
			System.out.println("myCar는 Car클래스 타입이 아니다.");
		}
		if(herCar instanceof Car) {
			System.out.println("herCar는 Car클래스 타입입니다.");
		}
		if(herCar instanceof Tivoli) {
			System.out.println("herCar는 Tivoli클래스 타입입니다.");	
		}else {
			System.out.println("herCar는 Car클래스 타입이 아니다.");
		}
		//상속관계에서 부모의 타입도 가능 자신의 타입도 가능.****************************
	}
}
